package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

	private Sistema sistema;
	
	private Usuario user1;
	private Usuario user2;
	
	private Propiedad prop1;
	private Propiedad prop2;
	private Propiedad prop3;
	
	private Reserva res1;
	private Reserva res2;
	private Reserva res3;
	
	private Usuario inquilino;
	
	private CancelacionFlexible flexible;
	private CancelacionModerada moderada;
	private CancelacionEstricta estricta;
	
	
	
	@BeforeEach
	public void setUp() {
		
		sistema = new Sistema();
		
		user1 = new Usuario ("Juli", "Av. 60 485", 1111111);
		user2 = new Usuario ("Gio", "Alberdi 261", 2222222);
		
		flexible = new CancelacionFlexible();
		moderada = new CancelacionModerada ();
		estricta = new CancelacionEstricta ();
		
		prop1= new Propiedad("Atahualpa", "Mina Clavero", 20, "Lejos 123", flexible);
		prop2= new Propiedad("RDE", "PDE", 40, "Este 234", moderada);
		prop3= new Propiedad("RDA", "SDA", 40, "Sur 234", estricta);
		
		DateLapse fecha1 = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		res1 = new Reserva (fecha1, prop1);
		DateLapse fecha2 = new DateLapse (LocalDate.of(2022, 11, 20), LocalDate.of(2022, 11, 25));
		res2 = new Reserva (fecha2, prop2);
		DateLapse fecha3 = new DateLapse (LocalDate.of(2022, 11, 10), LocalDate.of(2022, 11, 20));
		res3 = new Reserva (fecha3, prop3);
		
		inquilino = new Usuario ("Inquilino", "Av. Siempreviva 483", 9999999);
		
		
		
	}
	
	@Test
	public void testearVariables () {
		assertEquals("Juli", user1.getNombre());
		assertEquals("Gio", user2.getNombre());
	}
	
	@Test
	public void testearPropiedadesAgregadas () {
		user1.agregarPropiedad(prop1);
		user2.agregarPropiedad(prop2);
		
		assertTrue(user1.getPropiedadesAlquiladas().contains(prop1));
		assertFalse(user1.getPropiedadesAlquiladas().contains(prop2));
	}
	
	@Test
	public void testearReservasAgregadas () {
		user1.agregarReserva(res1);
		user2.agregarReserva(res2);
		
		assertTrue(user1.getReservas().contains(res1));
		assertTrue(user2.getReservas().contains(res2));
		assertFalse(user1.getReservas().contains(res2));
	}
	
	@Test
	public void eliminarReservas () {
		//Agrego la reserva a user1, y por consiguiente a las reservas de Prop1
		user1.agregarReserva(res1);
		assertEquals(user1.getReservas().size(), 1);
		//Elimino la reserva
		user1.eliminarReserva(res1);
		//Verifico la NO existencia de dicha reserva en el usuario
		assertFalse(user1.getReservas().contains(res1));
		assertEquals(user1.getReservas().size(), 0);		
	}
	
	@Test 
	public void calcularIngresos () {
		DateLapse fechaQueCoincideCon1 = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		DateLapse fechaQueCoincideCon2 = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 20));
		DateLapse fechaQueNoCoincide = new DateLapse (LocalDate.of(2022, 11, 01), LocalDate.of(2022, 11, 04));
		
		user1.agregarPropiedad(prop1);
		user1.agregarPropiedad(prop2);
		
		prop1.agregarReserva(res1);
		prop2.agregarReserva(res2);

		assertEquals(200, user1.calcularIngresos(fechaQueCoincideCon1));
		assertEquals(400, user1.calcularIngresos(fechaQueCoincideCon2));
		assertEquals(0, user1.calcularIngresos(fechaQueNoCoincide));
	}
	
	@Test
	public void cancelarReserva () {

		DateLapse fechaFlex = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		DateLapse fechaMod = new DateLapse (LocalDate.of(2022, 11, 16), LocalDate.of(2022, 11, 20));
		DateLapse fechaEstricta = new DateLapse (LocalDate.of(2022, 11, 16), LocalDate.of(2022, 11, 20));
		
		
		Reserva reservaProp1 = prop1.reservar(fechaFlex, inquilino);
		//La fechaReserva va del 5 al 15 del 11
		LocalDate fechaCancelacionFlexLimite = LocalDate.of(2022, 11, 5);
		LocalDate fechaCancelacionFlexAntes = LocalDate.of(2022, 11, 4);
		LocalDate fechaCancelacionFlexDesp = LocalDate.of(2022, 11, 8);
		
		assertEquals(0, prop1.cancelarReserva(reservaProp1, fechaCancelacionFlexLimite));
		assertEquals(reservaProp1.calcularPrecio(), prop1.cancelarReserva(reservaProp1, fechaCancelacionFlexAntes));
		assertEquals(0, prop1.cancelarReserva(reservaProp1, fechaCancelacionFlexDesp));
		
		
		Reserva reservaProp2 = prop2.reservar(fechaMod, inquilino);
		//La otraFechaReserva va del 16 al 20 del 11
		LocalDate fechaCancelacionModMas7Dias = LocalDate.of(2022, 11, 5);
		LocalDate fechaCancelacionMod7Dias = LocalDate.of(2022, 11, 9);
		LocalDate fechaCancelacionMod6Dias = LocalDate.of(2022, 11, 10);
		LocalDate fechaCancelacionModMas2Dias = LocalDate.of(2022, 11, 12);
		LocalDate fechaCancelacionMod1Dia = LocalDate.of(2022, 11, 15);
		
		assertEquals(reservaProp2.calcularPrecio(), prop2.cancelarReserva(reservaProp2, fechaCancelacionModMas7Dias));
		assertEquals(reservaProp2.calcularPrecio()/2, prop2.cancelarReserva(reservaProp2, fechaCancelacionMod7Dias));
		assertEquals(reservaProp2.calcularPrecio()/2, prop2.cancelarReserva(reservaProp2, fechaCancelacionMod6Dias));
		assertEquals(reservaProp2.calcularPrecio()/2, prop2.cancelarReserva(reservaProp2, fechaCancelacionModMas2Dias));
		assertEquals(0, prop2.cancelarReserva(reservaProp2, fechaCancelacionMod1Dia));
		
		Reserva reservaProp3 = prop3.reservar(fechaEstricta, inquilino);
		//La otraFechaReserva va del 16 al 20 del 11
		LocalDate fechaCancelacionEstLimite = LocalDate.of(2022, 11, 5);
		LocalDate fechaCancelacionEstAntes = LocalDate.of(2022, 11, 4);
		LocalDate fechaCancelacionEstDesp = LocalDate.of(2022, 11, 8);
		
		assertEquals(0, prop3.cancelarReserva(reservaProp3, fechaCancelacionEstLimite));
		assertEquals(0, prop3.cancelarReserva(reservaProp3, fechaCancelacionEstAntes));
		assertEquals(0, prop3.cancelarReserva(reservaProp3, fechaCancelacionEstDesp));
		
	}
}
