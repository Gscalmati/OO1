package versionGio;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	public Consumo (LocalDate unaFecha, double unConsumoEActiva, double unConsumoEReactiva) {
		this.fecha = unaFecha;
		this.consumoEnergiaActiva = unConsumoEActiva;
		this.consumoEnergiaReactiva = unConsumoEReactiva;
	}
	
	public double costoEnBaseA (double precioKWh) { 
		return this.consumoEnergiaActiva * precioKWh;
	}
	
	public double factorDePotencia () {
		return (this.consumoEnergiaActiva / (Math.sqrt(Math.pow(consumoEnergiaReactiva, 2)+Math.pow(consumoEnergiaActiva, 2))));
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public double getConsumoEnergiaActiva() {
		return consumoEnergiaActiva;
	}

	public double getConsumoEnergiaReactiva() {
		return consumoEnergiaReactiva;
	}
	
	
}
