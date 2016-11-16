package ar.edu.unju.fi.agencia.test;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import ar.edu.unju.fi.agencia.Agencia;
import ar.edu.unju.fi.agencia.Cliente;
import ar.edu.unju.fi.agencia.Vehiculo;
import junit.framework.TestCase;

public class AgenciaTest extends TestCase{

	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	private Cliente cliente4;

	private Vehiculo vehiculo1;
	private Vehiculo vehiculo2;
	private Vehiculo vehiculo3;
	private Vehiculo vehiculo4;
	
	private Agencia agencia;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		cliente1 = new Cliente("Abel Guillermo", "Diaz");
		cliente2 = new Cliente("Fabian Nestor", "Arjona");
		cliente3 = new Cliente("Marta Elena", "Luna");
		cliente4 = new Cliente("Gustavo Abel", "Diaz");	
		
		vehiculo1 = new Vehiculo(350000, "Peugeot");
		vehiculo2 = new Vehiculo(320000, "Ford");
		vehiculo3 = new Vehiculo(450000, "Toyota");
		vehiculo4 = new Vehiculo(510000, "Nissan");
		
		agencia = new Agencia ("Norte Automotores SRL");
		
		agencia.CrearPlan3070(cliente1, vehiculo1, 80);
		agencia.CrearPlan3070(cliente2, vehiculo2, 60);
		agencia.CrearPlanRegular(cliente3, vehiculo3, 80);
		agencia.CrearPlanRegular(cliente4, vehiculo4, 60);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCrearPlan3070(){
		assertEquals(cliente1, agencia.getPlanes().get(0).getCliente());
		assertEquals(vehiculo1, agencia.getPlanes().get(0).getVehiculo());
	}
	
	public void testCrearPlanRegular() {
		assertEquals(cliente3, agencia.getPlanes().get(2).getCliente());
		assertEquals(vehiculo3, agencia.getPlanes().get(2).getVehiculo());
		
	}
	
	public void testDineroPorCobrar() {			
		double deudaEsperada = 350000+320000+450000+510000;
		assertEquals(deudaEsperada, agencia.dineroPorCobrar(),0.0001);		
	}
	
	public void testClienteQueMenosDebe() {
		assertEquals(cliente2,agencia.clienteQueMenosDebe());		
	}
	
	public void testDeudaCliente(){
		assertEquals(510000,agencia.getDeudaCliente(cliente4),0.0);
	}
	
	public void testGetTipoPlanCliente() {
		assertEquals("Plan Regular", agencia.getTipoPlanCliente(cliente3));
		assertEquals("Plan 30/70", agencia.getTipoPlanCliente(cliente1));
	}
	
	public void testGetPlanes () {
		assertEquals(4,agencia.getPlanes().size());
	}
	
	public void  testGetCantidadCuotasPagadasCliente() {	
		assertEquals(0,agencia.getCuotaPagadasCliente(cliente1).size());
		assertEquals(0,agencia.getCuotaPagadasCliente(cliente3).size());
		
	}
	
	public void testGetCantidadCuotasImpagas() {
		assertEquals(80,agencia.getCantidadCuotasImpagas(cliente1));
		assertEquals(80,agencia.getCantidadCuotasImpagas(cliente3));
	}
	
	public void testPagarCuotaCliente() {
		
		agencia.pagarCuotaCliente(cliente1);
		agencia.pagarCuotaCliente(cliente3);
		
		assertEquals(1, agencia.getCuotaPagadasCliente(cliente1).size());
		assertEquals(1, agencia.getCuotaPagadasCliente(cliente3).size());
		
		assertEquals(79, agencia.getCantidadCuotasImpagas(cliente1));
		assertEquals(79, agencia.getCantidadCuotasImpagas(cliente3));

	}
	
}
