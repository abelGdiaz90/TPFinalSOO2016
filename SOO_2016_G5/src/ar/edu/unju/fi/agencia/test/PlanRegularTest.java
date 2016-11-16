package ar.edu.unju.fi.agencia.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unju.fi.agencia.Cliente;
import ar.edu.unju.fi.agencia.PlanRegular;
import ar.edu.unju.fi.agencia.Vehiculo;
import junit.framework.TestCase;

public class PlanRegularTest extends TestCase {

	private PlanRegular planRegular;
	private Cliente cliente;
	private Vehiculo vehiculo;
	
	@Before
	public void setUp() throws Exception {
		
		cliente = new Cliente("Abel Guillermo", "Diaz");
		vehiculo = new Vehiculo(320000, "Toyota");
		planRegular = new PlanRegular(cliente, vehiculo, 80);
	}

	@After
	public void tearDown() throws Exception {
		cliente = null;
		vehiculo = null;
		planRegular = null;
	}

	@Test
	public void testPlanRegular() {
		
		assertEquals(cliente, planRegular.getCliente());
		assertEquals(vehiculo, planRegular.getVehiculo());
		assertEquals("Plan Regular", planRegular.getNombrePlan());
	
	}
	public void testDineroPorCobrar() {
		
		assertEquals(320000, planRegular.dineroPorCobrar(), 0.0);
		
	}
	
	public void testCuotasFechas(){
		
		for (int i = 0; i< planRegular.getCuotasImpagas().size();i++){
			assertNull(planRegular.getCuotasImpagas().get(i).getFechaPagada());
		}
		for (int i = 0; i< planRegular.getCuotasPagadas().size();i++){
			assertNotNull(planRegular.getCuotasPagadas().get(i).getFechaPagada());
		}
	}
	
	public void testCantidadDeCuotas(){
		 	
		assertEquals(80,planRegular.getCuotas().size());
		assertEquals(80,planRegular.getCuotasImpagas().size());
		assertEquals(0,planRegular.getCuotasPagadas().size());
			
	}
	
	public void testMontoCuota() {
		
		for (int i = 0; i < planRegular.getCuotas().size(); i++) {
			assertNotNull(planRegular.getCuotas().get(i).getMonto());
		}	
	}
	

}
