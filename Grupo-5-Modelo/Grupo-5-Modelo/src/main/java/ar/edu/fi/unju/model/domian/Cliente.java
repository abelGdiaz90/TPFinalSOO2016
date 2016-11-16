package ar.edu.fi.unju.model.domian;

public class Cliente {
	 
	private String nombre;
	private String apellido;
	private long dni;
	private long idCliente;
	
	public Cliente(){
		
	}
	public Cliente(String n, String a, long d) {
		this.nombre = n;
		this.apellido = a;		
		this.dni = d; 
	}
	
	public long getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String n) {
		nombre = n;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String a) {
		apellido = a;
	}

}