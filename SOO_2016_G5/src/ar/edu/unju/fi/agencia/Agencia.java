package ar.edu.unju.fi.agencia;

import java.util.ArrayList;
import java.util.List;

public class Agencia {
	
	private String nombre;
	private List<Plan> Planes;
	
	public Agencia(String nombre){
		this.Planes = new ArrayList<Plan>();
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String n) {
		nombre = n;
	}
	public List<Plan> getPlanes() {
		return Planes;
	}
	public void setPlanes(List<Plan> planes) {
		Planes = planes;
	}
	private Plan getPlanCliente(Cliente c) {
	int idx = 0;
		for (int i=0;i<Planes.size();i++){
			if(Planes.get(i).getCliente().equals(c)){
				idx = i;
				break;
			}
		}
	return Planes.get(idx);
	}
	public void CrearPlanRegular(Cliente c, Vehiculo v,int n){
		PlanRegular p = new PlanRegular(c,v,n);
		this.Planes.add(p);
	}
	public void CrearPlan3070(Cliente c, Vehiculo v,int n){
		Plan3070 p = new Plan3070(c,v,n);
		this.Planes.add(p);
	}
	
	public int getCantidadCuotasImpagas(Cliente c){
		return getPlanCliente(c).getCuotasImpagas().size();
	}
	
	public List<Cuota> getCuotaPagadasCliente(Cliente c){
		return getPlanCliente(c).getCuotasPagadas();
	}
	public Cliente clienteQueMenosDebe(){
	   int idx = 0;
	   double min = Planes.get(idx).dineroPorCobrar();
	   for (int j=0; j<Planes.size();j++){
		   		if (Planes.get(j).dineroPorCobrar() < min){
		   			idx = j;
		   		}  
	   }
	   return Planes.get(idx).getCliente(); 
   	   }
   public double dineroPorCobrar(){
	 double total = 0;
	 for(int i=0; i<Planes.size();i++){
		 total = total + Planes.get(i).dineroPorCobrar();
	 }
	 return total;
   }
    public double getDeudaCliente(Cliente c){
	   return getPlanCliente(c).dineroPorCobrar();
   }
   
   public void pagarCuotaCliente(Cliente c) throws IndexOutOfBoundsException{
	   getPlanCliente(c).getCuotasImpagas().get(0).pagarCuota();
	
   }
   
   public String getTipoPlanCliente(Cliente c){
	   return getPlanCliente(c).getNombrePlan();
   }
}