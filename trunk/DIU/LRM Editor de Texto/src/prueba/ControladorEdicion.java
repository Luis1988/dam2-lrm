package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

/**
 * Controlador de la clase PanelEditor y que manejar� los eventos de rat�n 
 * y de botones sobre cortar, copiar, pegar, salir, guardar, abrir y acerca de
 * @author Luis Romero Moreno
 * @version v1.9
 */
public class ControladorEdicion implements ActionListener, MouseListener {

	/**
	 * Recoge los eventos del panel a trav�s de este atributo
	 */
	private VistaEditor ve;
	/**
	 * Atributo que nos permite seleccionar un fichero, ya sea para 
	 * guardarlo o leerlo
	 */
	private JFileChooser fileChooser;

	/**
	 * Constructor principal de la clase que recoge la vista
	 * @param ve VistaEditor que recoge y edita los datos del 
	 * PanelEditor
	 */
	private Fichero fichero;

	public ControladorEdicion(VistaEditor ve){
		this.ve = ve;
		fileChooser = new JFileChooser();
		fichero = new Fichero(ve);
	}

	/**
	 * M�todo que nos permite realizar menus contextuales en la aplicaci�n
	 * @param e MouseEvent que recoge los eventos del rat�n
	 */
	private void muestraPopUp(MouseEvent e){
		if(e.isPopupTrigger()){
			ve.getMenuPop().show(ve.getAreaTexto(),e.getX(), e.getY());
		}
	}

	/**
	 * M�todo que recoge los eventos por los botones de la aplicaci�n
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals(VistaEditor.COPIAR))
			ve.getAreaTexto().copy();
		if (ae.getActionCommand().equals(VistaEditor.CORTAR))
			ve.getAreaTexto().cut();
		if (ae.getActionCommand().equals(VistaEditor.PEGAR))
			ve.getAreaTexto().paste();
		if (ae.getActionCommand().equals(VistaEditor.SALIR))
			System.exit(0);
		if (ae.getActionCommand().equals(VistaEditor.GUARDAR)){
			int seleccion = fileChooser.showOpenDialog(ve.getFrame().getContentPane());
			if(seleccion == JFileChooser.APPROVE_OPTION){
				fichero.setFichero(fileChooser.getSelectedFile().getAbsolutePath());
				fichero.guardar();
			}
		}
		if(ae.getActionCommand().equals(VistaEditor.ABRIR)){
			int seleccion = fileChooser.showOpenDialog(ve.getFrame().getContentPane());
			if(seleccion == JFileChooser.APPROVE_OPTION){
				fichero.setFichero(fileChooser.getSelectedFile().getAbsolutePath());
				fichero.abrir();
			}
		}
		if(ae.getActionCommand().equals(VistaEditor.ACERCA_DE)){
			new JDialog(new AcercaDe());
		}
		if(ae.getActionCommand().equals(VistaEditor.UNDO)){
			try {
				ve.getManager().undo();
			} catch (CannotUndoException cue) {
				JOptionPane.showMessageDialog(ve.getFrame(), "No se puede deshacer nada m�s", "Error Undo", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(ae.getActionCommand().equals(VistaEditor.REDO)){
			try{
				ve.getManager().redo();
			} catch (CannotRedoException cue) {
				JOptionPane.showMessageDialog(ve.getFrame(), "No se puede rehacer nada m�s", "Error Redo", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * M�todo que recoge los eventos por rat�n al hacer click. Este m�todo maneja 
	 * los doble y triple clicks realizados en el texto para habilitar los botones 
	 * copiar y cortar que seleccionan el texto
	 */
	@Override
	public void mouseClicked(MouseEvent e){
		if(e.getClickCount() == 1 || e.getClickCount() > 3)
			ve.habilitarItemEdicion(false);
		try{
			if((e.getClickCount() == 2 || e.getClickCount() == 3) 
					&& ve.getAreaTexto().getSelectedText().length()>0)
				ve.habilitarItemEdicion(true);
		} catch (NullPointerException npe) {

		}
	}

	/**
	 * M�todo que recoge los eventos al entrar en un componente
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * M�todo que recoge los eventos al salir de un componente
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * M�todo que recoge los eventos por rat�n con el bot�n derecho
	 * para mostrar el men� contextual
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		muestraPopUp(e);
	}

	/**
	 * M�todo que recoge los eventos por rat�n al liberar un click 
	 * realizado por el usuario
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		try{
			if(ve.getAreaTexto().getSelectedText().length() > 0)
				ve.habilitarItemEdicion(true);
		} catch (NullPointerException npe) {

		}
		muestraPopUp(e);
	}

}
