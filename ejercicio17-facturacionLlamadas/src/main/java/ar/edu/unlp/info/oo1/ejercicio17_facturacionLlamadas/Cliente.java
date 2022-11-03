package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {

	private String nombre;
	private String direccion;
	private String numero;
	private List<Llamada> llamadas;
	
	public Cliente (String unNom, String unaDire, String num) {
		this.nombre = unNom;
		this.direccion = unaDire;
		this.numero = num;
		this.llamadas = new ArrayList<Llamada> ();
	}
	
	
	
	public List<Llamada> getLlamadas() {
		return llamadas;
	}



	public Factura facturar (LocalDate inicio, LocalDate fin) {
		
		double monto = this.llamadas.stream()
				.filter(l -> l.getFecha().isAfter(inicio) && l.getFecha().isBefore(fin))
				.mapToDouble(l -> l.calcularCosto()).sum();
		
		return new Factura (this, LocalDate.now(), inicio, fin, monto);
	}
	
	public void addLlamada (Llamada l) {
		this.llamadas.add(l);
	}

	public String getNumero() {
		return numero;
	}
	
}
