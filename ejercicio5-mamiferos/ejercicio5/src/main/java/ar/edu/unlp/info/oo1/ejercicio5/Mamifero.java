package ar.edu.unlp.info.oo1.ejercicio5;

import java.util.Date;

public class Mamifero {

	private String identificador;
	private String especie;
	private Date fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;
	
	public Mamifero () {
		this.padre = null;
		this.madre = null;

	}
	
	
	public Mamifero (String unId) {
		this.identificador = unId;
		this.padre = null;
		this.madre = null;
		
	}
	
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Mamifero getPadre() {
		return padre;
	}
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}
	public Mamifero getMadre() {
		return madre;
	}
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}
	public Mamifero getAbueloMaterno() {
		if (this.tieneMadre()) {
			return this.getMadre().getPadre();
		} else {
			return null;
		}	
	}

	public Mamifero getAbuelaMaterna() {
		if (this.tieneMadre()) {
			return (this.getMadre().getMadre());
		} else {
			return null;
		}
	}

	public Mamifero getAbueloPaterno() {
		if (this.tienePadre()) {
			return this.getPadre().getPadre();
		} else {
			return null;
		}
	}

	public Mamifero getAbuelaPaterna() {
		if (this.tienePadre()) {
			return this.getPadre().getMadre();
		} else {
			return null;
		}
	}
	
	public boolean tienePadre() {
		return (this.getPadre() != null);
	}
	
	public boolean tieneMadre() {
		return (this.getMadre() != null);
	}

	
	
	public boolean tieneComoAncestroA (Mamifero unMamifero) {
		
		if (!this.tieneMadre() && !this.tienePadre()) {
			return false;
		} else {
			if ((this.getMadre().getIdentificador() == unMamifero.getIdentificador()) || (this.getPadre().getIdentificador() == unMamifero.getIdentificador())) {
				return true;
			} else {
				return ((this.getMadre().tieneComoAncestroA(unMamifero)) || (this.getPadre().tieneComoAncestroA(unMamifero)));
			}
		}
	}

}
