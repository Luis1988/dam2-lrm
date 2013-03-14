package correo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ControladorBandeja implements ActionListener, ListSelectionListener {
	
	private VistaBandeja vb;
	
	public ControladorBandeja(VistaBandeja vb) {
		this.vb = vb;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals(VistaBandeja.SALIR)){
			try {
				vb.getLectura().cierraConexion();
			} catch (IOException e) {
			} finally {
				System.exit(0);
			}
		}
		if(ae.getActionCommand().equals(VistaBandeja.SINCRONIZAR)){
			vb.actualizaLista(vb.getLectura().getCorreos());
		}
		if(ae.getActionCommand().equals(VistaBandeja.REDACTAR)){
			new Redactado(vb).setVisible(true);
		}
			
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == vb.getList()) {
			String txtCorreo = vb.getLectura().getCorreo(vb.getList().getSelectedIndex()+1);
			vb.setCorreoLeido(txtCorreo);
		}
	}

}
