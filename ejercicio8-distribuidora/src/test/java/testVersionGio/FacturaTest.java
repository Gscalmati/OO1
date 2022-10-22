package testVersionGio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.*;

import versionGio.*;
public class FacturaTest {
	
	private Usuario usuario;
	private Factura factura;
	
	@BeforeEach
	public void setUp () {
		this.usuario = new Usuario ("La Plata", "Mario");
		this.factura = new Factura (1000, 10, this.usuario);
	}
	
	@Test
	public void montoTotal () {
		assertEquals(900, this.factura.getMontoTotal());
	}
	
	@Test
	public void valoresInternos () {
		assertEquals(10, this.factura.getDescuento());
		assertEquals (this.usuario, this.factura.getUsuario());
		assertEquals (LocalDate.now(), this.factura.getFecha());
	}

}
