package ar.edu.unju.fi.agencia.principal;
import ar.edu.unju.fi.agencia.Agencia;
import ar.edu.unju.fi.agencia.Cliente;
import ar.edu.unju.fi.agencia.Plan;
import ar.edu.unju.fi.agencia.Plan3070;
import ar.edu.unju.fi.agencia.PlanRegular;
import ar.edu.unju.fi.agencia.Vehiculo;
import java.util.ArrayList;
import java.util.List;

public class DataEntry {

	public DataEntry() {
				
		}
	
	public static List<Plan> cargarDatos(){
		
		List<Plan> Planes = new ArrayList<Plan>();
		
		Cliente Cliente1 = new Cliente("Abel Guillermo", "Diaz");
		Cliente Cliente2 = new Cliente("Fabian Nestor", "Arjona");
		Cliente Cliente3 = new Cliente("Marta Elena", "Luna");
		Cliente Cliente4 = new Cliente("Gustavo Abel", "Diaz");	
		
		Vehiculo Vehiculo1 = new Vehiculo(350000, "Peugeot");
		Vehiculo Vehiculo2 = new Vehiculo(320000, "Ford");
		Vehiculo Vehiculo3 = new Vehiculo(450000, "Toyota");
		Vehiculo Vehiculo4 = new Vehiculo(510000, "Nissan");
		
		Plan3070 Plan1 = new Plan3070(Cliente1 , Vehiculo1, 60);
		Plan3070 Plan2 = new Plan3070(Cliente2, Vehiculo2, 80);
		PlanRegular Plan3 = new PlanRegular(Cliente3, Vehiculo3, 80);
		PlanRegular Plan4 = new PlanRegular(Cliente4, Vehiculo4, 60);
		Planes.add(Plan1);
		Planes.add(Plan2);
		Planes.add(Plan3);
		Planes.add(Plan4);
		
		return Planes;
	}
	
	public static void realizarOperaciones (Agencia a){
		
		
		
		System.out.println("Deuda del Cliente :" + a.getPlanes().get(0).getCliente().getNombre().toString());
		System.out.println(a.getPlanes().get(0).dineroPorCobrar());
		
		System.out.println("Cantidad de Cuotas sin Pagar :");
		System.out.println(a.getPlanes().get(0).getCantidadDeCuotasImpagas());
		
		System.out.println("Cantidad de Cuotas  Pagadas :");
		System.out.println(a.getPlanes().get(0).getCantidadDeCuotasPagadas());

		System.out.println("Realiza el Pago de 5 cuotas");
		
		Cliente c = a.getPlanes().get(0).getCliente();
		
		a.pagarCuotaCliente(c);
		a.pagarCuotaCliente(c);
		a.pagarCuotaCliente(c);
		a.pagarCuotaCliente(c);
		a.pagarCuotaCliente(c);

		System.out.println("Deuda del Cliente :" + a.getPlanes().get(0).getCliente().getNombre().toString());
		System.out.println(a.getPlanes().get(0).dineroPorCobrar());
		
		System.out.println("Tipo de Plan : " + a.getPlanes().get(0).getNombrePlan());
		
		System.out.println("Cantidad de Cuotas sin Pagar :");
		System.out.println(a.getPlanes().get(0).getCantidadDeCuotasImpagas());
		
		System.out.println("Numero de Cuotas Pagadas :");
		System.out.println(a.getPlanes().get(0).getCantidadDeCuotasPagadas());
		
		for (int i = 0; i< a.getPlanes().get(0).getCantidadDeCuotasPagadas(); i++){
			System.out.println("Cuota Nº :"+ (i+1));
			System.out.println("Fecha de Pago :"+ a.getPlanes().get(0).getCuotas().get(i).getFechaPagada());
			System.out.println("Fecha de Vencimiento :"+ a.getPlanes().get(0).getCuotas().get(i).getFechaVencimiento());
		}
		
		
	}

}
