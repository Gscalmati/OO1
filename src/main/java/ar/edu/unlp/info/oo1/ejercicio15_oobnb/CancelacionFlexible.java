package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import java.time.LocalDate;

public class CancelacionFlexible implements Cancelacion{
	
	public double calcularMontoAReembolsar (Reserva r, LocalDate fecha) {
		if (fecha.isBefore(r.getIn())) {
			return r.calcularPrecio();
		}
		return 0;
	}
	
	
}
