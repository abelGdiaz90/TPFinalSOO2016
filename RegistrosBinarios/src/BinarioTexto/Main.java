package BinarioTexto;

public class Main {
	
    public static void main(String[] args) {
    	
//    	VentanaGUI ventana=new VentanaGUI();
//    	ventana.setBounds(0,0,350,200);
//    	ventana.setVisible(true);
    	
   	        String direccion = "TLL_0318_425_00077_0000004193_00023_20161005_063604_02.41";    	     
   	        Fichero fichero = new Fichero();   	        
   	        Utilidad util = new Utilidad();
            util.contadorDeRegistro(fichero.generarArray(direccion));
  	        fichero.generarFicheroTexto(direccion);
        
    }
}
    
