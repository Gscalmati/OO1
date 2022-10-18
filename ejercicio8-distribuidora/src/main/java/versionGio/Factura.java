package versionGio;

import java.time.LocalDate;

public class Factura {

	private double montoEnergiaActiva;
	private double descuento;
	private LocalDate fecha;
	private Usuario usuario;
	
	private double montoTotal () {
		return 0.0;
	}
	
	private Usuario usuario () {
		return this.usuario;
	}
	
	private LocalDate fecha (){
		return this.fecha;
	}
	
	private double descuento () {
		return this.descuento;
	}
}
