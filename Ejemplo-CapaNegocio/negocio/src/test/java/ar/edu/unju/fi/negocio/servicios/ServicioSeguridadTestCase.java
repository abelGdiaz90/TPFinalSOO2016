package ar.edu.unju.fi.negocio.servicios;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ar.edu.unju.fi.model.domain.Usuario;

/**
 * Test del Servicio Seguridad
 * @author Jose
 *
 */
public class ServicioSeguridadTestCase {
	private ServicioSeguridad servicioSeguridad;

	
	@Before
	public void setUp() throws Exception {
		
		 ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		 servicioSeguridad = (ServicioSeguridad) context.getBean("servicioSeguridadImpl");		 

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testListaUsuarios() {
		try {

			assertNotNull(servicioSeguridad.listaUsuarios());

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
