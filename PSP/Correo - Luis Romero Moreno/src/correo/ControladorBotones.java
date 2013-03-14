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
			LecturaCorreo lc = new LecturaCorreo(vista, "localhost", 110, 
					vista.getUsuario(), vista.getPassword());
			vista.setVisibilidad();
			Bandeja b = new Bandeja(lc);
			b.setVisible(true);
		}

	}

}
