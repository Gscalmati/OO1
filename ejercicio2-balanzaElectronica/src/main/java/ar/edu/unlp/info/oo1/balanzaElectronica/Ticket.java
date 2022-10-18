package ar.edu.unlp.info.oo1.balanzaElectronica;

//Program to demonstrate methods of Date class
import java.time.LocalDate;
import java.util.List;

public class Ticket {
	
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List <Producto> productos;
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public void setCantidadDeProductos(int cantidadDeProductos) {
		this.cantidadDeProductos = cantidadDeProductos;
	}
	
	public void setListaProductos(List <Producto> unosProductos) {
		this.productos = unosProductos;
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

	public Ticket () {
		LocalDate fecha = LocalDate.now();
		this.setFecha(fecha);
		this.setCantidadDeProductos(0);
		this.setPesoTotal(0);
		this.setPrecioTotal(0);
	}
	
	public double impuesto () {
		 return (this.getPrecioTotal() * 0.21);
	}
	
	public List<Producto> getProductos() {
		return this.productos;
	}
	

}
