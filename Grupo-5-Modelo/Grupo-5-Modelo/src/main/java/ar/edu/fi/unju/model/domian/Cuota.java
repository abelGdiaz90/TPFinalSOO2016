package ar.edu.fi.unju.model.domian;


import java.util.Date;


public class Cuota {
	
	private Date fechaVencimiento;
	private Date fechaPagada;
	private Double monto;
	private long idCuota;
	
	public Cuota(){
	}

	public Cuota(Date f, Double m) {
		fechaVencimiento = f;
		monto = m;
	}

	public long getIdCuota() {
		return idCuota;
	}

	public void setIdCuota(long idCuota) {
		this.idCuota = idCuota;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date f) {
		fechaVencimiento = f;
	}

	public Date getFechaPagada() {
		return fechaPagada;
	}

	public void setFechaPagada(Date f) {
		fechaPagada = f;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double m) {
		monto = m;
	}

	public void pagarCuota(){
		setFechaPagada(new Date());
	}
	
	public Boolean estaPagada(){
		return getFechaPagada() != null;
	}

	
	
	
}
