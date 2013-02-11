
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;


public class GUI extends JFrame implements ActionListener{
	
	private final String[] titulos = {"Nombre", "Dirección", "Teléfono", "Localidad"};
	private DefaultTableModel dtm = new DefaultTableModel();
	private JTable personTable= new JTable(dtm);
	private BDManagement bdm = new BDManagement();
	private JMenuBar menuBar;
	private JMenu actionMenu;
	private JMenuItem addMenuItem, removeMenuItem, readMenuItem;
	private JScrollPane scroll;
	private FrameAddPerson fap;
	private List<Integer> ids = new ArrayList<Integer>();
	
	
	public GUI() {
		super("Ejemplo DTModel");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(810, 460);
		this.addComponents();
		this.setVisible(true);
	}
	
	public void fillTable() {
		
		dtm.setRowCount(0);
		dtm.setColumnCount(0);
		dtm.setColumnIdentifiers(titulos);
		ids.clear();
		try {
			ResultSet aux= bdm.getSt().executeQuery("SELECT * FROM CLIENTES2");
			while (aux.next()){
				Object [] fila = {aux.getObject(1), aux.getObject(2), aux.getObject(3), aux.getObject(4)};
				ids.add((Integer)aux.getInt(5));
				dtm.addRow(fila);
				
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public void addComponents() {
		
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		actionMenu = new JMenu("Acciones");
		menuBar.add(actionMenu);
		addMenuItem = new JMenuItem("Agregar Registro");
		removeMenuItem = new JMenuItem("Eliminar Registros");
		readMenuItem = new JMenuItem("Leer Registros");
		actionMenu.add(addMenuItem);
		actionMenu.add(removeMenuItem);
		actionMenu.add(readMenuItem);
		readMenuItem.addActionListener(this);
		addMenuItem.addActionListener(this);
		removeMenuItem.addActionListener(this);
		
		dtm.setColumnIdentifiers(titulos);
		
		scroll = new JScrollPane(personTable);
		scroll.setBounds(0, 0, 800, 400);
		this.add(scroll);
		}
			
		
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()==addMenuItem) {
			fap=new FrameAddPerson(this);
		}else if(ae.getSource()==removeMenuItem) {
			
			this.deleteRows(personTable.getSelectedRows());
			
		}else if(ae.getSource()==readMenuItem){
			this.fillTable();
		} else if (ae.getSource()==fap.getBtnAgregar()) {
			Persona p = new Persona(fap.getTxtNombreApellido().getText(), fap.getTxtDir().getText(), fap.getTxtLoc().getText(), fap.getTxtTel().getText());
			this.addRow(p);
			fap.dispose();
			
		}
		
	}
	
	public void addRow(Persona p){
		String query="INSERT INTO CLIENTES2 VALUES ('"+p.getNya()+"','"+p.getDir()+"','"+p.getTel()+"','"+p.getLoc()+"',SECUENCIA.NEXTVAL)";
		System.out.println(query);
		try{
			bdm.getSt().executeUpdate(query);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		this.fillTable();
	}
	public void deleteRows(int[] rowsSelected) {
		
		for(int i=0; i<rowsSelected.length; i++) {
			
			String borrar = "DELETE FROM CLIENTES2 WHERE idcliente="+ids.get(rowsSelected[i]);
			try{
				bdm.getSt().executeUpdate(borrar);
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}
		this.fillTable();
		
	}

}
