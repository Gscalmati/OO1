package versionGio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Distribuidora {
	
	private double precioKWh;
	private Set<Usuario> usuarios;
	
	
	// CONSTRUCTOR
	public Distribuidora (double unPrecio) {
		this.precioKWh = unPrecio;
		this.usuarios = new HashSet<Usuario>();
	}
	
	//Inciso 2
	public void agregarUsuario (Usuario unUsuario) {
		if (!this.usuarios.contains(unUsuario)) {
			this.usuarios.add(unUsuario);
		}
	}
	
	// Devuelvo una coleccion de las ultimas facturas;
	// Inciso 4
	public List<Factura> facturar (){
		
		List<Factura> facturas = this.usuarios
		.stream()
		.map((Usuario u1) -> u1.facturarEnBaseA(precioKWh))
		.collect(Collectors.toList());
		
			
		return facturas;
	}
	
	//Sumos todos los valores de los ultimos consumos
	// Inciso 5
	public double consumoTotalActiva () {
		
		return this.usuarios
				.stream()
				.mapToDouble((Usuario u1) -> u1.ultimoConsumoActiva())
				.sum();
		
	}
	
	//Iniciso 1
	public void setprecioKWH (double unPrecio) {
		this.precioKWh = unPrecio;
	}
	

}
