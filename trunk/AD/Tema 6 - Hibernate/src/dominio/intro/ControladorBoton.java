package dominio.intro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.NoSuchElementException;

public class ControladorBoton implements ActionListener {
	
	private EjercicioPersona vista;
	private int op;
	private static PersonaDao1 dao = new PersonaDao1();
	
	public ControladorBoton(EjercicioPersona vista, int op) {
		this.vista = vista;
		this.op = op;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(op == 0){
			String nPers = vista.getPNombre();
			dao.insertaPersona(nPers);
		}
		else{
			try{
			dao.borraPersona(vista.getPNombre());
			} catch(NoSuchElementException nsee) {
				vista.manejaError();
			}
		}
		vista.rellenaTabla(dao.obtienePersonas());
	}

	/*@Override
	public void focusGained(FocusEvent arg0) {
		vista.rellenaTabla(dao.obtienePersonas());
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}*/

}
