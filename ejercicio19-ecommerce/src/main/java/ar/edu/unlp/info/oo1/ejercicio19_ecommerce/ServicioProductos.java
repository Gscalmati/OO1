package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioProductos {
	
	private ArrayList<Producto> productos;
	
	public ServicioProductos () {
		this.productos = new ArrayList<Producto>();
	}
	
	public Producto registrarProducto (String n, String desc, Double precio, Integer cant, Vendedor v) {
		Producto nuevo = new Producto (n, desc, precio, cant);
		v.agregarProducto(nuevo);
		this.productos.add(nuevo);
		return nuevo;
	}
	
	public List<Producto> buscarProductos (String nombre) {
		return this.productos.stream()
				.filter(p -> p.mismoNombre(nombre))
				.collect(Collectors.toList());
	}
	
	public Pedido crearPedido (Cliente c, Producto p, Integer cant, OpcionesPago pago, Envios envio) {
		if (p.hayStock(cant)) {
			Pedido nuevo = new Pedido (p, cant, pago, envio);
			p.restarStock(cant);
			c.agregarPedido(nuevo);
			return nuevo;
		}
		return null;
	}
 
}
