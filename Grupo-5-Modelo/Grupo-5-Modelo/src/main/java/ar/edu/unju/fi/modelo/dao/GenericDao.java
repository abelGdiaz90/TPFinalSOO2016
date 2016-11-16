package ar.edu.unju.fi.modelo.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao <Entity, PK extends Serializable>{

	// Entity es el subtipo que hace referencia a las clases de Persistencia
	// PK es un subtipo que representa la Claves Primarias
	  List<Entity> listar();
	  PK guardar(Entity t);
	  void actualizar(Entity t);
	  Entity buscar(PK id);
	  void eliminar(Entity t);
}
