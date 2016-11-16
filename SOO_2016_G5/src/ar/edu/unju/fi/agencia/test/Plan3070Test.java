package ar.edu.unju.fi.agencia.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.unju.fi.agencia.*;
import junit.framework.TestCase;

public class Plan3070Test extends TestCase{

	private Plan3070 plan3070;
	private Cliente cliente;
	private Vehiculo vehiculo;
	
	@Before
	public void setUp() throws Exception {
		
		cliente = new Cliente("Abel Guillermo", "Diaz");
		vehiculo = new Vehiculo(320000, "Toyota");
		plan3070 = new Plan3070(cliente, vehiculo, 80);
	}

	@After
	public void tearDown() throws Exception {
		cliente = null;
		vehiculo = null;
		plan3070 = null;
	}

	@Test
	public void testPlan3070() {
		
		assertEquals(cliente, plan3070.getCliente());
		assertEquals(vehiculo, plan3070.getVehiculo());
		assertEquals("Plan 30/70", plan3070.getNombrePlan());
	
	}
	public void testDineroPorCobrar() {
		
		double montoEntrega = 320000*30/100;
		assertEquals(320000, plan3070.dineroPorCobrar(), 0.0);
		assertEquals(montoEntrega, plan3070.getMontoEntrega());
	}
	
	public void testCuotasFechas(){
		
		for (int i = 0; i< plan3070.getCuotasImpagas().size();i++){
			assertNull(plan3070.getCuotasImpagas().get(i).getFechaPagada());
		}
		for (int i = 0; i< plan3070.getCuotasPagadas().size();i++){
			assertNotNull(plan3070.getCuotasPagadas().get(i).getFechaPagada());
		}
	}
	
	public void testCantidadDeCuotas(){
		 	
		assertEquals(80,plan3070.getCuotas().size());
		assertEquals(80,plan3070.getCuotasImpagas().size());
		assertEquals(0,plan3070.getCuotasPagadas().size());
			
	}
	
	public void testMontoCuota() {
		
		for (int i = 0; i < plan3070.getCuotas().size(); i++) {
			assertNotNull(plan3070.getCuotas().get(i).getMonto());
		}	
	}
	

}
