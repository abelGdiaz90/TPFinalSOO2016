package ar.edu.fi.unju.model.domian;

import java.util.Calendar;

import java.util.GregorianCalendar;
import java.util.List;

public class PlanRegular extends Plan {
	
	public PlanRegular(){
		
	}
	
	public PlanRegular(Cliente c, Vehiculo v,int n){
		super(c,v,n);
		generarCuotas(n,v);
	}
	
	public String getNombrePlan(){
		return "Plan Regular";
		
	}
	protected void generarCuotas(int n,Vehiculo v){
		
		Calendar c1 = GregorianCalendar.getInstance();
		double Precio = v.getPrecio();
		double Cuota = Precio/n;
	    for(int i=0 ; i<n; i++){
	     	c1.add(Calendar.MONTH, 1);
	    	Cuota c = new Cuota(c1.getTime(),Cuota);
	    	this.cuotas.add(c);
		}
	}
	public double dineroPorCobrar(){
		double monto = 0;
		List <Cuota> impagas = getCuotasImpagas();
		for(int i=0; i< impagas.size();i++){
			monto = monto + impagas.get(i).getMonto();
		}
		return monto;
	}
}
