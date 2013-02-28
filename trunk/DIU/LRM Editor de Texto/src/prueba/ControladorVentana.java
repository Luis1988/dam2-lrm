package prueba;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;

/**
 * Clase controladora de Paneleditor que ayudar� a la aplicaci�n a realizar redimensionado
 * de los elementos del JFrame de forma din�mica
 * @author Luis Romero Moreno
 * @version v1.5
 *
 */
public class ControladorVentana implements ComponentListener, WindowStateListener {
	
	/**
	 * Atributo que recoge los eventos del PanelEditor
	 */
	private VistaEditor ve;
	
	/**
	 * Constructor principal de la clase
	 * @param ve VistaEditor que recoger y edita los atributos propios de la clase
	 * PanelEditor
	 */
	public ControladorVentana(VistaEditor ve){
		this.ve = ve;
	}

	/**
	 * M�todo que maneja los eventos al esconderse un componente
	 */
	@Override
	public void componentHidden(ComponentEvent arg0) {
	}

	/**
	 * M�todo que maneja los eventos al moverse un componente
	 */
	@Override
	public void componentMoved(ComponentEvent arg0) {
	}

	/**
	 * M�todo que maneja los eventos al redimensionar un componente. 
	 * Este m�todo es el que nos permitir� redimensionar la ventana de forma
	 * din�mica
	 */
	@Override
	public void componentResized(ComponentEvent arg0) {
		ve.setTama�oComponentes(ve.getAnchuraVentana(), ve.getAlturaVentana());
	}

	/**
	 * M�todo que maneja los eventos al mostrarse un componente
	 */
	@Override
	public void componentShown(ComponentEvent arg0) {
	}

	/**
	 * M�todo que maneja los eventos de estado de una ventana.
	 * Este m�todo es el que recoger� los estados de ventana:
	 * iconizado, maximizado, restaurado, etc. Y que redimensionar�
	 * la ventana al maximizar o al restaurar
	 */
	@Override
	public void windowStateChanged(WindowEvent arg0) {
		ve.setTama�oComponentes(ve.getAnchuraVentana(), ve.getAlturaVentana());
		
	}

}
