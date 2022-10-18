package versionGio;

import java.util.ArrayList;

public class Usuario {
	
	private String domicilio;
	private String nombre;
	private ArrayList <Factura> facturas;
	private ArrayList <Consumo> consumos;
	
	
	public void agregarMedicion (Consumo medicion) {
		
	}
	
	public double ultimoConsumoActiva () {
		return 0.0;
	}
	
	public Factura facturarEnBaseA (double precioKWh) {
		return null;
	}
	
	public ArrayList<Factura> facturas () {
		return null;
	}
	
	
}
