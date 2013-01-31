package tablas;

import java.util.GregorianCalendar;

public class ControladorCalendario {
	
	private static VistaCalendario vc;
	
	public ControladorCalendario(VistaCalendario vc){
		this.vc = vc;
	}
	
	public static void a�adirDias(int mes, int a�o){
		GregorianCalendar gc = new GregorianCalendar(a�o, mes, 1);
		for(int i = 0; i < gc.getActualMaximum(GregorianCalendar.DAY_OF_MONTH); i++){
			gc.set(a�o, mes, i+1);
			int columna = gc.get(GregorianCalendar.DAY_OF_WEEK) - 2;
			if(columna < 0)
				columna = 6;
			vc.getCalendario().setValueAt(i+1, gc.get(GregorianCalendar.DAY_OF_WEEK_IN_MONTH), columna);
		}
	}

}
