package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInterurbana extends Llamada{
	
	private double distancia;
	
	public LlamadaInterurbana (LocalDate unaFecha, LocalTime unaHora, Integer unaDuracion, String unReceptor, double unaDistancia) {
		super(unaFecha, unaHora, unaDuracion, unReceptor);
		this.distancia = unaDistancia;
	}
	
	public double calcularCosto() {
		double costoFijo = 5;
		
		double costoVariable = super.getDuracion() * this.definirCostoPorDistancia();
		
		return (costoFijo + costoVariable);
	}
	
	private double definirCostoPorDistancia () {
		if (this.distancia < 100) {
			return 2;
		} 
		if (this.distancia <=  500) {
			return 2.5;
		}
		return 3;
	}
}
