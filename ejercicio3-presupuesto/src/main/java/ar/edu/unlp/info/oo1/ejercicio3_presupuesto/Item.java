package ar.edu.unlp.info.oo1.ejercicio3_presupuesto;

public class Item {
	private String detalle;
	private int cantidad;
	private double costoUnitario;
	public String getDetalle() {
		return detalle;
	}
	
	public Item () {
		
	}
	/******************************************/
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public Item detalle(String detalle) {
		this.setDetalle(detalle);
		return this;
	}
	/******************************************/
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Item cantidad(int cantidad) {
		this.setCantidad(cantidad);
		return this;
	}
	/******************************************/
	public double getCostoUnitario() {
		return costoUnitario;
	}
	public void setCostoUnitario(double costoUnitario) {
		this.costoUnitario = costoUnitario;
	}
	public Item costoUnitario(int costoUnitario) {
		this.setCostoUnitario(costoUnitario);
		return this;
	}
	
	public double costo () {
		
		return (this.getCantidad() * this.getCostoUnitario());
	}
}
