package ar.edu.unju.fi;

import ar.edu.fi.unju.model.domian.Rol;
import ar.edu.unju.fi.model.dao.impl.RolDaoImpl;

public class App 
{
    public static void main( String[] args )
    {
		Rol rol1 = new Rol("Administrdor");
		Rol rol2 = new Rol("Empleado");
	    RolDaoImpl rolDao = new RolDaoImpl();
	    rolDao.guardarRol(rol1);
	    rolDao.guardarRol(rol2);
    }
}

