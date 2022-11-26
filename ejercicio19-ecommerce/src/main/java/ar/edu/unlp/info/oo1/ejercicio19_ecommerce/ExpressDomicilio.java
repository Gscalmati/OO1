package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

public class ExpressDomicilio implements Envios {

	private Mapa mapa;
	private String d1;
	private String d2;
	@Override
	public Double costo() {
		// TODO Auto-generated method stub
		return (this.mapa.distanciaEntre(d1,d2) * 0.5);
	}

}
