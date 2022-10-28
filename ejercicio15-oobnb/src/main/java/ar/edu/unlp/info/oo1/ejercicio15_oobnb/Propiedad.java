package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import java.util.ArrayList;
import java.util.List;

public class Propiedad {
	private String nombre;
	private String descripcion;
	private double precioXNoche;
	private String direccion;
	private List<Reserva> fechasReservadas;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecioXNoche() {
		return precioXNoche;
	}
	
	public void setPrecioXNoche(double precioXNoche) {
		this.precioXNoche = precioXNoche;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Reserva> getFechasReservadas() {
		return fechasReservadas;
	}

	public void setFechasReservadas(List<Reserva> fechasReservadas) {
		this.fechasReservadas = fechasReservadas;
	}

	public Propiedad (String unNombre, String unaDescrip, double unPrecio, String unaDire) {
		this.nombre = unNombre;
		this.descripcion = unaDescrip;
		this.precioXNoche = unPrecio;
		this.direccion = unaDire;
		this.fechasReservadas = new ArrayList<Reserva> ();
	}
	
	public Reserva reservar (DateLapse fecha, Usuario u) {
		Reserva nuevaReserva = null;
		if (!this.estaOcupada(fecha)) {
			nuevaReserva = new Reserva (fecha, this);
			u.agregarReserva(nuevaReserva);
		}
		return nuevaReserva;
	}
	
	public boolean estaOcupada (DateLapse fecha) {
		return this.fechasReservadas.stream()
				.anyMatch(reserva -> reserva.fechaReservada(fecha));
	}
	
}
