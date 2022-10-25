package ar.edu.unlp.info.oo1.ejercicio9_cuentaConGanchos;

public class CuentaCorriente extends Cuenta {
	
	private double descubiertoTotal;
	
	//Son necesarios los constructores llamando a super () ?
	public CuentaCorriente () {
		super();
		this.descubiertoTotal = 0;
	}
	
	public CuentaCorriente (double unDescubierto) {
		super();
		this.descubiertoTotal = (unDescubierto * -1);
	}

	public double getDescubiertoTotal() {
		return descubiertoTotal;
	}

	public void setDescubiertoTotal(double unDescubierto) {
		this.descubiertoTotal = (unDescubierto * -1);
	}
	
	protected boolean puedeExtraerCC (double monto) {
		boolean resp = false;
		if ((this.getSaldo() >= monto) || (this.getSaldo() - monto >= this.descubiertoTotal)) {
			//SI EL MONTO SUPERA EL DESCUBIERTO....) {
			resp =  true;
		}
		return resp;
	}
	
	public boolean extraer (double monto) {
		if (this.puedeExtraerCC(monto)) {
			this.extraerSinControlar(monto);
			return true;
		}
		return false;
	}
	
	public boolean transferirACuenta (double monto, Cuenta cuentaDestino) {
		if (this.puedeExtraerCC(monto)) {
			this.extraerSinControlar(monto);
			cuentaDestino.depositar(monto);
			return true;
		}
		return false;
	}
	
	
	
	
}
