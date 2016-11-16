package ar.edu.fi.unju.model.domian;


public class Rol {
	private Integer rolId;
	private String descripcion;
	public Rol(){}
	
	public Rol(String descripcion) {
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
	
	
	
}
