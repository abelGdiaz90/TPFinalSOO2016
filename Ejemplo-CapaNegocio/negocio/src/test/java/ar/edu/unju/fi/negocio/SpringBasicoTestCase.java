package ar.edu.unju.fi.negocio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.unju.fi.model.domain.Usuario;

/**
 * Test Ejemplo para verificar la inyección de dependencias
 *  
 * @author Jose
 *
 */
public class SpringBasicoTestCase {
	
	private Usuario usuario;
	private Ejemplo ejemplo;
	private ApplicationContext context;
	
	
	@Before
	public void setUp() throws Exception {
		 
		context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
	}

	@After
	public void tearDown() throws Exception {
		usuario = null;
		ejemplo = null;
	}

	@Test
	public void testSpring() {

		ejemplo = (Ejemplo) context.getBean("ejemplo");		 
		assertNotNull(ejemplo);
		
		String expectedName = "pepe";
		usuario = (Usuario) context.getBean("user");
		assertEquals(usuario.getApellidoNombre(), expectedName);

	}

}
