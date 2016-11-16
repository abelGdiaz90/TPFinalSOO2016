package videoclub.dominio;

public class Pelicula {
	
	private String nombre ;
	private Double precio;
	private int stock;
	
	public Pelicula() {		
	}
	
	public Pelicula(String n, int  s){
		this.nombre = n;
		this.stock = s;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	

}
