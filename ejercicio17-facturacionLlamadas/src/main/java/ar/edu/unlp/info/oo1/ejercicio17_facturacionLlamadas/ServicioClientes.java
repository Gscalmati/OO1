package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioClientes {

	private ServicioNumeros numeros;
	private List<Cliente> clientes;
	
	public ServicioClientes (ServicioNumeros num) {
		this.numeros = num;
		this.clientes = new ArrayList<Cliente>();
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}



	public Cliente addPersonaFisica (String nom, String dire, Integer dni) {
		String numNuevo = this.numeros.asignarNumero();
		
		Cliente nuevaPersona = new PersonaFisica (nom, dire, numNuevo, dni);
		this.clientes.add(nuevaPersona);
		return nuevaPersona;
	}
	
	public Cliente addPersonaJuridica (String nom, String dire, Integer cuit, String tipo) {
		String numNuevo = this.numeros.asignarNumero();
		
		Cliente nuevaPersona = new PersonaJuridica (nom, dire, numNuevo, cuit, tipo);
		this.clientes.add(nuevaPersona);
		return nuevaPersona;
	}
	
	private Cliente buscarCliente (String num) {
		return this.clientes.stream()
				.filter(c -> c.getNumero() == num).findFirst().orElse(null);
	}
	
	public Llamada registrarLlamadaLocal (LocalDate fechaLlam, LocalTime horaLlam, Integer duracionLlam, String numEmisor, String numReceptor) {
		Llamada nuevaLlamada = new LlamadaLocal(fechaLlam, horaLlam, duracionLlam, numReceptor);
		
		Cliente clienteEmisor = this.buscarCliente(numEmisor);
		
		clienteEmisor.addLlamada(nuevaLlamada);
		
		return nuevaLlamada;
	}
	
	public Llamada registrarLlamadaInterUrbana (LocalDate fechaLlam, LocalTime horaLlam, Integer duracionLlam, String numEmisor, String numReceptor, Integer distancia) {
		Llamada nuevaLlamada = new LlamadaInterurbana(fechaLlam, horaLlam, duracionLlam, numReceptor, distancia);
		
		Cliente clienteEmisor = this.buscarCliente(numEmisor);
		
		clienteEmisor.addLlamada(nuevaLlamada);
		
		return nuevaLlamada;
	}
	
	public Llamada registrarLlamadaInternacional (LocalDate fechaLlam, LocalTime horaLlam, Integer duracionLlam, String numEmisor, String numReceptor, Integer distancia, String paisO, String paisD) {
		Llamada nuevaLlamada = new LlamadaInternacional(fechaLlam, horaLlam, duracionLlam, numReceptor, distancia, paisO, paisD);
		
		Cliente clienteEmisor = this.buscarCliente(numEmisor);
		
		clienteEmisor.addLlamada(nuevaLlamada);
		
		return nuevaLlamada;
	}
	
	public Factura facturar (Cliente c, LocalDate inicioPeriodo, LocalDate finPeriodo) {
		return c.facturar(inicioPeriodo, finPeriodo);
	}
	
	
}
