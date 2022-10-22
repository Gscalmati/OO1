package testVersionGio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.*;

import versionGio.*;

public class DistribuidoraTest {

	private Distribuidora distribuidoraLlena, distribuidoraVacia;
	private Usuario carlos, pedro, maria;
	private Consumo bajo, medio, alto;
	
	@BeforeEach
	public void setUp () {
		
		this.distribuidoraLlena = new Distribuidora (100);
		this.distribuidoraVacia = new Distribuidora (50);
		
		this.carlos = new Usuario ("La Plata", "Carlos");
		this.pedro = new Usuario ("Ensenada", "Pedro");
		this.maria = new Usuario ("City Bell", "Maria");
		
		this.bajo = new Consumo (LocalDate.of(2022, 10, 31), 100, 100);
		this.medio = new Consumo (LocalDate.of(2022, 10, 31), 500, 500);
		this.alto = new Consumo (LocalDate.of(2022, 10, 31), 1000, 1000);
		
		this.carlos.agregarMedicion(this.bajo);
		this.pedro.agregarMedicion(this.medio);
		this.maria.agregarMedicion(this.alto);
		
		this.distribuidoraLlena.agregarUsuario(this.maria);
		this.distribuidoraLlena.agregarUsuario(this.pedro);
		this.distribuidoraLlena.agregarUsuario(this.carlos);
		
	}
	
	@Test
	public void consumoTotalLlena () {
		assertEquals(1600, this.distribuidoraLlena.consumoTotalActiva());
	}
	
	@Test
	public void consumoTotalVacia () {
		assertEquals(0, this.distribuidoraVacia.consumoTotalActiva());
	}
	
	@Test
	public void facturar () {
		List<Factura> resultado = this.distribuidoraLlena.facturar();
		assertNotNull(resultado);
		assertEquals(3, resultado.size());
	}
}
