package ar.edu.unju.fi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.fi.unju.model.domian.Cliente;
import ar.edu.unju.fi.model.dao.impl.ClienteDaoImpl;

public class TestClienteDao {
	
	private Cliente cliente1;
	private Cliente cliente2;
	private Cliente cliente3;
	private ClienteDaoImpl clienteDao;

	@Before
	public void setUp() throws Exception {
		
		cliente1 = new Cliente("Andre Belen", "Gomez", 35825584);
		cliente2 = new Cliente("Nestor Fabian","Arjona",33654187);
		cliente3 = new Cliente("Marta Elena","Luna",1634798);
		
		clienteDao = new ClienteDaoImpl();
	}

	@After
	public void tearDown() throws Exception {
		
		clienteDao.eliminarCliente(cliente1);
		clienteDao.eliminarCliente(cliente3);
	}

	@Test
	public void guardarVehiculoTest() {
		
		long id_vehiculo = clienteDao.guardarCliente(cliente1);
		
		assertNotNull (id_vehiculo);
		
		int ultimo = clienteDao.listar().size();
		
		assertEquals(cliente1, clienteDao.listar().get(ultimo -1));
	
	}
	
	@Test
	public void eliminarVehicuoTest(){
		
		long id_cliente = clienteDao.guardarCliente(cliente2);
		
		assertEquals(cliente2, clienteDao.buscarCliente(id_cliente));
		
		clienteDao.eliminarCliente(cliente2);
		
		assertNull(clienteDao.buscar(id_cliente));
	}
	
	@Test
	public void actualizarVehiculoTest(){
		
		long id_cliente = clienteDao.guardarCliente(cliente3);
		
		Cliente cliente = clienteDao.buscar(id_cliente);
		
		cliente.setApellido("Diaz");
		
		cliente.setNombre("Abel Guillerm");
		
		cliente.setDni(34721159);
		
		clienteDao.actualizar(cliente);
		
		assertEquals(cliente, clienteDao.buscarCliente(id_cliente));
	}

}
