package ar.edu.unlp.info.oo1.balanzaElectronica;

import java.util.*;

public class Balanza {

	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List <Producto> productos;
	
	public Balanza () {
		this.ponerEnCero();		
	}
	
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void setPesoTotal(double pesoTotal) {
		this.pesoTotal = pesoTotal;
	}

	
	
	public void ponerEnCero() {
		this.setCantidadDeProductos(0);
		this.setPesoTotal(0);
		this.setPrecioTotal(0);
		this.productos = new ArrayList <Producto>();
	}
	
	public void agregarProducto (Producto unProducto) {
		this.setCantidadDeProductos(this.getCantidadDeProductos() + 1);
		this.setPesoTotal(this.getPesoTotal() + unProducto.getPeso());
		this.setPrecioTotal(this.getPrecioTotal() + unProducto.getPrecio());
		this.productos.add(unProducto);
		
	}
	
	public Ticket emitirTicket() {
		
		Ticket tick = new Ticket();
		
		tick.setCantidadDeProductos(this.getCantidadDeProductos());
		tick.setPesoTotal(tick.getPesoTotal() + this.getPesoTotal());
		tick.setPrecioTotal(tick.getPrecioTotal() + this.getPrecioTotal());
		tick.setListaProductos(this.getProductos());
		
		return tick;
		
	}
	
	public List<Producto> getProductos() {
		return this.productos;
	}
	
}
