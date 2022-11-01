package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class Sistema {
	private Set<Usuario> usuarios;
	private List<Propiedad> propiedades;
	
	public Sistema () {
		this.usuarios = new HashSet<Usuario> ();
		this.propiedades = new ArrayList <Propiedad> ();
	}
	public Usuario registrarUsuario (String unNombre, String unaDire, int unDni) {
		Usuario user = new Usuario (unNombre, unaDire, unDni);
		this.usuarios.add(user);
		return user;
	}
	
	public Propiedad registrarPropiedad (String unNombre, String unaDescrip, double unPrecio, String unaDire, Usuario user, Cancelacion unaPolitica) {
		Propiedad prop = new Propiedad (unNombre, unaDescrip, unPrecio, unaDire, unaPolitica);
		this.propiedades.add(prop);
		
		Usuario usuarioParaAgregar = this.buscarUsuario(user);
		user.agregarPropiedad(prop);
		return prop;
	}
	
	public List<Propiedad> buscarPropiedadDispEnFecha (DateLapse fecha) {
		return this.propiedades.stream()
				.filter(prop -> !prop.estaOcupada(fecha)).collect(Collectors.toList());
	}
	
	public double calcularIngresoAUsuario(Usuario unUsuario, LocalDate from, LocalDate to) {
		Usuario usuarioACalcular = this.buscarUsuario(unUsuario);
		if (usuarioACalcular != null) {
			DateLapse periodo = new DateLapse(from, to);
			return usuarioACalcular.calcularIngresos(periodo);
		}
		return -1;
	}
	
	private Usuario buscarUsuario(Usuario unUsuario) {
		return this.usuarios.stream()
				  .filter(usuario->usuario.equals(unUsuario))
				  .findFirst().orElse(null);
	}
	
}
