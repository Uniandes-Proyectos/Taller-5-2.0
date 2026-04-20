package uniandes.dpoo.hamburguesas.tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uniandes.dpoo.hamburguesas.excepciones.NoHayPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.excepciones.YaHayUnPedidoEnCursoException;
import uniandes.dpoo.hamburguesas.mundo.Pedido;
import uniandes.dpoo.hamburguesas.mundo.Restaurante;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;

public class RestauranteTest {

	private Restaurante restaurante;
	@BeforeEach
	void setup() {
		restaurante=new Restaurante();
		Pedido.setNumeroPedidos(0);
	}
	//Tests de Iniciar pedido y de Cerrar Pedido normales
	@Test
	void testIniciarPedido()throws Exception{
		restaurante.iniciarPedido("Esteban", "Calle 94 ");
		assertNotNull(restaurante.getPedidoEnCurso());
		assertEquals("Esteban",restaurante.getPedidoEnCurso().getNombreCliente());
	}	
	@Test
	void cerrarPedido()throws Exception{
		assertEquals(0,restaurante.getPedidos().size());
		restaurante.iniciarPedido("Esteban", "Calle 94 ");
		restaurante.cerrarYGuardarPedido();
		assertNull(restaurante.getPedidoEnCurso());
		assertEquals(1,restaurante.getPedidos().size());
	}	
	//Excepciones de pedidos en curso
	@Test
	void testYaHayUnPedidoEnCurso()throws Exception{
		restaurante.iniciarPedido("Esteban", "Calle 94 ");
		assertThrows(YaHayUnPedidoEnCursoException.class,()->{
		restaurante.iniciarPedido("Juliana", "Calle 94");
		});
		}
	@Test
	void testNoHayPedidoEnCurso() throws Exception {
		assertThrows(NoHayPedidoEnCursoException.class,()->{
			restaurante.cerrarYGuardarPedido();
		});
		}
	//Prueba restaurante flujo completo sin errores
	@Test
	void testFlujoCompletoRestaurante() throws Exception {

	    File ingredientes = new File("./data/ingredientes.txt");
	    File menu = new File("./data/menu.txt");
	    File combos = new File("./data/combos.txt");

	    restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);

	    restaurante.iniciarPedido("Esteban", "Calle 94");
	    assertNotNull(restaurante.getPedidoEnCurso());

	    restaurante.cerrarYGuardarPedido();
	    assertNull(restaurante.getPedidoEnCurso());
	    assertEquals(1, restaurante.getPedidos().size());
	}
	//Prueba carga de datos
	@Test
	void testCargarDatos()throws Exception{
		File ingredientes=new File("./data/ingredientes.txt");
		File menu=new File("./data/menu.txt");
		File combos=new File("./data/combos.txt");
		restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
		assertNotNull(restaurante.getIngredientes());
		assertNotNull(restaurante.getMenuBase());
		assertNotNull(restaurante.getMenuCombos());
		
	}
	//Pruebas de caso para combos, ingredientes y menu
	@Test
	void testCombosCasos() throws Exception {

	    File ingredientes = new File("./data/ingredientes.txt");
	    File menu = new File("./data/menu.txt");
	    File combos = new File("./data/combos.txt");

	    restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
	    assertTrue(restaurante.getMenuCombos().size() > 0);
	}
	
	@Test
	void testCombosCasosVacio() {
		assertEquals(0, restaurante.getMenuCombos().size());
	}
	
	@Test
	void testMenuCasos() throws Exception {

	    File ingredientes = new File("./data/ingredientes.txt");
	    File menu = new File("./data/menu.txt");
	    File combos = new File("./data/combos.txt");

	    restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
	    assertTrue(restaurante.getMenuBase().size() > 0);
	}
	
	@Test
	void testMenuCasosVacio() {
		assertEquals(0, restaurante.getMenuBase().size());
	}
	@Test
	void testIngredienteCasos() throws Exception {

	    File ingredientes = new File("./data/ingredientes.txt");
	    File menu = new File("./data/menu.txt");
	    File combos = new File("./data/combos.txt");

	    restaurante.cargarInformacionRestaurante(ingredientes, menu, combos);
	    assertTrue(restaurante.getIngredientes().size() > 0);
	}
	
	@Test
	void testIngredienteCasosVacio() {
		assertEquals(0, restaurante.getIngredientes().size());
	}
}
