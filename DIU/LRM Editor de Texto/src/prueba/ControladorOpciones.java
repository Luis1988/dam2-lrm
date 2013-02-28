package prueba;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase controladora del PanelEditor y que gestiona los eventos 
 * de edici�n del texto como es la fuente y el tama�o de este
 * @author Luis Romero Moreno
 * @version v1.7
 *
 */
public class ControladorOpciones implements ActionListener {
	
	/**
	 * Atributo que recoger� los eventos realizados en el men� de edici�n
	 */
	private VistaEditor ve;
	
	/**
	 * Constructor de la clase principal 
	 * @param ve VistaEditor que permite consultar y editar los atributos
	 * de su clase
	 */
	public ControladorOpciones(VistaEditor ve){
		this.ve = ve;
	}

	/**
	 * M�todo que manejar� los eventos recogidos por los botones de edici�n
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		int tama�o = ve.getAreaTexto().getFont().getSize();
		String fuente = ve.getAreaTexto().getFont().getName();
		if(e.getActionCommand().equals(VistaEditor.T_PREDETERMINADA)){
			if(!ve.getJmItemTPredeterminado().isSelected())
				ve.getJmItemTPredeterminado().setSelected(true);
			else{
				ve.getJmItem16().setSelected(false);
				ve.getJmItem24().setSelected(false);
			}
			tama�o = 12;
		}
		if(e.getActionCommand().equals(VistaEditor.T_16)){
			if(!ve.getJmItem16().isSelected())
				ve.getJmItem16().setSelected(true);
			else{
				ve.getJmItemTPredeterminado().setSelected(false);
				ve.getJmItem24().setSelected(false);
			}
			tama�o = 16;
		}
		if(e.getActionCommand().equals(VistaEditor.T_24)){
			if(!ve.getJmItem24().isSelected())
				ve.getJmItem24().setSelected(true);
			else{
				ve.getJmItem16().setSelected(false);
				ve.getJmItemTPredeterminado().setSelected(false);
			}
			tama�o = 24;
		}
		if(e.getActionCommand().equals(VistaEditor.F_PREDETERMINADA)){
			if(!ve.getJmItemFPredeterminada().isSelected())
				ve.getJmItemFPredeterminada().setSelected(true);
			else{
				ve.getJmItemCourierNew().setSelected(false);
				ve.getJmItemArial().setSelected(false);
			}
			fuente = "Default";
		}
		if(e.getActionCommand().equals(VistaEditor.F_COURIER)){
			if(!ve.getJmItemCourierNew().isSelected())
				ve.getJmItemCourierNew().setSelected(true);
			else{
				ve.getJmItemFPredeterminada().setSelected(false);
				ve.getJmItemArial().setSelected(false);
			}
			fuente = "Courier";
		}
		if(e.getActionCommand().equals(VistaEditor.F_ARIAL)){
			if(!ve.getJmItemArial().isSelected())
				ve.getJmItemArial().setSelected(true);
			else{
				ve.getJmItemCourierNew().setSelected(false);
				ve.getJmItemFPredeterminada().setSelected(false);
			}
			fuente = "Arial";
		}
		ve.getAreaTexto().setFont(new Font(fuente, Font.PLAIN, tama�o));
	}

}
