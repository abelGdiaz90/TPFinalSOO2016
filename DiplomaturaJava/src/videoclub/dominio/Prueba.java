package videoclub.dominio;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Prueba {

	public static void main(String[] args) {
		
		Dvd p1 = new Dvd("12 Monos", 2);
		Vhs v1 = new Vhs("El Padrino 1", 3);
		
		Socio s1 = new Socio("Abel" , "Diaz");
		
		Alquiler alquiler1 = new Alquiler(p1,s1,4);
		Alquiler alquiler2 = new Alquiler(p1,s1,6);
		Alquiler alquiler3 = new Alquiler(p1,s1,8);
		System.out.println(alquiler1.getRecargo());
		System.out.println(alquiler2.getRecargo());
		
		
	    
	}

}
