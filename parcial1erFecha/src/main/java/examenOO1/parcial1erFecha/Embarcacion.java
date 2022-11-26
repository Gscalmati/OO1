package examenOO1.parcial1erFecha;

import java.time.LocalDate;

public class Embarcacion extends Vehiculo {

	private String nombre;
	private final Integer limite = 1000000;
	
	
	public Embarcacion (String unaP, LocalDate unaF, Double unV, String unNom) {
		super(unaP, unaF, unV);
		this.nombre = unNom;
	}
	
	public Double valorImpuesto() {
		if (this.valor > this.limite) {
			return this.valor * 0.15;
		} else {
			return this.valor * 0.1;
		}
	}
	
}
