package ar.edu.unju.fi.agencia;

public class Cliente {
	 
	private String nombre;
	private String apellido;
	
	public Cliente(){
		
	}
	public Cliente(String n, String a) {
		this.nombre = n;
		this.apellido = a;		
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