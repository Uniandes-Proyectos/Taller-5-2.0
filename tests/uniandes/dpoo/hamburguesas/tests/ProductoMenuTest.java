package uniandes.dpoo.hamburguesas.tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;

public class ProductoMenuTest {
	private ProductoMenu producto;
	@BeforeEach
	void setup() {
		producto=new ProductoMenu("corral",14000);
	}
	@Test
	void testNombre() {
		assertEquals("corral",producto.getNombre());
	}
	@Test
	void testPrecio() {
		assertEquals(14000,producto.getPrecio());
	}
	@Test
	void testFactura() {
		String factura=producto.generarTextoFactura();
		assertTrue(factura.contains("corral"));
		assertTrue(factura.contains("14000"));
		
	}
}
