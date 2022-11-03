package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

public class PersonaJuridica extends Cliente {
	private Integer cuit;
	private String tipo;
	
	public PersonaJuridica (String nom, String dire, String numeroTel, Integer unCuit, String unTipo) {
		super(nom, dire, numeroTel);
		this.cuit = unCuit;
		this.tipo = unTipo;
	}
}
