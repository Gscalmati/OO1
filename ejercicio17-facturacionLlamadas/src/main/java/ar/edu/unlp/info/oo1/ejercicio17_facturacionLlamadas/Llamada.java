package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Llamada {
	private LocalDate fecha;
	private LocalTime horaInicio;
	private Integer duracion;
	private String receptor;
	
	public Llamada (LocalDate unaFecha, LocalTime unaHora, Integer unaDuracion, String unReceptor) {
		this.fecha = unaFecha;
		this.horaInicio = unaHora;
		this.duracion = unaDuracion;
		this.receptor = unReceptor;
	}
	
	
	
	
	public LocalDate getFecha() {
		return fecha;
	}

	public Integer getDuracion() {
		return duracion;
	}
	
	public LocalTime getHoraInicio () {
		return horaInicio;
	}



	public abstract double calcularCosto();
}
