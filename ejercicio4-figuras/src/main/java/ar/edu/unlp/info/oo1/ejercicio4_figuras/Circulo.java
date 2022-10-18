package ar.edu.unlp.info.oo1.ejercicio4_figuras;

public class Circulo implements Cuerpo2D{
	
	private double diametro;
	private double radio;
	
	public Circulo () {
		
	}
	
	public double getDiametro() {
		return diametro;
	}
	public void setDiametro(double diametro) {
		this.diametro = diametro;
		this.radio = diametro/2;
	}
	public double getRadio() {
		return radio;
	}
	public void setRadio(double radio) {
		this.radio = radio;
		this.diametro = radio*2;
	}
	
	public double getPerimetro () {
		
		return Math.PI * this.diametro;
	}
	
	public double getArea () {
		
		return Math.PI * (Math.pow(this.radio, 2));
	}
	
	
	
	

}
