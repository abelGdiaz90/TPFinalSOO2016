package ar.edu.unju.fi.negocio.servicios.hibernate;

import ar.edu.fi.unju.model.domian.Cliente;

public interface ServicioClientes {

	public Cliente clienteQueMenosDebe();
	public double deudaCliente(Cliente cliente);
}
