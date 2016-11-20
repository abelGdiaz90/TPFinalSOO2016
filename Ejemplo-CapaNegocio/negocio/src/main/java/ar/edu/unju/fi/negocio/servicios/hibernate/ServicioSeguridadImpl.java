package ar.edu.unju.fi.negocio.servicios.hibernate;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unju.fi.model.domain.Usuario;
import ar.edu.unju.fi.negocio.servicios.ServicioSeguridad;

@Named
public class ServicioSeguridadImpl implements ServicioSeguridad {
	private static Logger logger = Logger.getLogger(ServicioSeguridadImpl.class);
	
	@Inject
	private SessionFactory sessionFactory;	
	

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	@Transactional
	public List<Usuario> listaUsuarios() throws Exception {

		//FIXME esto debería invocar al dao de usuarios y solicitar la lista de usuarios
		return sessionFactory.getCurrentSession().createCriteria(Usuario.class).list();
	}

	
}
