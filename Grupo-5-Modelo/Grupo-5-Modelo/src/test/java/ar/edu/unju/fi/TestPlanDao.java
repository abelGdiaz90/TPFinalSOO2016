package ar.edu.unju.fi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.fi.unju.model.domian.Cliente;
import ar.edu.fi.unju.model.domian.Plan3070;
import ar.edu.fi.unju.model.domian.PlanRegular;
import ar.edu.fi.unju.model.domian.Vehiculo;
import ar.edu.unju.fi.model.dao.impl.ClienteDaoImpl;
import ar.edu.unju.fi.model.dao.impl.PlanDaoImpl;
import ar.edu.unju.fi.model.dao.impl.VehiculoDaoImpl;

public class TestPlanDao {
	
	private Plan3070 plan3070;
	private PlanRegular planRegular;
	private Cliente cliente1;
	private Cliente cliente2;
	private Vehiculo vehiculo1;
	private Vehiculo vehiculo2;
	private PlanDaoImpl planDao;
	private VehiculoDaoImpl vehiculoDao;
	private ClienteDaoImpl clienteDao;
		
	@Before
	public void setUp() throws Exception {
		
		cliente1 = new Cliente("Andre Belen", "Gomez", 35825584);
		cliente2 = new Cliente("Nestor Fabian","Arjona",33654187);
		vehiculo1 = new Vehiculo(350000, "Peugeot", "308 Allure");
		vehiculo2 = new Vehiculo(850000, "Toyota", "Hilux");
		plan3070 = new Plan3070(cliente1, vehiculo1, 60);
		planRegular = new PlanRegular(cliente2, vehiculo2, 80);
		
		vehiculoDao = new VehiculoDaoImpl();
		clienteDao = new ClienteDaoImpl();
		planDao = new PlanDaoImpl();
		
		vehiculoDao.guardarVehiculo(vehiculo1);
		vehiculoDao.guardarVehiculo(vehiculo2);
		clienteDao.guardarCliente(cliente1);
		clienteDao.guardarCliente(cliente2);
		
	}

	@After
	public void tearDown() throws Exception {
		
		planDao.eliminarPlan(plan3070);
		vehiculoDao.eliminarVehiculo(vehiculo1);
		vehiculoDao.eliminarVehiculo(vehiculo2);
		clienteDao.eliminarCliente(cliente1);
		clienteDao.eliminarCliente(cliente2);
	}

	@Test
	public void guardarPlanTest() {
		
		long id_plan = planDao.guardarPlan(plan3070);
		
		assertNotNull(id_plan);
		
		int ultimo = planDao.listarPlan().size();
		
		assertEquals(plan3070, planDao.listar().get(ultimo-1));
	}
	
	@Test
	public void eliminarPlanTest(){
		
		long id_plan = planDao.guardarPlan(planRegular);
		
		assertEquals(planRegular, planDao.buscarPlan(id_plan));
		
		planDao.eliminarPlan(planRegular);
		
		assertNull(planDao.buscar(id_plan));
	}
	

}
