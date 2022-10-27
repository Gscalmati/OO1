package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversorTest {
	
	private Inversor steve;
	private PlazoFijo pf1;
	private InversionEnAcciones acc1;
	
	@BeforeEach
	public void setUp() {
		steve = new Inversor ("Steve Jobs");
		pf1 = new PlazoFijo (LocalDate.of(2022, 10, 16), 1000, 4); //Plazo fijo con 10 dias
		acc1 = new InversionEnAcciones ("GOOG", 365, 100);
	}
	
	@Test
	public void initializer () {
		assertEquals(0, steve.getInversiones().size());
	}
	
	@Test
	public void agregarInversion () {
		steve.agregarInversion(pf1);
		steve.agregarInversion(acc1);
		assertTrue(steve.getInversiones().contains(pf1));
		assertTrue(steve.getInversiones().contains(acc1));
	}
	
	@Test 
	public void valorActual () {
		steve.agregarInversion(pf1);
		steve.agregarInversion(acc1);
		assertEquals(10400+36500, steve.valorActual());
	}
}
