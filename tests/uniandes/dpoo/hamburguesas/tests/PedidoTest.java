package uniandes.dpoo.hamburguesas.tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;

import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Pedido;

public class PedidoTest{
	private Pedido pedido;
	
	@BeforeEach
	void setup() {
		pedido=new Pedido("Esteban","Calle 94A 11A");
		pedido.agregarProducto(new ProductoMenu("corral",14000));
		pedido.agregarProducto(new ProductoMenu("papas medianas",5500));
	}
	@AfterEach
	void tearDown() {
		Pedido.setNumeroPedidos(0);
		File archivo=new File("facturaEsteban.txt");
		if(archivo.exists()) {
			archivo.delete();
		}
	}
	@Test
	void testPrecioNeto(){
		int valorEsperado=14000+5500;
		assertEquals(valorEsperado,pedido.getPrecioNetoPedido());
		
	}
	@Test
	void testCalculoIva(){
		int neto=pedido.getPrecioNetoPedido();
		int valorEsperadoIva=(int)(neto*0.19);
		assertEquals(valorEsperadoIva,pedido.getPrecioIVAPedido());
	}
	@Test
	void testCalculoTotal() {
		int calculoTotal=pedido.getPrecioNetoPedido() +pedido.getPrecioIVAPedido();
		assertEquals(calculoTotal,pedido.getPrecioTotalPedido());
	}
	@Test
	void testFactura() {
		String factura=pedido.generarTextoFactura();
		assertTrue(factura.contains("Esteban"));
		assertTrue(factura.contains("Calle 94A 11A"));
		assertTrue(factura.contains("corral"));
		assertTrue(factura.contains("papas medianas"));
		assertTrue(factura.contains(String.valueOf(pedido.getPrecioTotalPedido())));
	}
	@Test
	void guardarFactura() {
		File archivo=new File("facturaEsteban.txt");
		assertDoesNotThrow(() ->pedido.guardarFactura(archivo));
		assertTrue(archivo.exists());
	}
}
