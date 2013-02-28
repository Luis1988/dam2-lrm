package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador del JFrame AcercaDe y que muestra todos los datos acerca del programa
 * @author Luis Romero Moreno
 * @version v1.7
 */
public class ControladorAcercaDe implements ActionListener {
	
	/**
	 * Atributo privado vista, que llama a la clase AcercaDe
	 */
	
	private AcercaDe vista;
	/**
	 * Constructor principal
	 * @param vista que llama a la clase AcercaDe
	 */
	public ControladorAcercaDe(AcercaDe vista){
		this.vista = vista;
	}

	/**
	 * Método que realiza la acción del botón aceptar
	 * y cierra/libera de la memoria la ventana
	 * AcercaDe
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		vista.dispose();
	}

}
