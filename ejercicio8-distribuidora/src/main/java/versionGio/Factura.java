package versionGio;

import java.time.LocalDate;

public class Factura {

	private double monto;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	//CONSTRUCTOR
	public Factura (double unMonto, double unDescuento, Usuario unUsuario) {
		this.monto = unMonto;
		this.descuento = unDescuento;
		this.fecha = LocalDate.now();
		this.usuario = unUsuario;
	}
	
	public double getMontoTotal () {
		return (this.monto - (this.monto * (this.descuento/100)));
	}
	
	public Usuario getUsuario () {
		return this.usuario;
	}
	
	public LocalDate getFecha (){
		return this.fecha;
	}
	
	//El descuento del pfe entra como 0.1
	public double getDescuento () {
		return this.descuento;
	}
}
