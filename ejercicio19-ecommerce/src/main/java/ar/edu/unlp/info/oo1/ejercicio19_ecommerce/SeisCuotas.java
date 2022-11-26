package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

public class SeisCuotas implements OpcionesPago {

	@Override
	public Double costo(Double costo) {
		// TODO Auto-generated method stub
		return costo + (costo * 0.2);
	}

}
