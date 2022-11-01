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
	
	private CancelacionFlexible flexible;
	private CancelacionModerada moderada;
	
	@BeforeEach
	public void setUp() {
		
		flexible = new CancelacionFlexible();
		moderada = new CancelacionModerada ();
		
		inquilino = new Usuario ("Juli", "Av. 60 485", 1111111);
		
		prop1= new Propiedad("Atahualpa", "Mina Clavero", 20, "Lejos 123", flexible);
		prop2= new Propiedad("RDE", "PDE", 100, "----", moderada);
		
		
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
	
	@Test
	public void cancelarReserva () {
		Reserva reservaProp1 = prop1.reservar(fechaReserva, inquilino);
		//La fechaReserva va del 5 al 15 del 11
		LocalDate fechaCancelacionFlexLimite = LocalDate.of(2022, 11, 5);
		LocalDate fechaCancelacionFlexAntes = LocalDate.of(2022, 11, 4);
		LocalDate fechaCancelacionFlexDesp = LocalDate.of(2022, 11, 8);
		
		assertEquals(0, prop1.cancelarReserva(reservaProp1, fechaCancelacionFlexLimite));
		assertEquals(reservaProp1.calcularPrecio(), prop1.cancelarReserva(reservaProp1, fechaCancelacionFlexAntes));
		assertEquals(0, prop1.cancelarReserva(reservaProp1, fechaCancelacionFlexDesp));
		
		
		Reserva reservaProp2 = prop2.reservar(otraFechaReserva, inquilino);
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
		
	}

}