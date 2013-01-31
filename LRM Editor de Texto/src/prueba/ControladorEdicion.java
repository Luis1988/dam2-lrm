package prueba;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorEdicion implements ActionListener, MouseListener {

	private VistaEditor ve;

	public ControladorEdicion(VistaEditor ve){
		this.ve = ve;
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
