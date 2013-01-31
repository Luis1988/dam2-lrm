package prueba;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorOpciones implements ActionListener {
	
	private VistaEditor ve;
	
	public ControladorOpciones(VistaEditor ve){
		this.ve = ve;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int tamaño = ve.getAreaTexto().getFont().getSize();
		String fuente = ve.getAreaTexto().getFont().getName();
		if(e.getActionCommand().equals(VistaEditor.T_PREDETERMINADA)){
			if(!ve.getJmItemTPredeterminado().isSelected())
				ve.getJmItemTPredeterminado().setSelected(true);
			else{
				ve.getJmItem16().setSelected(false);
				ve.getJmItem24().setSelected(false);
			}
			tamaño = 12;
		}
		if(e.getActionCommand().equals(VistaEditor.T_16)){
			if(!ve.getJmItem16().isSelected())
				ve.getJmItem16().setSelected(true);
			else{
				ve.getJmItemTPredeterminado().setSelected(false);
				ve.getJmItem24().setSelected(false);
			}
			tamaño = 16;
		}
		if(e.getActionCommand().equals(VistaEditor.T_24)){
			if(!ve.getJmItem24().isSelected())
				ve.getJmItem24().setSelected(true);
			else{
				ve.getJmItem16().setSelected(false);
				ve.getJmItemTPredeterminado().setSelected(false);
			}
			tamaño = 24;
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
		ve.getAreaTexto().setFont(new Font(fuente, Font.PLAIN, tamaño));
	}

}
