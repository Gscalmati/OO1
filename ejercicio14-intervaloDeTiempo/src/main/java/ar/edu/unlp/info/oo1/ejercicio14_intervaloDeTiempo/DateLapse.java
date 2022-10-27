package ar.edu.unlp.info.oo1.ejercicio14_intervaloDeTiempo;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse implements Lapse{
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
	
}
