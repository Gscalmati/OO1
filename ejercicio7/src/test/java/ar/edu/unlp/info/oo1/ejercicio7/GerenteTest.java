package ar.edu.unlp.info.oo1.ejercicio7;

public class GerenteTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Gerente alan = new Gerente ("Alan Turing");
		double aportesDeAlan = alan.aportes();
		
		double sueldoBasicoDeAlan = alan.sueldoBasico();
		
		System.out.println(aportesDeAlan);
		System.out.println(sueldoBasicoDeAlan);
	}

}
