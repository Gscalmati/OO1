package testVersionGio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

import versionGio.*;

public class ConsumoTest {
	
	private Consumo consumoEn0;
	private Consumo consumo;
	
	@BeforeEach
	public void setUp () {
		
		this.consumo = new Consumo (LocalDate.of(2022, 10, 31), 500, 500);
		this.consumoEn0 = new Consumo (LocalDate.of(22022, 10, 10), 0, 0);
		
	}
	
	@Test
	public void costoEnBaseA () {
		assertEquals(5000, this.consumo.costoEnBaseA(10));
		assertEquals(0 , this.consumoEn0.costoEnBaseA(10));
	}
	
	@Test
	public void factorDePotencia () {
		assertFalse(this.consumo.factorDePotencia() > 0.8);
	}
}
