package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ControladorEdicion implements ActionListener, MouseListener {

	private VistaEditor ve;
	private JFileChooser fileChooser;

	public ControladorEdicion(VistaEditor ve){
		this.ve = ve;
		fileChooser = new JFileChooser();
	}

	private void muestraPopUp(MouseEvent e){
		if(e.isPopupTrigger()){
			//ve.getMenuPop().setLocation(e.getLocationOnScreen());
			ve.getMenuPop().show(ve.getAreaTexto(),e.getX(), e.getY());
		}
	}

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
				FileWriter fichero;
				try {
					fichero = new FileWriter(fileChooser.getSelectedFile().getAbsolutePath());
					fichero.write(ve.getAreaTexto().getText());
					fichero.close();
				} catch (IOException ioe) {
					JOptionPane.showMessageDialog(ve.getFrame(), "Error al guardar el fichero", 
							"Error de escritura", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if(ae.getActionCommand().equals(VistaEditor.ABRIR)){
			int seleccion = fileChooser.showOpenDialog(ve.getFrame().getContentPane());
			if(seleccion == JFileChooser.APPROVE_OPTION){
				FileReader fichero;
				try{
					fichero = new FileReader(fileChooser.getSelectedFile().getAbsolutePath());
					ve.getAreaTexto().setText("");
					char[] buffer=new char[256];
					int longitud;
					while((longitud = fichero.read(buffer))!=-1){
						String s = new String(buffer, 0,longitud);
						ve.getAreaTexto().setText(ve.getAreaTexto().getText()+s);
					}
					fichero.close();
				}catch(IOException ioe){
					JOptionPane.showMessageDialog(ve.getFrame(), "Error al leer el fichero", 
							"Error de lectura", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

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

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		muestraPopUp(e);
	}

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
