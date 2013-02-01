package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * ControladorNumerico
 * Creado el 12/01/2013
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Controlador
 * @version 1.1
 */
public class ControladorNumerico implements ActionListener, KeyListener{

	/**
	 * Vista
	 */
	private VistaCalculadora vista;

	/**
	 * Creamos el controlador a partir de la vista
	 * @param vc vista a controlar
	 */
	public ControladorNumerico(VistaCalculadora vc){
		vista = vc;
	}

	/**
	 * Controlamos el modelo y la vista a tenor de los distintos eventos
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(vista.getPantalla().equals("0") || vista.getOp()){
			if(ae.getActionCommand().equals(VistaCalculadora.DECIMAL)){
				if(!vista.getDecimal())
					vista.setPantalla("0.");
				vista.setDecimal(true);
			} else {
				vista.setPantalla(ae.getActionCommand());
				vista.setDecimal(false);
			}
		} else {
			if(ae.getActionCommand().equals(VistaCalculadora.DECIMAL)){
				if(!vista.getDecimal()){
					if(vista.getOp())
						vista.setPantalla("0.");
					else
						vista.setPantalla(vista.getPantalla().getText()+".");
				}
				vista.setDecimal(true);
			} else
				vista.setPantalla(vista.getPantalla().getText()+ae.getActionCommand());
		}
		vista.setOp(false);

	}

	/**
	 * Controlamos el modelo y la vista a tenor de los distintos eventos
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		if(vista.getPantalla().equals("0") || vista.getOp()){
			if(keyCode == KeyEvent.VK_PERIOD){
				if(!vista.getDecimal())
					vista.setPantalla("0.");
				vista.setDecimal(true);
			} else {
				if(keyCode == KeyEvent.VK_0 || keyCode == KeyEvent.VK_1 || keyCode == KeyEvent.VK_2 ||
						keyCode == KeyEvent.VK_3 || keyCode == KeyEvent.VK_4 || keyCode == KeyEvent.VK_5 ||
						keyCode == KeyEvent.VK_6 || keyCode == KeyEvent.VK_7 || keyCode == KeyEvent.VK_8 ||
						keyCode == KeyEvent.VK_9){
					vista.setPantalla(KeyEvent.getKeyText(keyCode));
					vista.setDecimal(false);
				}
			}
		} else {
			if(keyCode == KeyEvent.VK_PERIOD){
				if(!vista.getDecimal()){
					if(vista.getOp())
						vista.setPantalla("0.");
					else
						vista.setPantalla(vista.getPantalla().getText()+".");
				}
				vista.setDecimal(true);
			} else
				if(keyCode == KeyEvent.VK_0 || keyCode == KeyEvent.VK_1 || keyCode == KeyEvent.VK_2 ||
				keyCode == KeyEvent.VK_3 || keyCode == KeyEvent.VK_4 || keyCode == KeyEvent.VK_5 ||
				keyCode == KeyEvent.VK_6 || keyCode == KeyEvent.VK_7 || keyCode == KeyEvent.VK_8 ||
				keyCode == KeyEvent.VK_9)
				vista.setPantalla(vista.getPantalla().getText()+KeyEvent.getKeyText(keyCode));
		}
		vista.setOp(false);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		

	}
}
