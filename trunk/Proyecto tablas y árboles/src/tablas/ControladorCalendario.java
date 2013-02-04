package tablas;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.GregorianCalendar;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ControladorCalendario implements ListSelectionListener, ItemListener {

	private static VistaCalendario vc;

	public ControladorCalendario(VistaCalendario vc){
		this.vc = vc;
	}

	public static void añadirDias(int mes, int año){
		GregorianCalendar gc = new GregorianCalendar(año, mes, 1);
		int fila = 1;
		for(int i = 0; i < gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH); i++){
			gc.set(año, mes, i+1);
			int columna = gc.get(GregorianCalendar.DAY_OF_WEEK) - 2;
			if(columna < 0)
				columna = 6;
			vc.getCalendario().setValueAt(i+1, fila, columna);
			if(columna == 6)
				fila++;
		}
	}
	
	public static void setVista(VistaCalendario vista){
		vc = vista;
	}
	
	public void limpiaCalendario(){
		for(int fila = 1; fila < 7; fila++){
			for(int columna = 0; columna < 7; columna++){
				vc.getCalendario().setValueAt("", fila, columna);
			}
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent lse) {
		limpiaCalendario();
		añadirDias(vc.getMes(),vc.getAño());
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		limpiaCalendario();
		añadirDias(vc.getMes(),vc.getAño());
		
	}

}
