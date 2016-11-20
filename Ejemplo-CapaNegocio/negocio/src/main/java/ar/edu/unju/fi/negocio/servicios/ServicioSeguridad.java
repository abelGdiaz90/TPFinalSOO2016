package ar.edu.unju.fi.negocio.servicios;

import java.util.List;

import ar.edu.unju.fi.model.domain.Usuario;

public interface ServicioSeguridad {
	
	
	List<Usuario> listaUsuarios() throws Exception;

}
