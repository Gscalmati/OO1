package examenOO1.parcial1erFecha;

public class Inmueble implements Bien {
	
	private Integer numPartida;
	private Double valorLote;
	private Double valorEdif;

	public Inmueble (Integer numPart, Double unLote, Double unEdif) {
		this.numPartida = numPart;
		this.valorEdif = unEdif;
		this.valorLote = unLote;
	}
	

	public Double calcularImpuesto() {
		return (this.valorEdif + this.valorLote) / 100;
	}

}
