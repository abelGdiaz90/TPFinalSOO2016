package BinarioTexto;

import java.util.List;

// Clase de utilidad para la comprension del Archivo Binario

public class Utilidad {
	
	// Metodo para generar el Equivalente del ID de un registro
	
	public void generarIdEquivalente(int nroDeRegistro){
	    String s = String.format("%8s", Integer.toBinaryString(nroDeRegistro& 0xFF)).replace(' ', '0');
        long numero = new Long(Long.parseLong(s,2));
        byte bait = (byte)Short.parseShort(s, 2);
        System.out.println(numero+"  =  "+ bait);
	}

	public void mostrarArray(List<Byte> ficheroByte){
		for (int i = 0; i < ficheroByte.size(); i++) {
			System.out.println(ficheroByte.get(i));
		}
	}
	
	public void contadorDeRegistro(List<Byte> ficheroArray){
		
		int count11 = 0;
		int count12 = 0;
		int count13 = 0;
		int count15 = 0;
		int count16 = 0;
		int count17 = 0;
		int count18 = 0;
		int count19 = 0;
		int count21 = 0;
		int count22 = 0;
		int count31 = 0;
		int count32 = 0;
		int count33 = 0;
		int count34 = 0;
		int count38 = 0;
		int count51 = 0;
		int count70 = 0;
		int count71 = 0;
		int count75 = 0;
		int count76 = 0;
		int count84 = 0;
		int count86 = 0;
		int count89= 0;
		int count991= 0;
		int count992= 0;
		int count1004 = 0;
		int count1005 = 0;
		int count115 =0;
		int count152 =0;
		int count161 =0;
		int count175 =0;
		int count199 =0;
		int count200 =0;
		int count203 =0;
		int count206 =0;
		int count211 =0;
		int count213 =0;
		int count220 =0;
		int count241 =0;
		int count246 =0;
		
		for (int i = 0; i < ficheroArray.size(); i++) {
			
			if ((ficheroArray.get(i) == 11) && (ficheroArray.get(i + 1) == 1)){
			++count11;	
			}
			if ((ficheroArray.get(i) == 12) && (ficheroArray.get(i + 1) == 4)){
				++count12;	
				}
			if ((ficheroArray.get(i) == 13) && (ficheroArray.get(i + 1) == 3)){
				++count13;	
				}
			if ((ficheroArray.get(i) == 15) && (ficheroArray.get(i + 1) == 1)){
				++count15;	
				}
			if ((ficheroArray.get(i) == 16) && (ficheroArray.get(i + 1) == 1)){
				++count16;	
				}
			if ((ficheroArray.get(i) == 17) && (ficheroArray.get(i + 1) == 1)){
				++count17;	
				}
			if ((ficheroArray.get(i) == 18) && (ficheroArray.get(i + 1) == 1)){
				++count18;	
				}
			if ((ficheroArray.get(i) == 19) && (ficheroArray.get(i + 1) == 1)){
				++count19;	
				}
			if ((ficheroArray.get(i) == 21) && (ficheroArray.get(i + 1) == 1)){
				++count21;	
				}
			if ((ficheroArray.get(i) == 22) && (ficheroArray.get(i + 1) == 6)){
				++count22;	
				}
			if ((ficheroArray.get(i) == 31) && (ficheroArray.get(i + 1) == 2)){
				++count31;	
				}
			if ((ficheroArray.get(i) == 32) && (ficheroArray.get(i + 1) == 2)){
				++count32;	
				}
			if ((ficheroArray.get(i) == 33) && (ficheroArray.get(i + 1) == 2)){
				++count33;	
				}
			if ((ficheroArray.get(i) == 34) && (ficheroArray.get(i + 1) == 2)){
				++count34;	
				}
			if ((ficheroArray.get(i) == 38) && (ficheroArray.get(i + 1) == 1)){
				++count38;	
				}
			if ((ficheroArray.get(i) == 51) && (ficheroArray.get(i + 1) == 2)){
				++count51;	
				}
			if ((ficheroArray.get(i) == 70) && (ficheroArray.get(i + 1) == 1)){
				++count70;	
				}
			if ((ficheroArray.get(i) == 71) && (ficheroArray.get(i + 1) == 6)){
				++count71;	
				}
			if ((ficheroArray.get(i) == 75) && (ficheroArray.get(i + 1) == 1)){
				++count75;	
				}
			if ((ficheroArray.get(i) == 76) && (ficheroArray.get(i + 1) == 1)){
				++count76;	
				}
			if ((ficheroArray.get(i) == 84) && (ficheroArray.get(i + 1) == 2)){
				++count84;	
				}
			if ((ficheroArray.get(i) == 86) && (ficheroArray.get(i + 1) == 2)){
				++count86;	
				}
			if ((ficheroArray.get(i) == 99) && (ficheroArray.get(i + 1) == 1)){
				++count991;	
				}
			if ((ficheroArray.get(i) == 99) && (ficheroArray.get(i + 1) == 2)){
				++count992;	
				}
			if ((ficheroArray.get(i) == 100) && (ficheroArray.get(i + 1) == 4)){
				++count1004;	
				}
			if ((ficheroArray.get(i) == 100) && (ficheroArray.get(i + 1) == 5)){
				++count1005;	
				}
			if ((ficheroArray.get(i) == 115) && (ficheroArray.get(i + 1) == 1)){
				++count115;	
				}
			if ((ficheroArray.get(i) == -104) && (ficheroArray.get(i + 1) == 4)){
				++count152;	
				}
			if ((ficheroArray.get(i) == -95) && (ficheroArray.get(i + 1) == 3)){
				++count161;	
				}
			if ((ficheroArray.get(i) == -81) && (ficheroArray.get(i + 1) == 3)){
				++count175;	
				}
			if ((ficheroArray.get(i) == -57) && (ficheroArray.get(i + 1) == 2)){
				++count199;	
				}
			if ((ficheroArray.get(i) == -56) && (ficheroArray.get(i + 1) == 2)){
				++count200;	
				}
			if ((ficheroArray.get(i) == -53) && (ficheroArray.get(i + 1) == 2)){
				++count203;	
				}
			if ((ficheroArray.get(i) == -50) && (ficheroArray.get(i + 1) == 2)){
				++count206;	
				}
			if ((ficheroArray.get(i) == -45) && (ficheroArray.get(i + 1) == 3)){
				++count211;	
				}
			if ((ficheroArray.get(i) == -43) && (ficheroArray.get(i + 1) == 1)){
				++count213;	
				}
			if ((ficheroArray.get(i) == -36) && (ficheroArray.get(i + 1) == 3)){
				++count220;	
				}
			if ((ficheroArray.get(i) == -15) && (ficheroArray.get(i + 1) == 3)){
				++count241;	
				}
			if ((ficheroArray.get(i) == -10) && (ficheroArray.get(i + 1) == 3)){
				++count246;	
				}
	}
		System.out.println("Registro Nº  Cantidad de Registros");
		System.out.println("11                "+count11);
		System.out.println("12                "+count12);
		System.out.println("13                "+count13);
		System.out.println("15                "+count15);
		System.out.println("16               "+count16);
		System.out.println("17                "+count17);
		System.out.println("18                "+count18);
		System.out.println("19                "+count19);
		System.out.println("21                "+count21);
		System.out.println("22                "+count22);
		System.out.println("31                "+count31);
		System.out.println("32                "+count32);
		System.out.println("33                "+count33);
		System.out.println("34                "+count34);
		System.out.println("38                "+count38);
		System.out.println("51                "+count51);
		System.out.println("70                "+count70);
		System.out.println("71                "+count71);
		System.out.println("75                "+count75);
		System.out.println("76                "+count76);
		System.out.println("84                "+count84);
		System.out.println("86                "+count86);
		System.out.println("89                "+count89);
		System.out.println("99_1                "+count991);
		System.out.println("99_2                "+count992);
		System.out.println("100_4            "+count1004);
		System.out.println("100_5                "+count1005);
		System.out.println("115                "+count115);
		System.out.println("152              "+count152);
		System.out.println("161              "+count161);
		System.out.println("175                "+count175);
		System.out.println("199                "+count199);
		System.out.println("200                "+count200);
		System.out.println("203                "+count203);
		System.out.println("206                "+count206);
		System.out.println("211                "+count211);
		System.out.println("212                "+count213);
		System.out.println("220                "+count220);
		System.out.println("241                "+count241);
		System.out.println("246                "+count246);
	
	}
}
