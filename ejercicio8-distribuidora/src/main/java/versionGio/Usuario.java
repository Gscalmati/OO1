package versionGio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

public class Usuario {
	
	private String domicilio;
	private String nombre;
	private ArrayList <Factura> facturas;
	private ArrayList <Consumo> consumos;
	
	// CONSTRUCTOR
	public Usuario (String unDomicilio, String unNombre) {
		this.domicilio = unDomicilio;
		this.nombre = unNombre;
		this.facturas = new ArrayList<Factura>();
		this.consumos = new ArrayList<Consumo>();
	}
	
	// Inciso 3
	public void agregarMedicion (Consumo medicion) {
		this.consumos.add(medicion);
	}
	
	// Devuelve el ultimo consumo de Energia Activa, si no hay consumo, devuelve 0
	public double ultimoConsumoActiva () {
		return this.consumoMasNuevo()
				.map((Consumo c1) -> c1.getConsumoEnergiaActiva())
				.orElse(0.0);
	}
	
	// Devuelve el ultimo consumo, si no hay, devuelve Null
	public Consumo ultimoConsumo () {
		return this.consumoMasNuevo().orElse(null);
	}
	
	public Factura facturarEnBaseA (double precioKWh) {
		Consumo ultimoConsumo = this.ultimoConsumo();
				
		if (ultimoConsumo == null) {
			return new Factura (0, 0, this);
		}
		
		double descuento = 0;
		double costoConsumo = this.ultimoConsumoActiva() * precioKWh;
		double factor = ultimoConsumo.factorDePotencia();
		if (factor >= 0.8) {
			descuento = 0.1;
		}
		
		Factura nuevaFactura = new Factura(costoConsumo, descuento, this);
		this.facturas.add(nuevaFactura);
		return nuevaFactura;
	}
	
	// Esto devuelve un OPTIONAL, porque puede no haber consumo, y trae el consumo con la fecha más actual
	private Optional<Consumo> consumoMasNuevo () {
		return this.consumos
		.stream()
		.max((Consumo c1, Consumo c2) -> c1.getFecha().compareTo(c2.getFecha()));
	}
	
	public ArrayList<Factura> facturas () {
		return (this.facturas);
	}
	
	
}
