package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDate;

public class Factura {

	private Cliente cliente;
	private LocalDate fechaFact;
	private LocalDate inicioPeriodo;
	private LocalDate finperiodo;
	private double monto;
	
	public Factura (Cliente unCliente, LocalDate fecha, LocalDate inicio, LocalDate fin, double monto) {
		this.cliente = unCliente;
		this.fechaFact = fecha;
		this.inicioPeriodo = inicio;
		this.finperiodo = fin;
		this.monto = monto;
	}

	public double getMonto() {
		return monto;
	}
	
	
}
