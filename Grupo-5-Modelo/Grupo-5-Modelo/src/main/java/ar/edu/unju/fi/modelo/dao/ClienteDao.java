package ar.edu.unju.fi.modelo.dao;

import java.util.List;

import ar.edu.fi.unju.model.domian.Cliente;

public interface ClienteDao extends GenericDao<Cliente, Long> {
	
	public  List<Cliente> listarClientes();
	public long guardarCliente(Cliente c);
	public void eliminarCliente(Cliente c);
	public void actualizarCliente(Cliente c);
	public Cliente buscarCliente(long id );
	
}
