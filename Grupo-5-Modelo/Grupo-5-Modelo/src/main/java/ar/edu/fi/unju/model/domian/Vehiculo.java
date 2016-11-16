package ar.edu.fi.unju.model.domian;

public class Vehiculo {
	private double precio;
	private String marca;
	private String modelo;
	private long idVehiculo;

	public Vehiculo(){
		
	}
	
	public long getIdVehiculo() {
		return idVehiculo;
	}

	@SuppressWarnings("unused")
	private void setIdVehiculo(long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}
	
	public Vehiculo(double c, String m, String md) {
		precio = c;
		marca = m;
		modelo = md;
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
