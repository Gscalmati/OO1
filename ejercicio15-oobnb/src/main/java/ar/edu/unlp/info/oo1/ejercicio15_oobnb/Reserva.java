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

}
