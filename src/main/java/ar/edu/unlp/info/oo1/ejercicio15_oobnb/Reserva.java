package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import java.time.LocalDate;

public class Reserva {
	private DateLapse fecha;
	private Propiedad propiedad;
	
	public Reserva(DateLapse fecha, Propiedad unaProp) {
		this.fecha = fecha;
		this.propiedad = unaProp;
	}

	public double calcularPrecio () {
		return this.getFecha().sizeInDays() * this.getPropiedad().getPrecioXNoche();
	}
	
	public boolean fechaReservada (DateLapse fecha) {
		return (this.getFecha().overlaps(fecha));
	}
	
	public boolean esFechaPosterior() {
		return (this.getFecha().getFrom().isAfter(LocalDate.now()));
	}

	public DateLapse getFecha() {
		return fecha;
	}

	public void setFecha(DateLapse fecha) {
		this.fecha = fecha;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
	public LocalDate getIn() { 
		return this.fecha.getFrom();
	}
	
	/**
	Retorna true si la reserva esta adentro del periodo ingresado, sea integra, o parcialmente
	 **/
	public boolean incluye(DateLapse periodo) {
		return periodo.includesDate(this.getFecha().getFrom()) || periodo.includesDate(this.getFecha().getTo());
	}
	
	
	
	/*
	 * DEPRECADO POR LOGICA
	public boolean incluye(DateLapse periodo) {
		return this.getFecha().includesDate(periodo.getFrom()) || this.getFecha().includesDate(periodo.getTo());
	}
	*/

}
