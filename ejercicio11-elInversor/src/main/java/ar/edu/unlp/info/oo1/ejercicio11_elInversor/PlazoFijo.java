package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PlazoFijo extends Inversion {
	
	private LocalDate fechaDeConstitucion;
	private double montoDepositado;
	private double porcentajeDeInteresDiario;
	
	public PlazoFijo (LocalDate unaFecha, double unMonto, double unPorcentaje) {
		this.fechaDeConstitucion = unaFecha;
		this.montoDepositado = unMonto;
		this.porcentajeDeInteresDiario = unPorcentaje;
	}
	
	public LocalDate getFechaDeConstitucion() {
		return fechaDeConstitucion;
	}
	public void setFechaDeConstitucion(LocalDate fechaDeConstitucion) {
		this.fechaDeConstitucion = fechaDeConstitucion;
	}
	public double getMontoDepositado() {
		return montoDepositado;
	}
	public void setMontoDepositado(double montoDepositado) {
		this.montoDepositado = montoDepositado;
	}
	public double getPorcentajeDeInteresDiario() {
		return porcentajeDeInteresDiario;
	}
	public void setPorcentajeDeInteresDiario(double porcentajeDeInteresDiario) {
		this.porcentajeDeInteresDiario = porcentajeDeInteresDiario;
	}
	
	public double valorActual () {
		
		LocalDate hoy = LocalDate.now();
		long dias = this.fechaDeConstitucion.until(hoy, ChronoUnit.DAYS);
		return ((this.montoDepositado + (this.montoDepositado * (this.porcentajeDeInteresDiario/100))) * dias);
	}
	
	

}
