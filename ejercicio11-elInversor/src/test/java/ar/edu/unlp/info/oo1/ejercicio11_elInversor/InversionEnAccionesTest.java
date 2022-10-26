package ar.edu.unlp.info.oo1.ejercicio11_elInversor;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InversionEnAccionesTest {

	private InversionEnAcciones acc1;
	private InversionEnAcciones acc2;
	
	
	@BeforeEach
	public void setUp() {
		acc1 = new InversionEnAcciones ("MAC", 100, 25.50);
		acc2 = new InversionEnAcciones ("BTC", 1, 30000);
	}
	
	@Test
	public void initializer () {
		assertEquals(100, this.acc1.getCantidad());
		assertEquals(25.5, this.acc1.getValorUnitario());
	}
	
	@Test
	public void valorActual () {
		assertEquals (25.50*100, this.acc1.valorActual());
		assertEquals (30000*8961, this.acc2.valorActual());
	}
}
