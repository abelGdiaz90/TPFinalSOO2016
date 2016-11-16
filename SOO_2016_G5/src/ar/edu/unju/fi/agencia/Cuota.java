package ar.edu.unju.fi.agencia;


import java.util.Date;

public class Cuota {
	
	private Date fechaVencimiento;
	private Date fechaPagada;
	private Double monto;
	
	public Cuota(){
	}

	public Cuota(Date f, Double m) {
		fechaVencimiento = f;
		monto = m;
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
