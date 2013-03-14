package correo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EscrituraCorreo {
	
	private Socket servidor;
	private VistaRedactado vr;
	private BufferedReader lectura;
	private PrintWriter escritura;
	private String ip;
	
	public EscrituraCorreo(VistaRedactado vr, String ip, int puerto) {
		this.ip = ip;
		this.vr = vr;
		try {
			servidor = new Socket(ip, puerto);
			lectura = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
			escritura = new PrintWriter(servidor.getOutputStream(), true);
			ejecucion();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void ejecucion() {
		try {
			String linea = lectura.readLine();
			escritura.println("ehlo "+ip);
			linea = lectura.readLine();
			while(!linea.contains("DSN")) {
				linea = lectura.readLine();
				if(linea.contains("DSN"))
					escritura.println("mail from: "+vr.getRemitente());
			}
			linea = lectura.readLine();
			if(linea.contains("250")){
				escritura.println("rcpt to: "+vr.getDestinatario());
				linea = lectura.readLine();
				if(linea.contains("250")){
					escritura.println("data");
					linea = lectura.readLine();
					if(linea.contains("354")){
						escritura.println("subject: "+vr.getAsunto());
						escritura.println(vr.getRedactado());
						escritura.println(".");
						linea = lectura.readLine();
						if(linea.contains("250")){
							escritura.println("quit");
							linea = lectura.readLine();
							escritura.close();
							lectura.close();
							servidor.close();
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Implementar errores
		}
	}

}
