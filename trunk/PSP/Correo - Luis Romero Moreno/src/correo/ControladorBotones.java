package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ControladorBotones implements ActionListener {
	
	private VistaCorreo vista;
	
	public ControladorBotones(VistaCorreo vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(VistaCorreo.CANCELAR)) {
			System.exit(0);
		}
		if(ae.getActionCommand().equals(VistaCorreo.ACEPTAR)) {
			try {
				Socket servidor = new Socket("localhost", 110);
				BufferedReader fEnt = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
				PrintWriter fSal = new PrintWriter(servidor.getOutputStream(), true);
				String linea = fEnt.readLine();
				while(!linea.contains("OK")){
					linea = fEnt.readLine();
					fSal.println("user: "+vista.getUsuario());
					System.out.println("funciona");
				}
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			vista.setVisibilidad();
			new Bandeja(vista.getUsuario(), vista.getPassword());
		}

	}

}
