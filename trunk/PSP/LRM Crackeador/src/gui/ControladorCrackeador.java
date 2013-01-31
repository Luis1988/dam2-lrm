package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCrackeador implements ActionListener {
	
	private VistaCrackeador vc;
	private static CrackDiccionario cd = null;
	
	public ControladorCrackeador(VistaCrackeador vc){
		this.vc = vc;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(VistaCrackeador.CRACK)){
			vc.setResultado("");
			vc.habilitaBotones(false);
			cd = new CrackDiccionario(vc.getHost(), vc.getPuerto(), vc.getFichUsuarios(), 
					vc.getFichPasswords(), vc.isSecuencial(), vc);
		}
		if(ae.getActionCommand().equals(VistaCrackeador.ABORTAR)){
			vc.habilitaBotones(true);
			cd.abortar();
		}
	}

}
