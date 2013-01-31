package tablas;

import java.util.GregorianCalendar;

public class ControladorCalendario {
	
	private VistaCalendario vc;
	
	public ControladorCalendario(VistaCalendario vc){
		this.vc = vc;
	}
	
	public static void añadirDias(int mes, int año){
		
		GregorianCalendar gc = new GregorianCalendar(año, mes, 1);
		gc.setFirstDayOfWeek(GregorianCalendar.MONDAY);
		System.out.println(gc.get(GregorianCalendar.DAY_OF_WEEK)+" "+año+" "+mes);
		System.out.println(gc.getFirstDayOfWeek());
		
	}

}
