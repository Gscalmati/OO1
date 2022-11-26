package examenOO1.parcial1erFecha;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Vehiculo implements Bien {
		
	private String patente;
	private LocalDate fecha;
	protected Double valor;
	
	public Vehiculo (String unaP, LocalDate unaF, Double unV) {
		this.patente = unaP;
		this.fecha = unaF;
		this.valor = unV;
	}
	
	public Double calcularImpuesto() {
		if (ChronoUnit.YEARS.between(fecha, LocalDate.now()) > 10) {
			return 0.0;
		} else {
			return this.valorImpuesto();
		}
	}
	
	public abstract Double valorImpuesto();
	
	
}
