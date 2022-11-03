package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

public class NumeroTel {

	private String numero;
	private boolean estado;
	
	public NumeroTel (String num) {
		this.numero = num;
		this.estado = false;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public boolean isEstado() {
		return estado;
	}
	
	public void asignar () {
		this.estado = true;
	}
	
}
