package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Aca escribiremos los test de unidad para cada clase 
 * 
 */
public class EcommerceTest {
	
	private ServicioUsuarios su;
	private ServicioProductos sp;
	
	private Vendedor vendedor;
	private Cliente cliente;
	
	private Producto conStock;
	private Producto sinStock;
	
	private Pedido pedidoContadoComercio;
	private Pedido pedidoCuotasCorreo;
	
	@BeforeEach
	void setUp() throws Exception {
		this.su = new ServicioUsuarios();
		this.sp = new ServicioProductos();
		
		this.vendedor = su.registrarVendedor("Vendedor", "Lejos 123");
		this.cliente = su.registrarCliente("Cliente", "Cerca 123");
		
		conStock = sp.registrarProducto("Lapicera", "Una Birome", (Double) 25.0, (Integer) 10, vendedor);
	}
	
    @Test
    public void testNombreCompleto() {
        assertEquals("Glosing, James", james.getNombreCompleto());
        assertEquals("van Rossum, Guido", guido.getNombreCompleto());
    }
}
