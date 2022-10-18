package ar.edu.unlp.info.oo1.ejercicio4_figuras;

public class Cuadrado implements Cuerpo2D{
	
	private double lado;
	
	public Cuadrado() {
	
	}

	public double getLado() {
		return lado;
	}

	public void setLado(double lado) {
		this.lado = lado;
	}
	
	public double getPerimetro () {
		
		return this.lado * 4;
	}
	
	public double getArea () {
		
		return Math.pow(this.lado, 2);
	}
	
	
	
}
