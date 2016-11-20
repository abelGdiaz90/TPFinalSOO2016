package ar.edu.unju.fi;

import ar.edu.unju.fi.model.dao.UsuarioDao;
import ar.edu.unju.fi.model.dao.impl.UsuarioDaoImp;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
		UsuarioDao dao = new UsuarioDaoImp();
		System.out.println("Usuarios: " + dao.find().size());        
    }
}
