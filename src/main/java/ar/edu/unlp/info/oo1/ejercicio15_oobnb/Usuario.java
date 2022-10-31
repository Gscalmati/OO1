package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	//-----------------------------------------------------------//
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public List<Propiedad> getPropiedadesAlquiladas() {
		return propiedadesAlquiladas;
	}

	public void setPropiedadesAlquiladas(List<Propiedad> propiedadesAlquiladas) {
		this.propiedadesAlquiladas = propiedadesAlquiladas;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	//-----------------------------------------------------------//
	public void agregarPropiedad (Propiedad p) {
		this.propiedadesAlquiladas.add(p);
	}
	
	
	public void agregarReserva (Reserva r) {
		this.reservas.add(r);
	}
	
	//Si la reserva tiene fecha posterior a hoy, la elimino de las reservas del Usuario
	public void eliminarReserva (Reserva r) {
		if (r.esFechaPosterior()) {
			
			Propiedad propParaEliminarReserva = this.propiedadesAlquiladas.stream()
			.filter(p -> p.equals(r.getPropiedad())).findAny().orElse(null);
			if (propParaEliminarReserva != null) {
				propParaEliminarReserva.eliminarReserva(r);
			}
			this.reservas.remove(r);
		}
	}
	
	
		public double cancelarReserva (Reserva r) {
			double reembolso = 0;
			if (r.esFechaPosterior()) {
				
				Propiedad propParaEliminarReserva = this.propiedadesAlquiladas.stream()
				.filter(p -> p.equals(r.getPropiedad())).findAny().orElse(null);
				if (propParaEliminarReserva != null) {
					reembolso = propParaEliminarReserva.cancelarReserva(r, LocalDate.now());
				}
				this.reservas.remove(r);
			}
			return reembolso;
		}
	
	//La clono con un stream? o envio la VI
	public List<Reserva> obtenerReservas () {
		return this.reservas;
	}
	
	 
	public double calcularIngresos (DateLapse periodo) {
		return this.propiedadesAlquiladas.stream()
				.mapToDouble(p -> p.calcularIngresos(periodo)).sum();
	}
}
