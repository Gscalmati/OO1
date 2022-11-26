package ar.edu.unlp.info.oo1.ejercicio19_ecommerce;

public class Pedido {
	
	private Producto producto;
	private Integer cant;
	private OpcionesPago pago;
	private Envios envio;

	
	public Pedido (Producto p, Integer c, OpcionesPago pag, Envios en) {
		this.producto = p;
		this.cant = c;
		this.pago = pag;
		this.envio = en;
	}
	public Double calcularCostoTotal() {
		return (this.pago.costo(this.costoPedido()) + this.envio.costo());
	}
	
	public Double costoPedido () {
		return this.producto.valor() * this.cant;
	}

}
