package ar.edu.unju.fi.agencia;

import java.util.ArrayList;
import java.util.List;

public abstract class Plan {
	
	private Vehiculo vehiculo;
	private Cliente cliente;
	
	protected List<Cuota> Cuotas;
	
	public Plan(){
	}
	public Plan(Cliente c, Vehiculo v, int n){
		
		this.Cuotas =new ArrayList<Cuota>();
		this.cliente = c;
		this.vehiculo = v;

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
		return Cuotas;
	}
	
	public void setCuotas(List<Cuota> cuotas) {
		Cuotas = cuotas;
	}
	
	public abstract double dineroPorCobrar();
	public abstract String getNombrePlan();
	protected abstract void generarCuotas(int n, Vehiculo v);
	
	public List<Cuota> getCuotasPagadas(){
		List<Cuota> pagas = new ArrayList<Cuota>();
		for (int i=0; i < this.Cuotas.size(); i++){
			if (Cuotas.get(i).estaPagada()){
				pagas.add(Cuotas.get(i));				
			}
		}
		return pagas;
	} 
	public int getCantidadDeCuotasPagadas(){
		   return  getCuotasPagadas().size();
		}
	
	public List<Cuota> getCuotasImpagas(){
		List<Cuota> impagas = new ArrayList<Cuota>();
		for (int i=0; i < this.Cuotas.size(); i++){
			if (!Cuotas.get(i).estaPagada()){
				impagas.add(Cuotas.get(i));				
			}
		}
		return impagas;
	} 
	public int getCantidadDeCuotasImpagas(){
		   return getCuotasImpagas().size();
		}
	
}
