package versionGio;

import java.util.List;
import java.util.Set;

public class Distribuidora {
	
	private double precioKWh;
	private Set<Usuario> usuarios;
	
	public void precioKWh (double unPrecio) {
		this.precioKWh = unPrecio;
	}
	
	public void agregarUsuario (Usuario unUsuario) {
		this.usuarios.add(unUsuario);
	}
	
	public List<Factura> facturar (){
			
		return null;
	}
	
	public double consumoTotalActiva () {
		
		return 0;
	}
	
	
	
	

}
