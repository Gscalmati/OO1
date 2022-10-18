package versionGio;

import java.time.LocalDate;

public class Consumo {
	private LocalDate fecha;
	private double consumoEnergiaActiva;
	private double consumoEnergiaReactiva;
	
	
	public double costoEnBaseA (double precioKWh) {
		return 0.0;
	}
	
	public double factorDePotencia () {
		return (this.consumoEnergiaActiva / (Math.sqrt(Math.pow(consumoEnergiaReactiva, 2)+Math.pow(consumoEnergiaActiva, 2))));
	}
}
