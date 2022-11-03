package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaLocal extends Llamada{

	public LlamadaLocal (LocalDate unaFecha, LocalTime unaHora, Integer unaDuracion, String unReceptor) {
		super(unaFecha, unaHora, unaDuracion, unReceptor);
	}
	
	public double calcularCosto() {
		double costo = 1;
		return super.getDuracion() * costo;
	}
}
