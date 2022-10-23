package ar.edu.unlp.info.oo1.ejercicio9_cuentaConGanchos;

public class CajaDeAhorro extends Cuenta {
	
	private double costoTransaccion = 2;
	
	//Son necesarios los constructores llamando a super () ?
	public CajaDeAhorro () {
		super();
	}

	public double getCostoTransaccion() {
		return costoTransaccion;
	}

	public void setCostoTransaccion(double costoTransaccion) {
		this.costoTransaccion = costoTransaccion;
	}

	protected double sumarCostoTransaccion(double monto) {
		return (monto + (monto * this.getCostoTransaccion()/100));
	}
	
	protected double restarCostoTransaccion(double monto) {
		return (monto - (monto * this.getCostoTransaccion()/100));
	}
	
	public boolean transferirACuenta (double monto, Cuenta cuentaDestino) {
		return super.transferirACuenta(this.sumarCostoTransaccion(monto), cuentaDestino);
	}
	
	public void depositar (double monto) {
		super.depositar(this.restarCostoTransaccion(monto));
	};
	
	public boolean extraer (double monto) {
		return super.extraer(this.sumarCostoTransaccion(monto));
	}
	
}
