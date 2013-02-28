package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAcercaDe implements ActionListener {
	
	private AcercaDe vista;
	
	public ControladorAcercaDe(AcercaDe vista){
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		vista.dispose();
	}

}
