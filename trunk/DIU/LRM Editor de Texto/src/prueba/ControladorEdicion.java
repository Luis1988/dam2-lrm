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
 * Controlador de la clase PanelEditor y que manejará los eventos de ratón 
 * y de botones sobre cortar, copiar, pegar, salir, guardar, abrir y acerca de
 * @author Luis Romero Moreno
 * @version v1.9
 */
public class ControladorEdicion implements ActionListener, MouseListener {

	/**
	 * Recoge los eventos del panel a través de este atributo
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
	 * Método que nos permite realizar menus contextuales en la aplicación
	 * @param e MouseEvent que recoge los eventos del ratón
	 */
	private void muestraPopUp(MouseEvent e){
		if(e.isPopupTrigger()){
			ve.getMenuPop().show(ve.getAreaTexto(),e.getX(), e.getY());
		}
	}

	/**
	 * Método que recoge los eventos por los botones de la aplicación
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
				JOptionPane.showMessageDialog(ve.getFrame(), "No se puede deshacer nada más", "Error Undo", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(ae.getActionCommand().equals(VistaEditor.REDO)){
			try{
				ve.getManager().redo();
			} catch (CannotRedoException cue) {
				JOptionPane.showMessageDialog(ve.getFrame(), "No se puede rehacer nada más", "Error Redo", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Método que recoge los eventos por ratón al hacer click. Este método maneja 
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
	 * Método que recoge los eventos al entrar en un componente
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
	}

	/**
	 * Método que recoge los eventos al salir de un componente
	 */
	@Override
	public void mouseExited(MouseEvent e) {
	}

	/**
	 * Método que recoge los eventos por ratón con el botón derecho
	 * para mostrar el menú contextual
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		muestraPopUp(e);
	}

	/**
	 * Método que recoge los eventos por ratón al liberar un click 
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
