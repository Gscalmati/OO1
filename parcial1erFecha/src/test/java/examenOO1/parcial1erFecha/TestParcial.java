package examenOO1.parcial1erFecha;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestParcial {

	
	private ServicioBienes servB;
	private ServicioContribuyentes servC;
	
	private Contribuyente c1;
	private Contribuyente c2;
	private Contribuyente c3;
	
	private Bien bViejoCaro;
	private Bien bViejoBarato;
	private Bien bNuevoCaro;
	private Bien bNuevoBarato;
	
	private Bien bMaria1;
	private Bien bMaria2;
	
	@BeforeEach
	public void setUp() {
		this.servB = new ServicioBienes ();
		this.servC = new ServicioContribuyentes();
		
		this.c1 = servC.addContribuyente("Pedro", 111111, "Ensenada");
		this.c2 = servC.addContribuyente("Carlos", 2222222, "Ensenada");
		this.c3 = servC.addContribuyente("Maria", 3333333, "La Plata");
		
		this.bViejoCaro = servB.addEmbarcacion("BVC1", LocalDate.of(1995, 10, 10), 1500000.0, "El Corsario Caro", c1);
		this.bNuevoCaro = servB.addEmbarcacion("BNC1", LocalDate.of(2015, 10, 10), 1500000.0, "El Botesote Caro", c1);
		
		this.bViejoBarato = servB.addEmbarcacion("BVB2", LocalDate.of(1995, 10, 10), 50000.0, "El Corsario", c2);
		this.bNuevoBarato = servB.addEmbarcacion("BNB2", LocalDate.of(2015, 10, 10), 50000.0, "El Botesote", c2);
		
		this.bMaria1 = servB.addEmbarcacion("BM1", LocalDate.of(2015, 10, 10), 99999999.0, "La Chola", c3);
		this.bMaria2 = servB.addEmbarcacion("La Niña", LocalDate.of(1492, 10, 10), 99999999.0, "La Niña", c3);
	}
	
	@Test
	public void testColecciones () {
		assertEquals(3, this.servC.cantContribuyentes());
		assertEquals(2, this.c1.cantBienes());
	}
	
	@Test
	public void calcularImpuestos () {
		assertEquals(bViejoCaro.calcularImpuesto() + bNuevoCaro.calcularImpuesto(), this.c1.calcularImpuestos());
		assertEquals(bViejoBarato.calcularImpuesto() + bNuevoBarato.calcularImpuesto(), this.c2.calcularImpuestos());
	}
	
	@Test
	public void calcularContribuyentesLocalidad() {
		assertEquals(2, this.servC.contribuyentesPorLocalidad("Ensenada").size());
	}
}
