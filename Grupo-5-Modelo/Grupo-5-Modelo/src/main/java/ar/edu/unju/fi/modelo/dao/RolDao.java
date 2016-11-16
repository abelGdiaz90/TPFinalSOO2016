package ar.edu.unju.fi.modelo.dao;

import java.util.List;

import ar.edu.fi.unju.model.domian.Rol;

public interface RolDao extends GenericDao<Rol, Integer>{
	
	public  List<Rol> listarRoles();
	public int guardarRol(Rol r);
	public void eliminarRol(Rol r);
	public void actualizarRol(Rol r);
	public Rol buscarRol(int id );

}
