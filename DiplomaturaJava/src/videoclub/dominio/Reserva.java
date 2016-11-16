package videoclub.dominio;

import java.util.Date;

public class Reserva{
		
	private Pelicula pelicula;
	private Socio socio;
	private int cantidadDeDias;
	private Date fechaInicio;
	private Date fechaVencimiento;
	private double precioPordia;
	
	public Reserva() {
	}
	
	public Reserva(Pelicula p, Socio c, int d){
		if (p.getStock() > 0){
			p.setStock(p.getStock()-1);
			pelicula = p;
			cantidadDeDias = d;
			
		}
	}

}
