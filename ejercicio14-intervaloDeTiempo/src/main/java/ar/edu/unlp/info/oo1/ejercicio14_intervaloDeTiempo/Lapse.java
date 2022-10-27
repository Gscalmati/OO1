package ar.edu.unlp.info.oo1.ejercicio14_intervaloDeTiempo;

import java.time.LocalDate;

public interface Lapse {
	
	public LocalDate getFrom();
	//“Retorna la fecha de inicio del rango”
	
	public LocalDate getTo();
	//“Retorna la fecha de fin del rango”
	
	public int sizeInDays();
	//“Retorna la cantidad de días entre la fecha 'from' y la fecha 'to'”
	
	public boolean includesDate(LocalDate other);
	//“Recibe un objeto LocalDate y retorna true si la fecha está entre el from y el to del receptor y false en caso contrario”.
}
