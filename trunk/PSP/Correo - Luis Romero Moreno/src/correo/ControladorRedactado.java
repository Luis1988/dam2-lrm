package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRedactado implements ActionListener {
	
	private VistaRedactado vr;
	
	public ControladorRedactado(VistaRedactado vr) {
		this.vr = vr;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(VistaRedactado.DESCARTAR))
			vr.liberarVentana();
		if(ae.getActionCommand().equals(VistaRedactado.ENVIAR)){
			new EscrituraCorreo(vr, vr.getIp(), vr.getPuerto());
		}

	}

}
