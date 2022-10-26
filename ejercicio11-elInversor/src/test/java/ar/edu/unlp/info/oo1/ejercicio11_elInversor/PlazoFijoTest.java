package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlazoFijoTest {

	private PlazoFijo pf1;
	private PlazoFijo pf2;
	
	
	@BeforeEach
	public void setUp() {
		pf1 = new PlazoFijo (LocalDate.of(2022, 9, 25), 1000, 4);
		pf2 = new PlazoFijo (LocalDate.of(2022, 10, 20), 500, 1);
	}
	
	@Test
	public void initializer () {
		assertEquals(1000, this.pf1.getMontoDepositado());
		assertEquals(4, this.pf1.getPorcentajeDeInteresDiario());
		assertEquals(LocalDate.of(2022, 9, 25), this.pf1.getFechaDeConstitucion());
	}
	
	@Test
	public void valorActual () {
		assertEquals (2500+25, this.pf2.valorActual());
		assertEquals (30000+1200, this.pf1.valorActual());
	}
}
