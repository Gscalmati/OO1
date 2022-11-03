package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada {
	
	private String paisOrigen;
	private String paisDestino;
	
	public LlamadaInternacional (LocalDate unaFecha, LocalTime unaHora, Integer unaDuracion, String unReceptor, double unaDistancia, String unPaisO, String unPaisD) {
		super(unaFecha, unaHora, unaDuracion, unReceptor);
		this.paisOrigen = unPaisO;
		this.paisDestino = unPaisD;
	}
	
	public double calcularCosto () {
		if (this.horarioNocturno()) {
			return (super.getDuracion() * 3);
		}
		return (super.getDuracion() * 4);
	}
	
	private boolean horarioNocturno () {
		if (super.getHoraInicio().isAfter(LocalTime.of(20, 0)) && (super.getHoraInicio().isBefore(LocalTime.of(8, 0)))) {
			return true;
		}
		return false;
	}
}
