package examenOO1.parcial1erFecha;

import java.time.LocalDate;

public class Automovil extends Vehiculo {

	private String marca;
	private String modelo;
	
	public Automovil (String unaP, LocalDate unaF, Double unV, String unaMar, String unMod) {
		super(unaP, unaF, unV);
		this.marca = unaMar;
		this.modelo = unMod;
	}
	
	public Double valorImpuesto() {
		return (this.valor * 0.05);
	}
	
}
