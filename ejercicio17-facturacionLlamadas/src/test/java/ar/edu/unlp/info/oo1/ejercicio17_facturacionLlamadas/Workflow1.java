package ar.edu.unlp.info.oo1.ejercicio17_facturacionLlamadas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Workflow1 {

	private ServicioNumeros servNum;
	private ServicioClientes servClientes;
	
	private String numero1 = "12345678";
	private String numero2 = "87654321";
	
	private String nomCliente1 = "Juan";
	private String direCliente1 = "Av 1 123";
	private Integer dnic1 = 1111111;

	private String nomCJ = "UNLP";
	private String direCJ = "Calle 115, al fondo";
	private Integer cuitCJ = 222222;
	private String tipoCJ = "Unversidad";
	
	private LocalDate fechaLlocal = LocalDate.of(2022, 11, 2);
	private LocalTime horaLlocal = LocalTime.of(15, 0);
	private Integer duracionLlocal = 5;
	private String numELlocal = numero1;
	private String numRLocal = "33333333";
	
	private LocalDate fechaLinterurb = LocalDate.of(2022, 11, 3);
	private LocalTime horaLinterurb = LocalTime.of(16, 0);
	private Integer duracionLinterurb = 10;
	private String numELinterurb = numero2;
	private String numRinterurb = "33333333";
	private Integer distanciaLinterurb = 150;
	
	private LocalDate fechaLinter = LocalDate.of(2022, 11, 10);
	private LocalTime horaLinter = LocalTime.of(23, 30);
	private Integer duracionLinter = 20;
	private String numELinter = numero1;
	private String numRLinter = "33333333";
	private Integer distanciaLinter = 500;
	private String paisO = "USA";
	private String paisD = "ARG";
	
	private Factura factura1;
	private Factura factura2;
	
	private Cliente Cus1;
	private Cliente Cus2;
	
	@BeforeEach
	public void setUp () {
		
		servNum = new ServicioNumeros();
		servClientes = new ServicioClientes(servNum);
		
		servNum.addNumero(numero1);
		servNum.addNumero(numero2);
		
		Cus1 = servClientes.addPersonaFisica(nomCliente1, direCliente1, dnic1);
		Cus2 = servClientes.addPersonaJuridica(nomCJ, direCJ, cuitCJ, tipoCJ);
		
		servClientes.registrarLlamadaLocal(fechaLlocal, horaLlocal, duracionLlocal, numELlocal, numRLocal);
		servClientes.registrarLlamadaInterUrbana(fechaLinterurb, horaLinterurb, duracionLinterurb, numELinterurb, numRinterurb, distanciaLinterurb);
		servClientes.registrarLlamadaInternacional(fechaLinter, horaLinter, duracionLinter, numELinter, numRLinter, distanciaLinter, paisO, paisD);
	}
	
	@Test
	public void testearAdds () {
		assertEquals(servNum.getNumeros().size(), 2);
		assertEquals(servClientes.getClientes().size(), 2);
		assertEquals(Cus1.getNumero(), numero1);
		assertEquals(Cus2.getNumero(), numero2);
	}
	
	@Test
	public void testLlamadas () {
		assertEquals(Cus1.getLlamadas().size(), 2);
	}
	
	@Test
	public void facturar () {
		factura1 = servClientes.facturar(Cus1, LocalDate.of(2022, 11, 1), LocalDate.of(2022, 11, 5));
		assertNotNull(factura1);
		assertEquals(5, factura1.getMonto());
		factura2 = servClientes.facturar(Cus2, LocalDate.of(2022, 11, 2), LocalDate.of(2022, 11, 5));
		assertNotNull(factura2);
		assertEquals(30, factura2.getMonto());
	}
	
}
