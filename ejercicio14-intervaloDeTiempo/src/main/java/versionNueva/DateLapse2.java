package versionNueva;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import ar.edu.unlp.info.oo1.ejercicio14_intervaloDeTiempo.Lapse;

public class DateLapse2 implements Lapse{
	private LocalDate from;
	private int sizeInDays;
	
	public DateLapse2 (LocalDate from, int days) {
		this.from = from;
		this.sizeInDays = days;
	}
	
	public LocalDate getFrom() {
		return from;
	}

	public LocalDate getTo() {
		return this.from.plusDays(this.sizeInDays);
	}
	
	
	public int sizeInDays () {
		return this.sizeInDays;
	}
	
	public boolean includesDate (LocalDate other) {
		return (this.from.minusDays(1).isBefore(other) && this.getTo().plusDays(1).isAfter(other));
	}
	

}
