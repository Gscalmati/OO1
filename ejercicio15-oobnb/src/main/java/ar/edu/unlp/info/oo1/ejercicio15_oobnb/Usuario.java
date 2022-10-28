package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nombre;
	private String direccion;
	private int dni;
	private List<Propiedad> propiedadesAlquiladas;
	private List<Reserva> reservas;
	
	public Usuario (String unNombre, String unaDire, int unDni) {
		this.nombre = unNombre;
		this.direccion = unaDire;
		this.dni = unDni;
		this.propiedadesAlquiladas = new ArrayList<Propiedad> ();
		this.reservas = new ArrayList<Reserva> ();
	}
	
	public void agregarPropiedad (Propiedad p) {
		this.propiedadesAlquiladas.add(p);
	}
	
	public void agregarReserva (Reserva r) {
		this.reservas.add(r);
	}
	
	//Si la reserva tiene fecha posterior a hoy, la elimino de las reservas del Usuario
	public void eliminarReserva (Reserva r) {
		if (r.esFechaPosterior()) {
			this.reservas.remove(r);
		}
	}
	
	//La clono con un stream? o envio la VI
	public List<Reserva> obtenerReservas () {
		return this.reservas;
	}
	
	 
	public double calcularIngresos (LocalDate inicio, LocalDate fin) {
		return this.propiedadesAlquiladas.stream()
				.filter(p->p)
	}
	
}
