package versionGio;

import java.time.LocalDate;

public class Factura {

	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	//CONSTRUCTOR
	public Factura (double unMonto, double unDescuento, Usuario unUsuario) {
		this.montoEnergiaActiva = unMonto;
		this.descuento = unDescuento;
		this.fecha = LocalDate.now();
		this.usuario = unUsuario;
	}
	
	private double montoTotal () {
		return (this.montoEnergiaActiva - (this.montoEnergiaActiva * this.descuento));
	}
	
	private Usuario usuario () {
		return this.usuario;
	}
	
	private LocalDate fecha (){
		return this.fecha;
	}
	
	//El descuento del pfe entra como 0.1
	private double descuento () {
		return this.descuento;
	}
}
