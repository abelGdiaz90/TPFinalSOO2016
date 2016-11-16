package ar.edu.unju.fi.modelo.dao;

import java.util.List;

import ar.edu.fi.unju.model.domian.Usuario;

public interface UsuarioDao extends  GenericDao<Usuario, Integer>{

	public  List<Usuario> listarUsuarios();
	public int guardarUsuario(Usuario c);
	public void eliminarUsuario(Usuario c);
	public void actualizarUsuario(Usuario c);
	public Usuario buscarUsuario(int id );
	public boolean usuarioDisponible(String usuario);
	public Usuario validarUsuario(String usuario, String clave);
}