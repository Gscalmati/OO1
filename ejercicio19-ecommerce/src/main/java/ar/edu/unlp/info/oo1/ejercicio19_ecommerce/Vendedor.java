package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

import java.util.ArrayList;

public class Vendedor extends Usuario {

	private ArrayList<Producto> productos;
	
	public Vendedor (String n, String d, String t) {
		super(n, d, t);
		this.productos = new ArrayList<Producto>();
	}
	
	public void agregarProducto (Producto p) {
		this.productos.add(p);
	}
}
