package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

public class Producto {

	private String nombre;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	public Producto (String n, String desc, Double precio, Integer cant) { 
		this.nombre = n;
		this.descripcion = desc;
		this.precio = precio;
		this.stock = cant;
	}

	public boolean mismoNombre(String nombre2) {
		return this.nombre.equals(nombre2);
	}

	public boolean hayStock(Integer cant2) {
		return (this.stock >= cant2);
	}

	public void restarStock(Integer cant2) {
		this.stock -= cant2;
		
	}

	public Double valor() {
		return this.precio;
	}
}
