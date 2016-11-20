package ar.edu.unju.fi.model.dao;

import java.util.List;

import ar.edu.unju.fi.model.domain.Usuario;

public interface UsuarioDao {

	List<Usuario> find();

}