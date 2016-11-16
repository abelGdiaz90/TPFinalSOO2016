package ar.edu.unju.fi.modelo.dao;

import java.util.List;

import ar.edu.fi.unju.model.domian.Vehiculo;

public interface VehiculoDao extends GenericDao<Vehiculo, Long>  {
	
	public  List<Vehiculo> listarVehiculos();
	public long guardarVehiculo(Vehiculo v);
	public void eliminarVehiculo(Vehiculo v);
	public void actualizarVehiculo(Vehiculo v);
	public Vehiculo buscarVehiculo(long id );
	
 }
