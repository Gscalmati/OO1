package ar.edu.unlp.info.oo1.ejercicio4_figuras;

public class Cuerpo3D {

	

	private Cuerpo2D carabasal;
	private double altura;
	
	public double getAltura() {
		return altura;
	}
	public void setAltura(double altura) {
		this.altura = altura;
	}
	public Cuerpo2D getCarabasal() {
		return carabasal;
	}
	public void setCaraBasal(Cuerpo2D carabasal) {
		this.carabasal = carabasal;
	} 
	
	public double getSuperficieExterior() {
		return (2 * this.getCarabasal().getArea()) + (this.carabasal.getPerimetro() * this.getAltura());
		
	}
	
	public double getVolumen() {
		return (this.getCarabasal().getArea() * this.getAltura());
	}
	
}
