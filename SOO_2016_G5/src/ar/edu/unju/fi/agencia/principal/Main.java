package ar.edu.unju.fi.agencia.principal;

import ar.edu.unju.fi.agencia.Agencia;

public class Main {

	public static void main(String[] args) {
		
		Agencia Agencia = new Agencia("Norte Automotores SRL");
		Agencia.setPlanes(DataEntry.cargarDatos());
		DataEntry.realizarOperaciones(Agencia);
		
		System.out.println("Cliente que Menos Debe : "+ Agencia.clienteQueMenosDebe().getNombre().toString());
		System.out.println("Dinero que Falta Cobrar por la Agencia : "+ Agencia.dineroPorCobrar());	
		
		
	}

}
