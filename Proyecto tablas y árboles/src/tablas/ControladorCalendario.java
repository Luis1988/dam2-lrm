package tablas;

import java.util.GregorianCalendar;

public class ControladorCalendario {
	
	private VistaCalendario vc;
	
	public ControladorCalendario(VistaCalendario vc){
		this.vc = vc;
	}
	
	public static void a�adirDias(int mes, int a�o){
		
		GregorianCalendar gc = new GregorianCalendar(a�o, mes, 1);
		gc.setFirstDayOfWeek(GregorianCalendar.MONDAY);
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK)+" "+a�o+" "+mes);
		System.out.println(gc.getFirstDayOfWeek());
		
	}

}
