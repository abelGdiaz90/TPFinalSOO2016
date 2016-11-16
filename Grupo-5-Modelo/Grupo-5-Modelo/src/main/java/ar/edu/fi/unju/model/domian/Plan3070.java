package ar.edu.fi.unju.model.domian;


import java.util.Calendar;
import java.util.GregorianCalendar;



public class Plan3070 extends Plan {

	private double montoEntrega ;
	
	public Plan3070(){
		
	}
	public Plan3070(Cliente c, Vehiculo v,int n){
		super(c,v,n);
		generarCuotas(n,v);
	}
	
	public String getNombrePlan(){
		return "Plan 30/70";
		
	}

	protected void generarCuotas(int n,Vehiculo v){
		
		Calendar c1 = GregorianCalendar.getInstance();
		double contado = v.getPrecio()*30/100;
		this.montoEntrega = contado;
		double monto = (v.getPrecio()-contado)/n;
	    for(int i=0 ; i<n; i++){
	    	c1.add(Calendar.MONTH, 1);
	    	Cuota c = new Cuota(c1.getTime(),monto);
	    	this.cuotas.add(c);
		}
	}
	

	public double getMontoEntrega() {
		return montoEntrega;
	}


	public double dineroPorCobrar(){
		double monto = 0;
		for(int i=0; i< getCuotasImpagas().size();i++){
			monto = monto + getCuotasImpagas().get(i).getMonto();
		}
		return monto + this.montoEntrega;
	}

	

}
