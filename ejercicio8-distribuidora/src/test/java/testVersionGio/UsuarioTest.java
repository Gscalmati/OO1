package testVersionGio;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

import versionGio.*;

public class UsuarioTest {
	
	private Usuario usuario;
	
	private Consumo consumoEnero;
	private Consumo consumoFebrero;
	private Consumo consumoSeptiembre;
	
	private Consumo consumoOctubre;
	
	
	private Usuario usuarioSinDescuento;
	private Usuario usuarioVacio;
	
	@BeforeEach
	public void setUp() {
		this.usuario = new Usuario ("La Plata", "Pedro");
		this.usuarioSinDescuento = new Usuario ("City Bell", "Maria");
		this.usuarioVacio = new Usuario ("La Plata", "Mario");
		
		this.consumoEnero = new Consumo (LocalDate.of(2022, 1, 10), 100, 100);
		this.consumoFebrero = new Consumo (LocalDate.of(2022, 2, 10), 200, 200);
		this.consumoSeptiembre = new Consumo (LocalDate.of(2022, 9, 10), 800, 100);
		this.consumoOctubre = new Consumo(LocalDate.of(2022, 10, 31), 500, 500);
		
		this.usuario.agregarMedicion(consumoEnero);
		this.usuario.agregarMedicion(consumoFebrero);
		this.usuario.agregarMedicion(consumoSeptiembre);
		
		this.usuarioSinDescuento.agregarMedicion(consumoOctubre);
	}
	
	@Test
	public void testUltimaMedicionActiva () {
		
		assertEquals(800, this.usuario.ultimoConsumoActiva());
		assertEquals(500, this.usuarioSinDescuento.ultimoConsumoActiva());
		assertEquals(0, this.usuarioVacio.ultimoConsumoActiva());
	}
	
	@Test
	public void testUltimoConsumo () {
		Consumo resultado = this.usuario.ultimoConsumo();
		assertEquals(800, resultado.getConsumoEnergiaActiva());
		assertEquals(null, this.usuarioVacio.ultimoConsumo());
	}
	
	@Test
	public void facturarEnBaseAUsuario () {
		Factura resultado = this.usuario.facturarEnBaseA(10);
		assertEquals(7200, resultado.getMontoTotal());
		assertEquals(10, resultado.getDescuento());
		assertEquals(LocalDate.now(), resultado.getFecha()); //Por qué?
	}
	
	@Test
	public void facturarSinDescuento () {
		Factura resultado = this.usuarioSinDescuento.facturarEnBaseA(10);
		assertEquals(5000, resultado.getMontoTotal());
		assertEquals(0, resultado.getDescuento());
		assertEquals(LocalDate.now(), resultado.getFecha()); //Por qué?
	}
	
	@Test void facturarVacio () {
		Factura resultado = this.usuarioVacio.facturarEnBaseA(10);
		assertEquals(0, resultado.getMontoTotal());
		assertEquals(0, resultado.getDescuento());
	}

}
