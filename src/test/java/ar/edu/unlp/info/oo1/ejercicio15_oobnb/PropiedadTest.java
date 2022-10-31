package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropiedadTest {
	
	private Usuario user1;
	private Usuario user2;
	
	private Propiedad prop1;
	private Propiedad prop2;
	
	private Reserva reservaNueva;
	private Reserva reservaInvalida;
	private Reserva reservaParcialmenteInvalida;
	
	private Usuario inquilino;
	
	private DateLapse fechaReserva;
	private DateLapse otraFechaReserva;
	private DateLapse fechaCompleta;
	private DateLapse fechaAfuera;
	private DateLapse fechaParcialAdentro;
	
	private DateLapse fechaInvalida;
	private DateLapse fechaParcialmenteInvalida;
	
	@BeforeEach
	public void setUp() {
		
		inquilino = new Usuario ("Juli", "Av. 60 485", 1111111);
		
		prop1= new Propiedad("Atahualpa", "Mina Clavero", 20, "Lejos 123");
		prop2= new Propiedad("RDE", "PDE", 100, "----");
		
		
		fechaReserva = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		otraFechaReserva = new DateLapse (LocalDate.of(2022, 11, 16), LocalDate.of(2022, 11, 20));
		
		fechaCompleta = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 20));
		
		fechaInvalida = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 25));
		fechaParcialmenteInvalida = new DateLapse (LocalDate.of(2022, 11, 15), LocalDate.of(2022, 11, 20));
		
		fechaAfuera = new DateLapse (LocalDate.of(2022, 11, 25), LocalDate.of(2022, 11, 30));
		fechaParcialAdentro = new DateLapse (LocalDate.of(2022, 11, 6), LocalDate.of(2022, 11, 30));
	}	
	
	@Test
	public void reservar() {
		reservaNueva = prop1.reservar(fechaReserva, inquilino);
		assertNotNull(reservaNueva);
		assertTrue(inquilino.getReservas().contains(reservaNueva));
		assertTrue(prop1.getFechasReservadas().contains(reservaNueva));
		
		reservaInvalida = prop1.reservar(fechaInvalida, inquilino);
		assertNull(reservaInvalida);
		assertFalse(inquilino.getReservas().contains(reservaInvalida));
		assertFalse(prop1.getFechasReservadas().contains(reservaInvalida));
		
		reservaParcialmenteInvalida = prop1.reservar(fechaParcialmenteInvalida, inquilino);
		assertNull(reservaParcialmenteInvalida);
		assertFalse(inquilino.getReservas().contains(reservaParcialmenteInvalida));
		assertFalse(prop1.getFechasReservadas().contains(reservaParcialmenteInvalida));
	}
	
	@Test
	public void agregarYEliminar () {
		assertEquals(prop1.getFechasReservadas().size(), 0);
		prop1.agregarReserva(reservaNueva);
		assertEquals(prop1.getFechasReservadas().size(), 1);
		assertTrue(prop1.getFechasReservadas().contains(reservaNueva));
		
		prop1.eliminarReserva(reservaNueva);
		assertEquals(prop1.getFechasReservadas().size(), 0);
		assertFalse(prop1.getFechasReservadas().contains(reservaNueva));
	}
	
	@Test
	public void calcularIngresos() {
		prop1.reservar(fechaReserva, inquilino);
		prop1.reservar(otraFechaReserva, inquilino);
		prop2.reservar(fechaReserva, inquilino);
		assertEquals(200, prop1.calcularIngresos(fechaReserva));
		assertEquals(80, prop1.calcularIngresos(otraFechaReserva));
		assertEquals(280, prop1.calcularIngresos(fechaCompleta));
		assertEquals(0, prop1.calcularIngresos(fechaAfuera));
		assertEquals(280, prop1.calcularIngresos(fechaParcialAdentro));
	}

}