package ar.edu.unju.fi.model.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.fi.unju.model.domian.Rol;
import ar.edu.unju.fi.modelo.dao.RolDao;

@Repository
@Transactional
public class RolDaoImpl extends GenericDaoImpl<Rol, Integer> implements RolDao{

	public List<Rol> listarRoles() {
		return listar();
	}

	public int guardarRol(Rol r) {
		return guardar(r);
	}

	public void eliminarRol(Rol r) {
		eliminar(r);
	}

	public void actualizarRol(Rol r) {
		actualizar(r);
	}

	public Rol buscarRol(int id) {
		return buscar(id);
	}


}
