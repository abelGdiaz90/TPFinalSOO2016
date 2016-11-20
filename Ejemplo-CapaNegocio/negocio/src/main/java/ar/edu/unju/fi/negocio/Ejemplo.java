package ar.edu.unju.fi.negocio;

import javax.inject.Named;

/**
 * Clase java ejemplo para probar el contexto de spring
 * @author Jose
 *
 */
@Named
public class Ejemplo {
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	} 
	

}
