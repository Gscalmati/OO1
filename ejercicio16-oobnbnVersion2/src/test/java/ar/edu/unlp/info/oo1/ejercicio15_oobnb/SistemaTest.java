package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {

	private Sistema sistema;
	
	private Usuario user1;
	private Usuario user2;
	private Usuario inquilino;
	
	
	private Propiedad prop1;
	private Propiedad prop2;
	private Propiedad prop3;
	private Propiedad prop4;
	
	private CancelacionFlexible flexible;
	private CancelacionModerada moderada;
	private CancelacionEstricta estricta;
	
	private DateLapse fechaReserva;
	private DateLapse otraFechaReserva;
	private DateLapse otraFechaMas;
	
	@BeforeEach
	public void setUp() {
		sistema = new Sistema();
		
		user1 = sistema.registrarUsuario("Juli", "Av. 60 485", 1111111);
		user2 = sistema.registrarUsuario("Gio", "Alberdi 261", 2222222);
		inquilino = sistema.registrarUsuario("Inqui", "Lino", 2);
		
		flexible = new CancelacionFlexible();
		moderada = new CancelacionModerada ();
		estricta = new CancelacionEstricta ();
		
		prop1= sistema.registrarPropiedad("Atahualpa", "Mina Clavero", 20, "Lejos 123", user1, flexible);
		prop2= sistema.registrarPropiedad("RDE", "PDE", 40, "Este 234", user1, moderada);
		prop3= sistema.registrarPropiedad("RDA", "SDA", 50, "Sur 123", user2, estricta);
		prop4= sistema.registrarPropiedad("RDI", "SDI", 20, "Oeste 123", user2, flexible);
		
		fechaReserva = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		otraFechaReserva = new DateLapse (LocalDate.of(2022, 11, 20), LocalDate.of(2022, 11, 30));
		otraFechaMas = new DateLapse (LocalDate.of(2022, 11, 15), LocalDate.of(2022, 11, 20));
		
	}
	
	@Test
	public void testearVariables () {
		assertEquals("Juli", user1.getNombre());
		assertEquals("RDE", prop2.getNombre());
	}
	
	@Test
	public void buscarPropiedad () {
		prop1.reservar(fechaReserva, inquilino);
		prop4.reservar(otraFechaMas, inquilino);
		
		DateLapse fechaABuscar =  new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 10));
		List<Propiedad> resp = sistema.buscarPropiedadDispEnFecha(fechaABuscar);
		assertEquals(resp.size(), 3);
		assertFalse(resp.contains(prop1));
		assertTrue(resp.contains(prop2));
		assertTrue(resp.contains(prop3));
		assertTrue(resp.contains(prop4));
	}
	
	@Test
	public void calcularIngresos() {
		prop1.reservar(fechaReserva, inquilino);
		prop1.reservar(otraFechaReserva, inquilino);
		prop4.reservar(otraFechaMas, inquilino);
		
		LocalDate in = LocalDate.of(2022, 11, 05);
		LocalDate out = LocalDate.of(2022, 11, 10);
		double respUser1 = sistema.calcularIngresoAUsuario(user1, in, out);
		assertEquals(200, respUser1);
		
		LocalDate in2 = LocalDate.of(2022, 11, 05);
		LocalDate out2 = LocalDate.of(2022, 11, 20);
		double respUser1vers2 = sistema.calcularIngresoAUsuario(user1, in2, out2);
		assertEquals(400, respUser1vers2);
		
		LocalDate in3 = LocalDate.of(2022, 11, 05);
		LocalDate out3 = LocalDate.of(2022, 11, 10);
		double respUser2 = sistema.calcularIngresoAUsuario(user2, in3, out3);
		assertEquals(0, respUser2);
		
	}
	
}
