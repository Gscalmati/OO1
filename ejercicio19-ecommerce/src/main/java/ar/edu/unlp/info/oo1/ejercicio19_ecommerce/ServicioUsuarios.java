package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

import java.util.HashSet;
import java.util.Set;

public class ServicioUsuarios {

	private Set<Usuario> usuarios = new HashSet<Usuario> ();
	
	public Usuario registrarVendedor (String n, String d) {
		Usuario nuevo = new Vendedor (n,d,"Vendedor");
		this.usuarios.add(nuevo);
		return nuevo;
	}
	
	public Usuario registrarCliente (String n, String d) {
		Usuario nuevo = new Cliente (n,d,"Cliente");
		this.usuarios.add(nuevo);
		return nuevo;
	}
}
