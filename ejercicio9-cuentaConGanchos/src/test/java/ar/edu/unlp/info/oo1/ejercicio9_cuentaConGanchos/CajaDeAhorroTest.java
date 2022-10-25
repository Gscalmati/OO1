package ar.edu.unlp.info.oo1.ejercicio9_cuentaConGanchos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CajaDeAhorroTest {

	private CajaDeAhorro caja;
	private CajaDeAhorro cajaDestino;
	
	@BeforeEach
	public void setUp() {
		caja = new CajaDeAhorro ();
		cajaDestino = new CajaDeAhorro();
	}
	
	@Test
	public void depositar () {
		caja.depositar(500);
		assertEquals(490, caja.getSaldo());
		caja.depositar(0);
		assertEquals(490, caja.getSaldo());
	}
	
	@Test
	public void extraer () {
		caja.depositar(1000);
		//Aqui queda el saldo en 980
		caja.extraer(500);
		//Le extraigo 510
		assertEquals(980-510, caja.getSaldo());
		
		caja.extraer(0);
		assertEquals(980-510, caja.getSaldo());
	}
	
	@Test
	public void costosTransaccion () {
		assertEquals(2, caja.getCostoTransaccion());
		assertEquals("2.0%", caja.getTasaTransaccion());
		caja.setCostoTransaccion(5);
		assertEquals(5, caja.getCostoTransaccion());
	}
	
	@Test
	public void transferir () {
		caja.depositar(1000);
		//Quedan 980
		caja.transferirACuenta(500, cajaDestino);
		//Transfiero 500, y me debitan 10 más de la tasa
		assertEquals(980-510, caja.getSaldo());
		//A la destino le llegan 500 y le sacan el 2%
		assertEquals(490, cajaDestino.getSaldo());
		
		caja.transferirACuenta(0, cajaDestino);
		assertEquals(980-510, caja.getSaldo());
		assertEquals(490, cajaDestino.getSaldo());
	}
	

}