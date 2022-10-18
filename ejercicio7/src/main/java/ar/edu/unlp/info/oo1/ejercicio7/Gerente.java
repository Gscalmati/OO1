package ar.edu.unlp.info.oo1.ejercicio7;

public class Gerente extends EmpleadoJerarquico{
	
	public Gerente (String unNombre) {
		super(unNombre);
	}
	
	public double aportes () {
		return this.montoBasico() * 0.05d;
	}
	
	public double montoBasico () {
		return 57000;
	}
}
