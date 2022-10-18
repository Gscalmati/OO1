package ar.edu.unlp.info.oo1.ejercicio3_presupuesto;

//Program to demonstrate methods of Date class
import java.time.LocalDate;

import java.util.*;


public class Presupuesto {
	
	private LocalDate fecha;
	private String cliente;
	private ArrayList <Item> items;
	
	
	public Presupuesto () {
		this.fecha = LocalDate.now();
		this.items = new ArrayList <Item>();
		
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	
	
	public Presupuesto cliente(String cliente) {
		this.setCliente(cliente);
		return this;
		
	}

	public void agregarItem (Item item) {
		this.items.add(item);
	}
	
	public double calcularTotal () {
		Iterator<Item> iterador = this.items.iterator(); 
		double total = 0;
		Item itemAux;
		while (iterador.hasNext()) {
			itemAux = iterador.next();
			total = total + itemAux.costo();
		}
		return total;
		
	}
}
