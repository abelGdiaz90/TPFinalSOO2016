package videoclub.dominio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Alquiler {
	
	final long  MILISEGUNDOS_DIAS = 24*60*60*1000;
	private Pelicula pelicula;
	private Socio socio;
	private int cantidadDeDias;
	private double precioDia = 10;
	private Date fechaInicio;
	private Date fechaVencimiento;
	
	public Alquiler() {
	}
	
	public Alquiler(Pelicula p, Socio s, int d){
		if (p.getStock() > 0){
			p.setStock(p.getStock()-1);
			Calendar c = GregorianCalendar.getInstance();
			this.fechaInicio = c.getTime();
			c.add(Calendar.DAY_OF_YEAR, d);
			this.fechaVencimiento = c.getTime();
			this.cantidadDeDias = d;
			this.pelicula = p;
			this.socio = s;
		}
		else{
			System.out.println("La pelicula no se encuentra disponible");
		}
	}
	
	public int getCantidadDeDias() {
		return cantidadDeDias;
	}

	public void setCantidadDeDias(int cantidadDeDias) {
		this.cantidadDeDias = cantidadDeDias;
	}

	public double getPrecioDia() {
		return precioDia;
	}

	public void setPrecioDia(double p) {
		this.precioDia = p;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}
	
	private int diferenciaDeDias(){
		Calendar c = GregorianCalendar.getInstance();
		int diasRetraso = (int)((c.getTimeInMillis() - getFechaVencimiento().getTime())/ MILISEGUNDOS_DIAS);
		if ( diasRetraso > 0) {
			return diasRetraso;
		}
		    return 0;
	}
	
	public void devolverAlquier(){
		pelicula.setStock(pelicula.getStock()+1);
	}
	
	public double getRecargo(){
		return precioDia * 1.5 * diferenciaDeDias();
	}

	public double pagoAlquiler(){
		return precioDia * cantidadDeDias; 
	}

}
