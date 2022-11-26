package cosasVarias.sandbox;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ServicioBienes {
	
	private ArrayList<Bien> bdd;
	
	
	public void regiInmueble (int duracion, String origen) {
		
		Bien inmu = new Inmueble(); 
		
		
		this.bdd.add(inmu);
	}
	
public void regEmbarcacion (int duracion, String origen, String pais) {
		
		Bien barco = new Embarcacion(); 
		
		
		this.bdd.add(barco);
	}
	
	
public void regAuto (int duracion, String origen) {
	
		Bien auto = new Automovil(); 
		
		this.bdd.add(auto);
	
}


public ArrayList<Bien> calcularImpuestos () {
	
	this.bdd.stream()
		.filter(bien -> bien.anio > 1998)
		.sorted((b1,b2) -> b1.calcularImpuestos().compareTo(b2.calcularImpuestos()))
		.collect(Collectors.toList());
}

}
