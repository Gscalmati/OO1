package ar.edu.unlp.info.oo1.ejercicio7;

/**
 * De esta forma crearemos las clases del ejercicio
 *
 */
public class Empleado {

	private String nombre;

	public Empleado (String unNombre) {
		this.nombre = unNombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double montoBasico () {
		return 35000;
	}
	
	public double aportes () {
		return 13500;
	}
	
	public double sueldoBasico () {
		return this.montoBasico() + this.aportes();
	}
}
