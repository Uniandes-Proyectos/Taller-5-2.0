package uniandes.dpoo.hamburguesas.tests;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import uniandes.dpoo.hamburguesas.mundo.ProductoMenu;
import uniandes.dpoo.hamburguesas.mundo.Combo;


public class ComboTest {
	private Combo comboCorral;
	private Combo comboTodoterreno;
	private Combo comboEspecial;
	@BeforeEach
	void setUp() {
		//Combo corral
		ArrayList<ProductoMenu>productos1=new ArrayList<>();
		productos1.add(new ProductoMenu("corral",14000));
		productos1.add(new ProductoMenu("papas medianas",5500));
		productos1.add(new ProductoMenu("gaseosa",5000));
		comboCorral=new Combo("combo corral",0.10,productos1);
		//Combo todoterreno
		ArrayList<ProductoMenu>productos2=new ArrayList<>();
		productos2.add(new ProductoMenu("todoterreno",25000));
		productos2.add(new ProductoMenu("papas grandes",6900));
		productos2.add(new ProductoMenu("gaseosa",5000));
		comboTodoterreno=new Combo("combo todoterreno",0.07,productos2);
		//Combo especial
		ArrayList<ProductoMenu>productos3=new ArrayList<>();
		productos3.add(new ProductoMenu("especial",24000));
		productos3.add(new ProductoMenu("papas medianas",5500));
		productos3.add(new ProductoMenu("gaseosa",5000));
		comboEspecial=new Combo("combo especial",0.095,productos3);
		}
	//Test calcular precio
	@Test
	void testCalcularPrecios() {
		assertEquals(2450, comboCorral.getPrecio());
		assertEquals(2583, comboTodoterreno.getPrecio());
		assertEquals(3277, comboEspecial.getPrecio());
	}
	//Test devolver nombres
	@Test
	void testRetornarNombres() {
		assertEquals("combo corral", comboCorral.getNombre());
		assertEquals("combo todoterreno", comboTodoterreno.getNombre());
		assertEquals("combo especial", comboEspecial.getNombre());
		}
	//Test factura
	@Test
	void testFactura() {
		String facturaComboCorral=comboCorral.generarTextoFactura();
		assertTrue(facturaComboCorral.contains("combo corral"));
		assertTrue(facturaComboCorral.contains("0.1"));
		assertTrue(facturaComboCorral.contains("2450"));
		
		String facturaComboTodoterreno=comboTodoterreno.generarTextoFactura();
		assertTrue(facturaComboTodoterreno.contains("combo todoterreno"));
		assertTrue(facturaComboTodoterreno.contains("0.07"));
		assertTrue(facturaComboTodoterreno.contains("2583"));
		
		String facturaComboEspecial=comboEspecial.generarTextoFactura();
		assertTrue(facturaComboEspecial.contains("combo especial"));
		assertTrue(facturaComboEspecial.contains("0.095"));
		assertTrue(facturaComboEspecial.contains("3277"));
		
		
	}
	
	
	
}	
