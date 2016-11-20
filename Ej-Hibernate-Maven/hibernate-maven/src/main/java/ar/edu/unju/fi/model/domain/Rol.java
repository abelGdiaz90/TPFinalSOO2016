package ar.edu.unju.fi.model.domain;

import java.util.HashSet;
import java.util.Set;

public class Rol {
	private Integer rolId;
	private String descripcion;
	private Set<Usuario>usuarios = new HashSet<Usuario>(0);
	public Rol(){}
	
	public Rol(Integer rolId, String descripcion) {
		super();
		this.rolId = rolId;
		this.descripcion = descripcion;
	}
	public Integer getRolId() {
		return rolId;
	}
	public void setRolId(Integer rolId) {
		this.rolId = rolId;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Set<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
}
