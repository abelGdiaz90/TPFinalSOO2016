package ar.edu.unju.fi;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ar.edu.fi.unju.model.domian.Vehiculo;
import ar.edu.unju.fi.model.dao.impl.*;

public class TestVehiculoDaoImp {
	
	private Vehiculo vehiculo1;
	private Vehiculo vehiculo2;
	private Vehiculo vehiculo3;
 	private VehiculoDaoImpl vehiculoDao;
	
	@Before
	public void setUp() throws Exception {
		
		 vehiculo1 = new Vehiculo(350000, "Peugeot", "308 Allure");
		 vehiculo2 = new Vehiculo(850000, "Toyota", "Hilux");
		 vehiculo3 = new Vehiculo(280000, "Renault", "Kangoo");
		 
		 vehiculoDao = new VehiculoDaoImpl();
		 
	}

	@After
	public void tearDown() throws Exception {
		
		vehiculoDao.eliminarVehiculo(vehiculo1);
		vehiculoDao.eliminarVehiculo(vehiculo3);
	}

	@Test
	public void guardarVehiculoTest() {
		
		long id_vehiculo = vehiculoDao.guardarVehiculo(vehiculo1);
		
		assertNotNull (id_vehiculo);
		
		int ultimo = vehiculoDao.listar().size();
		
		assertEquals(vehiculo1, vehiculoDao.listar().get(ultimo -1));
	
	}
	
	@Test
	public void eliminarVehicuoTest(){
		
		long id_vehiculo = vehiculoDao.guardarVehiculo(vehiculo2);
		
		assertEquals(vehiculo2, vehiculoDao.buscarVehiculo(id_vehiculo));
		
		vehiculoDao.eliminar(vehiculo2);
		
		assertNull(vehiculoDao.buscar(id_vehiculo));
	}
	
	@Test
	public void actualizarVehiculoTest(){
		
		long id_vehiculo = vehiculoDao.guardarVehiculo(vehiculo3);
		
		Vehiculo vehiculo = vehiculoDao.buscar(id_vehiculo);
		
		vehiculo.setPrecio(310000);
		
		vehiculo.setModelo("Kangoo Full");
		
		vehiculoDao.actualizar(vehiculo);
		
		assertEquals(vehiculo, vehiculoDao.buscar(id_vehiculo));
	}
}