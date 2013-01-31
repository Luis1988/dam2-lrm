package tablas;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Calendario extends JFrame implements VistaCalendario {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer[] years = {2007,2008,2009,2010};
	private String[] months = {"Enero","Febrero","Marzo","Abril",
			"Mayo","Junio","Julio","Agosto","Septiembre","Octubre",
			"Noviembre","Diciembre"};
	private String[] dayWeeks = {"Lunes","Martes","Miércoles","Jueves",
			"Viernes","Sábado","Domingo"};
	private JComboBox<Integer> jcbYears;
	private JList<String> jlMonths;
	private JScrollPane jsMonths;
	private JTable jtCalendario;

	public Calendario() {
		
		this.setTitle("Calendario - Luis Romero Moreno");
		this.setBounds(200,200,500,280);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		
		jcbYears = new JComboBox<Integer>(years);
		jcbYears.setBounds(10, 10, 65, 30);
		jlMonths = new JList<String>(months);
		jlMonths.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlMonths.setSelectedIndex(0);
		jsMonths = new JScrollPane(jlMonths);
		jsMonths.setBounds(150, 10, 90, 105);
		jtCalendario = new JTable(7, 7);
		jtCalendario.setBounds(10, 125, 475, 112);
		
		añadirDiasSemana();
		ControladorCalendario.añadirDias(
				jlMonths.getSelectedIndex(), 
				(Integer) jcbYears.getSelectedItem());
		
		this.add(jcbYears);
		this.add(jsMonths);
		this.add(jtCalendario);
		this.setVisible(true);
		
	}
	
	public void añadirDiasSemana(){
		for(int i = 0; i < dayWeeks.length; i++){
			jtCalendario.setValueAt(dayWeeks[i], 0, i);
		}
	}
	
	public JTable getCalendario(){
		return jtCalendario;
	}
	
	public static void main(String[] args) {
		
		new Calendario();
		
	}

}
