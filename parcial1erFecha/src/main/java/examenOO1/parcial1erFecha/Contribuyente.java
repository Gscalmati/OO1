package examenOO1.parcial1erFecha;

import java.util.ArrayList;

public class Contribuyente {

	private String nombre;
	private Integer dni;
	private String localidad;
	private ArrayList<Bien> bienes;
	
	public Contribuyente (String unNom, Integer unDni, String unaLoc) {
		this.nombre = unNom;
		this.dni = unDni;
		this.localidad = unaLoc;
		this.bienes = new ArrayList<Bien> ();
	}
	
	public void addBien (Bien unBien) {
		this.bienes.add(unBien);
	}
	
	public Double calcularImpuestos() {
		return this.bienes.stream()
		.mapToDouble(bien -> bien.calcularImpuesto())
		.sum();
	}

	public String getLocalidad() {
		return this.localidad;
	}
	
	public int cantBienes () {
		return this.bienes.size();
	}
	
}
