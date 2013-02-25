package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.NoSuchElementException;

import persona.PersonaDao;

public class ControladorBoton implements ActionListener, FocusListener {
	
	private EjercicioPersona vista;
	private static PersonaDao dao = new PersonaDao();
	
	public ControladorBoton(EjercicioPersona vista) {
		this.vista = vista;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(vista.isInsertar()){
			String nPers = vista.getPNombre();
			dao.insertaPersona(nPers);
		}
		if(vista.isBorrar()){
			try{
			dao.borraPersona(vista.getPNombre());
			} catch(NoSuchElementException nsee) {
				vista.manejaError();
			}
		}
		vista.rellenaTabla(dao.obtienePersonas());
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		vista.rellenaTabla(dao.obtienePersonas());
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
