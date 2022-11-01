package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import java.time.LocalDate;

public class CancelacionModerada implements Cancelacion{
	
	public double calcularMontoAReembolsar (Reserva r, LocalDate fecha) {
		if (fecha.isBefore(r.getIn().minusDays(7))) {
			return r.calcularPrecio();
		} else {
			if (fecha.isBefore(r.getIn().minusDays(2))) {
				return (r.calcularPrecio()/2);
			}
		}
		return 0;
	}
	
	
}
