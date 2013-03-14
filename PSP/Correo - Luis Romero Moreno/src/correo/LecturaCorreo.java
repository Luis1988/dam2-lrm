package correo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class LecturaCorreo {

	private Socket servidor;
	private String usuario, password;
	private ArrayList<String> correos;
	private BufferedReader lectura;
	private PrintWriter escritura;
	private VistaCorreo vista;

	public LecturaCorreo(VistaCorreo vc, String ip, int puerto, String usuario, String password) {
		vista = vc;
		try {
			servidor = new Socket(ip, puerto);
			this.usuario = usuario;
			this.password = password;
			lectura = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
			escritura = new PrintWriter(servidor.getOutputStream(), true);
			correos = new ArrayList<String>();
			if(autentificaUsuario()){
				setCorreos();
			} else {
				System.out.println("Error");
				lectura.close();
				escritura.close();
				servidor.close();
				// TODO Error de autentificación
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean autentificaUsuario() {
		boolean res = false;
		try {
			String linea = lectura.readLine();
			if(linea.contains("OK"))
				escritura.println("user "+usuario);
			linea = lectura.readLine();
			if(linea.contains("OK"))
				escritura.println("pass "+password);
			linea = lectura.readLine();
			if(linea.contains("ERR"))
				res = false;
			if(linea.contains("OK")){
				res = true;
				escritura.println("list");
			}
		} catch (IOException ioe) {
			// TODO Implementar error
		}
		return res;
	}

	public ArrayList<String> getCorreos() {
		return correos;
	}

	public void setCorreos() {
		try {
			String linea = lectura.readLine();
			ArrayList<String> lista = new ArrayList<String>();
			if(linea.contains("OK")){
				linea = lectura.readLine();
				String numMens = "";
				int i = 0;
				while(!(linea.charAt(i)+"").equals(" ")) {
					numMens+=linea.charAt(i);
					i++;
				}
				lista.add(numMens);
			}
			linea = lectura.readLine();
			for(int i = 1; i <= lista.size(); i++) {
				correos.add(getAsunto(i));
			}
		} catch (IOException ioe) {
			// TODO Implementar error
		}
	}

	public String getAsunto(int index) {
		String res = "";
		try {
			escritura.println("retr "+index);
			String linea = lectura.readLine();
			while(!linea.contains("subject")) {
				if(linea.contains("Received"))
					res = linea.substring(15);
				linea = lectura.readLine();
			}
			if(linea.contains("subject"))
				res = "Asunto: "+linea.substring(10)+" - Remitente: "+res;
			if(res.equals(""))
				res = "(Sin asunto)";
		} catch (IOException ioe) {
			// TODO Implementar error
		}
		return res;
	}

	public void cierraConexion(Socket socket) throws IOException {
		socket.close();
	}

	public String getCorreo(int index) {
		String res = "";
		try {
			escritura.println("retr "+index);
			String linea = lectura.readLine();
			while(!linea.equals(".")) {
				res+=linea+"\n";
				linea = lectura.readLine();
			}
		} catch (IOException ioe) {
			// TODO Implementar error
		}
		return res;
	}

}
