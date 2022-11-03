package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

public class PersonaFisica extends Cliente {
	private Integer dni;
	
	public PersonaFisica (String nom, String dire, String unNum, Integer unDni) {
		super(nom, dire, unNum);
		this.dni = unDni;
	}
}
