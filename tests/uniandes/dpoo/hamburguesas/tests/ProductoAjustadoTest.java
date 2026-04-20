package uniandes.dpoo.hamburguesas.tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Ingrediente;
import uniandes.dpoo.hamburguesas.mundo.ProductoAjustado;

public class ProductoAjustadoTest {
	private ProductoAjustado producto;
	@BeforeEach
	void setup() {
		ProductoMenu base=new ProductoMenu("corral",14000);
		producto= new ProductoAjustado(base);
	}
	@Test
	void testNombre() {
		assertEquals("corral",producto.getNombre());
	}
	@Test
	void testPrecioSinCambios() {
		assertEquals(14000,producto.getPrecio());
	}
	@Test
	void testPrecioIngredientes() {
		Ingrediente queso=new Ingrediente("queso",2000);
		Ingrediente tocineta=new Ingrediente("tocinenta",6000);
	
		producto.agregarIngrediente(queso);
		producto.agregarIngrediente(tocineta);
		
		int valorEsperado=14000+2000+6000;
		assertEquals(valorEsperado,producto.getPrecio());
	}
	@Test
	void testFactura() {
		Ingrediente queso=new Ingrediente("queso",2000);
		producto.agregarIngrediente(queso);
		String factura=producto.generarTextoFactura();
		assertTrue(factura.contains("corral"));
		assertTrue(factura.contains("queso"));
		assertTrue(factura.contains("2000"));
	}
	@Test
	void testEliminarIngrediente() {
		Ingrediente cebolla=new Ingrediente("cebolla",3000);
		producto.eliminarIngrediente(cebolla);
		String factura=producto.generarTextoFactura();
		assertTrue(factura.contains("-cebolla"));
	}
	
}
