package ar.edu.unju.fi;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ar.edu.fi.unju.model.domian.Rol;
import ar.edu.fi.unju.model.domian.Usuario;
import ar.edu.unju.fi.model.dao.impl.RolDaoImpl;
import ar.edu.unju.fi.model.dao.impl.UsuarioDaoImpl;

public class TestUsuarioDao {
	
	private Usuario usuario1;
	private Usuario usuario2;
	private Usuario usuario3;
	private Rol rol1;
	private Rol rol2;
	private RolDaoImpl rolDao;
	private UsuarioDaoImpl usuarioDao;

	@Before
	public void setUp() throws Exception {
		
		rol1 = new Rol("Administrdor");
		rol2 = new Rol("Empleado");
	    rolDao = new RolDaoImpl();
	    rolDao.guardarRol(rol1);
	    rolDao.guardarRol(rol2);
		usuario1 = new Usuario("Matt", "Guerrero Matias", "123", "matias@gmail.com",rol1);
		usuario2 = new Usuario("ADiaz","Diaz Abel","123","abelguillermodiaz@gmail.com",rol1);
		usuario3 = new Usuario("Maxi", "Cari Maximiliano","123","maxicari@gmail.com",rol1);
		usuarioDao = new UsuarioDaoImpl();
	}

	@After
	public void tearDown() throws Exception {

		usuarioDao.eliminarUsuario(usuario1);
		usuarioDao.eliminarUsuario(usuario3);
		rolDao.eliminarRol(rol1);
		rolDao.eliminarRol(rol2);
	}

	@Test
	public void guardarUsuarioTest() {
		
		int id_usuario = usuarioDao.guardarUsuario(usuario1);
		
		assertNotNull (id_usuario);
		
		int ultimo = usuarioDao.listar().size();
		
		assertEquals(usuario1, usuarioDao.listar().get(ultimo -1));
	
	}
	
	@Test
	public void eliminarUsuarioTest(){
		
		int id_usuario = usuarioDao.guardarUsuario(usuario2);
		
		assertEquals(usuario2, usuarioDao.buscarUsuario(id_usuario));
		
		usuarioDao.eliminarUsuario(usuario2);
		
		assertNull(usuarioDao.buscarUsuario(id_usuario));
	}
	
	@Test
	public void actualizarUsuarioTest(){
		
		int id_usuario = usuarioDao.guardarUsuario(usuario3);
		
		Usuario usuario = usuarioDao.buscarUsuario(id_usuario);
		
		usuario.setRol(rol2);
		
		usuario.setClave("otraClave");
		
		usuarioDao.actualizar(usuario);
		
		assertEquals(usuario, usuarioDao.buscarUsuario(id_usuario));
	}


}
