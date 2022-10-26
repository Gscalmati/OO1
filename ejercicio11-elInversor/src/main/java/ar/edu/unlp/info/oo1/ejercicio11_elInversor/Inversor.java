package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

import java.util.ArrayList;
import java.util.List;

public class Inversor {

	private String nombre;
	private List<Inversion> inversiones;
	
	
	public String getNombre() {
		return nombre;
	}

	public List<Inversion> getInversiones() {
		return inversiones;
	}

	public Inversor (String unNombre) {
		this.nombre = unNombre;
		this.inversiones = new ArrayList<Inversion> ();
	}
	
	public void agregarInversion (Inversion unaInversion) {
		this.inversiones.add(unaInversion);
	}
	
	public double valorActual() {
		return this.inversiones
				.stream()
				.mapToDouble((Inversion i1) -> i1.valorActual())
				.sum();
	}
	
}
