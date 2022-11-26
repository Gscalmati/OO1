package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

import java.util.ArrayList;

public class Cliente extends Usuario {

	private ArrayList<Pedido> pedidos;
	
	public Cliente (String n, String d, String t) {
		super(n, d, t);
		this.pedidos = new ArrayList<Pedido>();
	}
	
	public void agregarPedido (Pedido p) {
		this.pedidos.add(p);
	}
	
	public Double calcularPedido(Pedido p) {
		return p.calcularCostoTotal();
	}
	
}
