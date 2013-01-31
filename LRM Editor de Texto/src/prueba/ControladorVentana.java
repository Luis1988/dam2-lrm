package prueba;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ControladorVentana implements ComponentListener {
	
	private VistaEditor ve;
	
	public ControladorVentana(VistaEditor ve){
		this.ve = ve;
	}

	@Override
	public void componentHidden(ComponentEvent arg0) {
	}

	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	@Override
	public void componentResized(ComponentEvent arg0) {
		ve.setTamañoComponentes(ve.getAnchuraVentana(), ve.getAlturaVentana());
	}

	@Override
	public void componentShown(ComponentEvent arg0) {
	}

}
