package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import java.time.LocalDate;

public interface Cancelacion {

	public abstract double calcularMontoAReembolsar (Reserva r, LocalDate fecha);
}
