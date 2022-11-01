package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

public class ReservaTest {

	private Propiedad prop1;
	private Propiedad prop2;
	
	private Reserva res1;
	private Reserva res2;
	private Reserva res3;
	
	private Reserva reservaPasada;
	private Reserva reservaFuturo;
	
	private CancelacionFlexible flexible;
	private CancelacionModerada moderada;
	
	
	@BeforeEach
	public void setUp() {
		flexible = new CancelacionFlexible();
		moderada = new CancelacionModerada ();
		
		prop1= new Propiedad("Atahualpa", "Mina Clavero", 20, "Lejos 123",flexible);
		prop2= new Propiedad("RDE", "PDE", 40, "Este 234", moderada);
		
		DateLapse fecha1 = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		res1 = new Reserva (fecha1, prop1);
		DateLapse fecha2 = new DateLapse (LocalDate.of(2022, 11, 20), LocalDate.of(2022, 11, 25));
		res2 = new Reserva (fecha2, prop2);
		DateLapse fecha3 = new DateLapse (LocalDate.of(2022, 11, 10), LocalDate.of(2022, 11, 20));
		res3 = new Reserva (fecha3, prop1);
	}
	
	@Test
	public void calcularPrecio () {
		assertEquals(200, res1.calcularPrecio());
		assertEquals(200, res2.calcularPrecio());
	}
	
	@Test
	public void fechaReservada () {
		DateLapse fechaIdentica = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		DateLapse fechaCotaMin = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 10));
		DateLapse fechaCotaMax = new DateLapse (LocalDate.of(2022, 11, 10), LocalDate.of(2022, 11, 15));
		DateLapse fechaMedio = new DateLapse (LocalDate.of(2022, 11, 10), LocalDate.of(2022, 11, 12));
		DateLapse fechaAfuera = new DateLapse (LocalDate.of(2022, 11, 16), LocalDate.of(2022, 11, 25));
		DateLapse fechaParcialDentro = new DateLapse (LocalDate.of(2022, 11, 01), LocalDate.of(2022, 11, 06));
		
		assertTrue(res1.fechaReservada(fechaIdentica));
		assertTrue(res1.fechaReservada(fechaCotaMin));
		assertTrue(res1.fechaReservada(fechaCotaMax));
		assertTrue(res1.fechaReservada(fechaMedio));
		assertFalse(res1.fechaReservada(fechaAfuera));
		assertTrue(res1.fechaReservada(fechaParcialDentro));
	}
	
	@Test
	public void esFechaPosterior() {
		DateLapse fechaPas = new DateLapse (LocalDate.of(2022, 10, 10), LocalDate.of(2022, 10, 20));
		reservaPasada = new Reserva (fechaPas, prop1);
		
		DateLapse fechaFut = new DateLapse (LocalDate.of(2022, 11, 10), LocalDate.of(2022, 11, 20));
		reservaFuturo = new Reserva (fechaFut, prop1);
		
		assertTrue(reservaFuturo.esFechaPosterior());
		assertFalse(reservaPasada.esFechaPosterior());
	}
	
	@Test
	public void incluye () {
		DateLapse fechaIdentica = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 15));
		DateLapse fechaCotaMin = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 10));
		DateLapse fechaCotaMax = new DateLapse (LocalDate.of(2022, 11, 10), LocalDate.of(2022, 11, 15));
		DateLapse fechaMedio = new DateLapse (LocalDate.of(2022, 11, 10), LocalDate.of(2022, 11, 12));
		DateLapse fechaAfuera = new DateLapse (LocalDate.of(2022, 11, 16), LocalDate.of(2022, 11, 25));
		DateLapse fechaParcialDentro = new DateLapse (LocalDate.of(2022, 11, 01), LocalDate.of(2022, 11, 06));
		DateLapse fechaParcialDentro2 = new DateLapse (LocalDate.of(2022, 11, 12), LocalDate.of(2022, 11, 18));
		DateLapse fechaCompleta = new DateLapse (LocalDate.of(2022, 11, 05), LocalDate.of(2022, 11, 20));

		
		assertTrue(res1.incluye(fechaIdentica));
		assertTrue(res1.incluye(fechaCotaMin));
		assertTrue(res1.incluye(fechaCotaMax));
		assertFalse(res1.incluye(fechaMedio));
		assertFalse(res1.incluye(fechaAfuera));
		assertTrue(res1.incluye(fechaParcialDentro));
		assertTrue(res1.incluye(fechaParcialDentro2));
		assertTrue(res1.incluye(fechaCompleta));
	}
}
