package versionGio;

import java.util.List;
import java.util.Set;

public class Distribuidora {
	
	private double precioKWh;
	private Set<Usuario> usuarios;
	
	
	
	public void agregarUsuario (Usuario unUsuario) {
		if (!this.usuarios.contains(unUsuario)) {
			this.usuarios.add(unUsuario);
		}
	}
	
	public List<Factura> facturar (){
			
		return null;
	}
	
	public double consumoTotalActiva () {
		
		return 0;
	}
	
	//Iniciso 1
	public void setprecioKWH (double unPrecio) {
		this.precioKWh = unPrecio;
	}
	

}
