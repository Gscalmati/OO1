package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

	private Usuario user1;
	private Usuario user2;
	
	private Propiedad prop1;
	private Propiedad prop2;
	
	private Reserva res1;
	private Reserva res2;
	private Reserva res3;
	
	private Usuario inquilino;
	
	@BeforeEach
	public void setUp() {
		
		user1 = new Usuario ("Juli", "Av. 60 485", 1111111);
		user2 = new Usuario ("Gio", "Alberdi 261", 2222222);
		
		prop1= new Propiedad("Atahualpa", "Mina Clavero", 20, "Lejos 123");
		prop2= new Propiedad("RDE", "PDE", 40, "Este 234");
		
		DateLapse fecha1 = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		res1 = new Reserva (fecha1, prop1);
		DateLapse fecha2 = new DateLapse (LocalDate.of(2022, 11, 20), LocalDate.of(2022, 11, 25));
		res2 = new Reserva (fecha2, prop2);
		DateLapse fecha3 = new DateLapse (LocalDate.of(2022, 11, 10), LocalDate.of(2022, 11, 20));
		res3 = new Reserva (fecha3, prop1);
		
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
		DateLapse fechaQueNoCoincide = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		
		user1.agregarPropiedad(prop1);
		user1.agregarPropiedad(prop2);
		
		inquilino.agregarReserva(res1);
		inquilino.agregarReserva(res2);
		inquilino.agregarReserva(res3);
		
		//No anda
		
		
		
	}
}
