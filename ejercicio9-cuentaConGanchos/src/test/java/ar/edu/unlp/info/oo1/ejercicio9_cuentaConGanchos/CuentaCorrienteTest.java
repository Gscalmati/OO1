package ar.edu.unlp.info.oo1.ejercicio9_cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CuentaCorrienteTest {

	private CuentaCorriente caja;
	private CuentaCorriente cajaDestino;
	
	@BeforeEach
	public void setUp() {
		caja = new CuentaCorriente ();
		cajaDestino = new CuentaCorriente();
	}
	
	@Test
	public void descubierto () {
		caja.setDescubiertoTotal(2000);
		assertEquals(-2000, caja.getDescubiertoTotal());
	}
	
	@Test
	public void depositar () {
		caja.depositar(500);
		assertEquals(500, caja.getSaldo());
		caja.depositar(0);
		assertEquals(500, caja.getSaldo());
	}
	
	@Test
	public void extraer () {
		caja.depositar(1000);
		caja.extraer(500);
		assertEquals(500, caja.getSaldo());
		caja.depositar(0);
		assertEquals(500, caja.getSaldo());
	}
	
	@Test
	public void extraerConDescubierto () {
		caja.setDescubiertoTotal(2000);
		caja.depositar(1000);
		caja.extraer(1000);
		assertEquals(0, caja.getSaldo());
		
		caja.extraer(500);
		assertEquals(-500, caja.getSaldo());
		
		caja.extraer(1500);
		assertEquals(-2000, caja.getSaldo());
		
		boolean resp = caja.extraer(1);
		assertFalse(resp);
		assertEquals(-2000, caja.getSaldo());
	}
	
	
	@Test
	public void transferir () {
		caja.depositar(1000);
		caja.transferirACuenta(500, cajaDestino);
		assertEquals(500, caja.getSaldo());
		assertEquals(500, cajaDestino.getSaldo());
	}
	
	@Test
	public void transferirConDescubierto () {
		caja.setDescubiertoTotal(2000);
		cajaDestino.setDescubiertoTotal(2000);
		
		caja.depositar(1000);
		
		caja.transferirACuenta(1500, cajaDestino);
		
		assertEquals(-500, caja.getSaldo());
		assertEquals(1500, cajaDestino.getSaldo());
	
		cajaDestino.transferirACuenta(3500, caja);
		assertEquals(3000, caja.getSaldo());
		
		boolean resp = cajaDestino.extraer(1);
		assertFalse(resp);
		assertEquals(-2000, cajaDestino.getSaldo());
	}
}
