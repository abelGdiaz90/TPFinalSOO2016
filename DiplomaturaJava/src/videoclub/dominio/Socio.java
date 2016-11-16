package videoclub.dominio;

import java.util.concurrent.atomic.AtomicInteger;

public class Socio {

	private String nombre;
	private String apellido;
	private long nroSocio; 
	private static AtomicInteger id = new AtomicInteger(0); 
	
	public Socio() {
	}
	
	public Socio(String n, String a){
		this.nombre = n;
		this.apellido = a;
		this.nroSocio = nextId();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public  long getNroSocio() {
		return nroSocio;
	}

	private static long nextId() {
        return id.incrementAndGet();     
    }

}
