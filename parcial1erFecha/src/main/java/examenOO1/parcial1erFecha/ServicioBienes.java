package examenOO1.parcial1erFecha;

import java.time.LocalDate;

public class ServicioBienes {
	
	public Bien addInmueble (Integer numPart, Double unLote, Double unEdif, Contribuyente cont) {
		Bien inmueble = new Inmueble (numPart, unLote, unEdif);
		cont.addBien(inmueble);
		
		return inmueble;
	}
	
	
	public Bien addAutomovil (String unaP, LocalDate unaF, Double unV, String unaMar, String unMod, Contribuyente cont ) {
		Bien automovil = new Automovil (unaP, unaF, unV, unaMar, unMod);
		cont.addBien(automovil);
		
		return automovil;
	}
	
	public Bien addEmbarcacion (String unaP, LocalDate unaF, Double unV, String unNombre, Contribuyente cont ) {
		Bien barco = new Embarcacion (unaP, unaF, unV, unNombre);
		cont.addBien(barco);
		
		return barco;
	}
}
