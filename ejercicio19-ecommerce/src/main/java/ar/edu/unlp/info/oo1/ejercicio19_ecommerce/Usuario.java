package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

public abstract class Usuario {

	private String nombre;
	private String direccion;
	private String tipo;
	
	public Usuario (String n, String d, String t) {
		this.nombre = n;
		this.direccion = d;
		this.tipo = t;
	}
	
	public boolean verificarNombre (String n) {
		return this.nombre.equals(n);
	}
	
	public boolean verificarTipo (String t) {
		return this.tipo.equals(t);
	}
}
