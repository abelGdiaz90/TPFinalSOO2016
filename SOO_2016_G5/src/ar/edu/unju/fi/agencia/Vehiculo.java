package ar.edu.unju.fi.agencia;

public class Vehiculo {
	private double precio;
	private String marca;
	
	public Vehiculo(){
		
	}
	
	public Vehiculo(double c, String m) {
		precio = c;
		marca = m;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double c) {
		precio = c;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String m) {
		marca = m;
	}
}
