package examenOO1.parcial1erFecha;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ServicioContribuyentes {

	
	private ArrayList<Contribuyente> contribuyentes;
	
	public ServicioContribuyentes () {
		this.contribuyentes = new ArrayList<Contribuyente> ();
	}
	
	public Contribuyente addContribuyente (String unNom, Integer unDni, String unaLoc) {
		Contribuyente nuevo = new Contribuyente (unNom, unDni, unaLoc);
		
		this.contribuyentes.add(nuevo);
		
		return nuevo;
	}
	
	public List<Contribuyente> contribuyentesPorLocalidad (String localidad) {
		 return this.contribuyentes.stream()
				 .filter(c -> c.getLocalidad().equals(localidad))
				 .sorted((c1,c2) -> c2.calcularImpuestos().compareTo(c1.calcularImpuestos()))
				 .limit(50)
				 .collect(Collectors.toList());
	}
	
	public int cantContribuyentes () {
		return this.contribuyentes.size();
	}
	
	
}
