package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse{
	private LocalDate from;
	private LocalDate to;
	
	public DateLapse (LocalDate from, LocalDate to) {
		this.from = from;
		this.to = to;
	}
	
	public LocalDate getFrom() {
		return from;
	}

	public LocalDate getTo() {
		return to;
	}

	
	public int sizeInDays () {
		return (int)(this.from.until(to, ChronoUnit.DAYS));
	}
	
	
	public boolean includesDate (LocalDate other) {
		return (this.from.minusDays(1).isBefore(other) && this.to.plusDays(1).isAfter(other));
	}
	
	/*
	public boolean includesDate(LocalDate other) {
		return other.isAfter(this.getFrom()) && other.isBefore(this.getTo()) || this.getFrom().equals(other)
				|| this.getTo().equals(other);
	}
	*/
	
	/**
	Retorna true si el período de tiempo del receptor se superpone con el recibido por parámetro
	**/
	public boolean overlaps (DateLapse anotherDate) {
		return (this.includesDate(anotherDate.from) || this.includesDate(anotherDate.to));
	}
 
	
}
