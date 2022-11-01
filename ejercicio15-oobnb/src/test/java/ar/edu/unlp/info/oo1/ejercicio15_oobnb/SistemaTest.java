package ar.edu.unlp.info.oo1.ejercicio15_oobnb;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SistemaTest {

	private Sistema sistema;
	private Usuario user1;
	private Usuario user2;
	
	private Propiedad prop1;
	private Propiedad prop2;
	private Propiedad prop3;
	
	@BeforeEach
	public void setUp() {
		sistema = new Sistema();
		
		user1 = sistema.registrarUsuario("Juli", "Av. 60 485", 1111111);
		user2 = sistema.registrarUsuario("Gio", "Alberdi 261", 2222222);
		
		prop1= sistema.registrarPropiedad("Atahualpa", "Mina Clavero", 20, "Lejos 123", user1);
		prop2= sistema.registrarPropiedad("RDE", "PDE", 40, "Este 234", user1);
		prop3= sistema.registrarPropiedad("RDA", "SDA", 50, "Sur 123", user2);
		
	}
	
	@Test
	public void testearVariables () {
		assertEquals("Juli", user1.getNombre());
		assertEquals("RDE", prop2.getNombre());
	}
	
	//FALTAN TESTS
}
