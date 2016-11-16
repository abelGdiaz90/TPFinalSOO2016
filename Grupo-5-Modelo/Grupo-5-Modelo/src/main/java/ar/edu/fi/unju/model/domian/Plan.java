package ar.edu.fi.unju.model.domian;

import java.util.ArrayList;
import java.util.List;

public abstract class Plan {
	
	private Vehiculo vehiculo;
	private Cliente cliente;
	private long idPlan;
	protected List<Cuota> cuotas;
	
	public Plan(){
	}
	public Plan(Cliente c, Vehiculo v, int n){
		
		this.cuotas =new ArrayList<Cuota>();
		this.cliente = c;
		this.vehiculo = v;

	}
	public long getIdPlan() {
		return idPlan;
	}
	public void setIdPlan(long idPlan) {
		this.idPlan = idPlan;
	}
	public Vehiculo getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Vehiculo v) {
		vehiculo = v;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente c) {
		cliente = c;
	}

	public List<Cuota> getCuotas() {
		return cuotas;
	}
	
	public void setCuotas(List<Cuota> c) {
		cuotas = c;
	}
	
	public abstract double dineroPorCobrar();
	public abstract String getNombrePlan();
	protected abstract void generarCuotas(int n, Vehiculo v);
	
	public List<Cuota> getCuotasPagadas(){
		List<Cuota> pagas = new ArrayList<Cuota>();
		for (int i=0; i < this.cuotas.size(); i++){
			if (cuotas.get(i).estaPagada()){
				pagas.add(cuotas.get(i));				
			}
		}
		return pagas;
	} 
	public int getCantidadDeCuotasPagadas(){
		   return  getCuotasPagadas().size();
		}
	
	public List<Cuota> getCuotasImpagas(){
		List<Cuota> impagas = new ArrayList<Cuota>();
		for (int i=0; i < this.cuotas.size(); i++){
			if (!cuotas.get(i).estaPagada()){
				impagas.add(cuotas.get(i));				
			}
		}
		return impagas;
	} 
	public int getCantidadDeCuotasImpagas(){
		   return getCuotasImpagas().size();
		}
	
}
