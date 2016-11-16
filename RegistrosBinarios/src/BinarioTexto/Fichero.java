package BinarioTexto;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class Fichero {
	
	public Fichero(){}
	
	// Funcion que convierte el fichero binario en un Array de Bytes
	public  List<Byte> generarArray(String direccion){

    	FileInputStream fis = null;
        DataInputStream entrada = null;
        byte b;
        List<Byte> arrays = new ArrayList<Byte>();
        
        try {
            fis = new FileInputStream(direccion+".bin");
            entrada = new DataInputStream(fis);
            while (true) {   
                b = entrada.readByte();
                arrays.add(b);
            }
        } catch (FileNotFoundException e) {
        	JOptionPane.showMessageDialog(null, "Fichero No encontrado");
        	
        } catch (EOFException e) {
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (entrada != null) {
                    entrada.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        
        return arrays;
    
    }
		
	@SuppressWarnings("deprecation")
	public Date generarFecha( List<Byte> bytesFecha){
		
	    long fechaBase = new Date(102,11,31,0,0).getTime();
		String fechaBinaria = "";
		for(int i = 0; i < bytesFecha.size(); ++i){
			fechaBinaria += String.format("%8s", Integer.toBinaryString(bytesFecha.get(i) & 0xFF)).replace(' ', '0');
		}
	    long numeroDeDias = new Long(Long.parseLong(fechaBinaria.substring(0,15),2))*24*60*60*1000;
        long numeroDeSegundos = new Long(Long.parseLong(fechaBinaria.substring(15, 32),2))*1000;
        
        return new Date(fechaBase+numeroDeDias+numeroDeSegundos);
	}

	public long convertir(List<Byte> bytes){
		String binario = "";
		for(int i = 0; i < bytes.size(); ++i){
			binario += String.format("%8s", Integer.toBinaryString(bytes.get(i) & 0xFF)).replace(' ', '0');
		}
		return new Long(Long.parseLong(binario,2));
	}
	
	public void generarFicheroTexto( String direccion){

		boolean header12 = true;
		boolean header99 = true;
		int count12 = 0;
		int count34 = 0;
		
		
		List<Byte> ficheroByte = generarArray(direccion);
		
		if(!ficheroByte.isEmpty()){
		  try
			{
			File archivo=new File(direccion+".txt");
			
			if (!archivo.exists()) {

			FileWriter escribir=new FileWriter(archivo,true);
			
			for (int i=0; i<ficheroByte.size(); ++i){
			
				// Escritura de un Resgitro 34, Vinculo/Desvinculo de Chofer
				if ((ficheroByte.get(i) == 34) && (ficheroByte.get(i + 1) == 2)){
					++count34;
					escribir.write("Numero\tRegistro Tipo\tVersion\tDTSN\tFECHA\tCard Issuer ID\tCardType\tCard Desing Id\tCard Serial Number\tCard Check Digit\tCard Internal Serial Number\tCard Version\tDefinition Type\tService ID\r\n ");
					escribir.write(Integer.toString(count34)+"\t");
					escribir.write(Long.toString( convertir(ficheroByte.subList(i, i+1)))+"\t");
					escribir.write(Long.toString(convertir(ficheroByte.subList(i+1, i+2)))+"\t");
					escribir.write(Long.toString( convertir(ficheroByte.subList(i+2, i+6)))+"\t");
					escribir.write(generarFecha(ficheroByte.subList(i+6, i+10)).toString()+"\t");
					escribir.write(Long.toString( convertir(ficheroByte.subList(i+10, i+12)))+"\t");
					escribir.write(Long.toString( convertir(ficheroByte.subList(i+12, i+13)))+"\t");
					escribir.write(Long.toString(convertir(ficheroByte.subList(i+13, i+14)))+"\t");
					escribir.write(Long.toString(convertir(ficheroByte.subList(i+14, i+18)))+"\t");
					escribir.write(Long.toString(convertir(ficheroByte.subList(i+18, i+19)))+"\t");
					escribir.write(Long.toString( convertir(ficheroByte.subList(i+19, i+26)))+"\t");
					escribir.write(Long.toString(convertir(ficheroByte.subList(i+26, i+27)))+"\t");
					escribir.write(Long.toString( convertir(ficheroByte.subList(i+27, i+28)))+"\t");
					escribir.write(Long.toString( convertir(ficheroByte.subList(i+28, i+32)))+" \r\n ");
					i = i +31;
				}
				
				// Escritura de un Registro 99 version 1, Registro de Comunicacion
				if ((ficheroByte.get(i) == 99) && (ficheroByte.get(i + 1) == 1)){
					
					if (header99){
						escribir.write("Registro Tipo\tVersion\tFecha\tCSN\tDPT-ID\tAP-MAC\r\n ");
						header99 = false;
					}					
		
					escribir.write(Long.toString( convertir(ficheroByte.subList(i, i+1)))+"\t");
					escribir.write(Long.toString(convertir(ficheroByte.subList(i+1, i+2)))+"\t");
					escribir.write(generarFecha(ficheroByte.subList(i+2, i+6)).toString()+"\t");
					escribir.write(Long.toString( convertir(ficheroByte.subList(i+6, i+8)))+"\t");
					escribir.write(Long.toString( convertir(ficheroByte.subList(i+8, i+10)))+"\t");
					escribir.write(Long.toString(convertir(ficheroByte.subList(i+10, i+30)))+" \r\n ");
					i = i +29;
				}
				
				//  Escritura de un Registro 12 version 1, Uso de Transporte
					if ((ficheroByte.get(i) == 12) && (ficheroByte.get(i + 1) == 4)){
						++count12;
						if (header12){
							escribir.write("Numero\tRegistro Tipo\tVersion\tDTSN\tFECHA\tCard Issuer ID\tCardType\tCard Desing Id\tCard Serial Number\tCard Check Digit\tCard Internal Serial Number\tSGC\tCard Version\tPurse Version\tPurse Issuer\tPurse Id\tPurse Type\tPurse Index\tPurse Date\tPurse Balance\tPTC\tLTC\tCard Transit Version\tApplication Version\tApplication ID\tApplication Issure ID\tAPP_TSN\tGet-On-Status\tChech-IN\tChech-OUT\tFare Rule\tExtend Fare Rule\tOperation Code\tValidation Type\tPartialFare Sequence\tFare Value \tDiscount\tEffective Amount\tProvision Value\tSAM_Siganature\tFiller\n ");
							header12 = false;
						}					
						escribir.write(Integer.toString(count12)+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i, i+1)))+"\t");
						escribir.write(Long.toString(convertir(ficheroByte.subList(i+1, i+2)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+2, i+6)))+"\t");
						escribir.write(generarFecha(ficheroByte.subList(i+6, i+10)).toString()+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+10, i+12)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+12, i+13)))+"\t");
						escribir.write(Long.toString(convertir(ficheroByte.subList(i+13, i+14)))+"\t");
						escribir.write(Long.toString(convertir(ficheroByte.subList(i+14, i+18)))+"\t");
						escribir.write(Long.toString(convertir(ficheroByte.subList(i+18, i+19)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+19, i+26)))+"\t");					
						escribir.write(Long.toString(convertir(ficheroByte.subList(i+26, i+30)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+30, i+31)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+31, i+32)))+"\t");			
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+32, i+34)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+34, i+36)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+36, i+37)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+37, i+38)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+38, i+42)))+"\t");			
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+42, i+46)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+46, i+48)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+48, i+50)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+50, i+51)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+51, i+52)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+52, i+54)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+54, i+56)))+"\t");				
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+56, i+58)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+58, i+59)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+59 ,i+60)))+"\t");					
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+60, i+61)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+61, i+62)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+62, i+63)))+"\t");
					    escribir.write(Long.toString( convertir(ficheroByte.subList(i+63, i+64)))+"\t");
					    escribir.write(Long.toString( convertir(ficheroByte.subList(i+64, i+65)))+"\t");
					    escribir.write(Long.toString( convertir(ficheroByte.subList(i+65, i+66)))+"\t");
					    escribir.write(Long.toString( convertir(ficheroByte.subList(i+66, i+70)))+"\t");
					    escribir.write(Long.toString( convertir(ficheroByte.subList(i+70, i+74)))+"\t");
					    escribir.write(Long.toString( convertir(ficheroByte.subList(i+74, i+78)))+"\t");
					    escribir.write(Long.toString( convertir(ficheroByte.subList(i+78, i+82)))+"\t");
					    //FIXME se desconoce el formato de la palabra de 38 bits desde la posicion 82 a 120
					    escribir.write(Long.toString( convertir(ficheroByte.subList(i+82, i+83)))+"\t");
						escribir.write(Long.toString( convertir(ficheroByte.subList(i+120, i+124)))+" \r\n ");
						i = i +123;
					}
			}
	
			escribir.close();
			      JOptionPane.showMessageDialog(null, "Archivo Generado");
			}
			else{
		
				  JOptionPane.showMessageDialog(null, "El Archivo ya fue Generado");
			}
			}
			catch(Exception e)
			{
				 JOptionPane.showMessageDialog(null, "ERROR! el archivo no se pude crear");
			}
	}
		
	}
	
	
}






