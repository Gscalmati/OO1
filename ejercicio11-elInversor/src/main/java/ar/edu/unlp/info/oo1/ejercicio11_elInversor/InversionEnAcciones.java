package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

public class InversionEnAcciones extends Inversion {

	private String nombre;
	private int cantidad;
	private double valorUnitario;
	
	public InversionEnAcciones (String unNombre, int unaCant, double unValor) {
		this.nombre = unNombre;
		this.cantidad = unaCant;
		this.valorUnitario = unValor;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public double valorActual() {
		return (this.cantidad * this.valorUnitario);
	}
	
	
}
