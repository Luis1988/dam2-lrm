package crackeador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DiccionarioPalabras {
	
	private ArrayList<String> diccionario;
	
	public DiccionarioPalabras(String fichero){
		try {
			diccionario = new ArrayList<String>();
			File archivo = new File (fichero);
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null)
	            diccionario.add(linea);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<String> getPalabras(){
		return diccionario;
	}
	
	/* Prueba para comprobar si funciona correctamente el lector
	 * 
	 * public static void main(String[] args){
	 * 
	 * 		DiccionarioPalabras du = new DiccionarioPalabras("C://RHDSetup.log");
	 * 		System.out.println(du.getPalabras());
	 * 
	 * }*/

}
