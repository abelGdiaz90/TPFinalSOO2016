package ar.edu.unju.fi.model.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import ar.edu.unju.fi.model.dao.UsuarioDao;
import ar.edu.unju.fi.model.domain.Usuario;
import ar.edu.unju.fi.model.hibernate.util.BaseHibernate;

/**
 * 
 * DaoImpl para el usuario
 * @author Jose Zapna
 *
 */
public class UsuarioDaoImp extends BaseHibernate implements UsuarioDao {

	public List<Usuario> find(){
		Criteria criteria = getSession().createCriteria(Usuario.class);
		
		return criteria.list();
	}

}
