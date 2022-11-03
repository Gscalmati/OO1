package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.util.HashSet;
import java.util.Set;

public class ServicioNumeros {
	
		private Set<NumeroTel> numeros;
		
		public ServicioNumeros () {
			this.numeros = new HashSet<NumeroTel>();
		}
		
		
		public Set<NumeroTel> getNumeros() {
			return numeros;
		}

		public NumeroTel addNumero (String num) {
			NumeroTel nuevo = new NumeroTel(num);
			this.numeros.add(nuevo);
			return nuevo;
		}
		
		public String asignarNumero () {
			NumeroTel numeroLibre = this.numeros.stream()
					.filter(n -> n.isEstado() == false).findFirst().orElse(null);
			
			numeroLibre.asignar();
			return numeroLibre.getNumero();
		}
		
}
