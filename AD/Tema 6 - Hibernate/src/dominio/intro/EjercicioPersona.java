package dominio.intro;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class EjercicioPersona extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField tfPersona;
	private JTable table;
	private DefaultTableModel dtm;
	private static final String[] cabecera = {"ID","NOMBRE"};
	private static int op = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjercicioPersona frame = new EjercicioPersona();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EjercicioPersona() {
		setResizable(false);
		setTitle("Ejercicio Personas Hibernate - LRM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnInsertar = new JRadioButton("Insertar");
		buttonGroup.add(rdbtnInsertar);
		rdbtnInsertar.setBounds(6, 32, 76, 23);
		contentPane.add(rdbtnInsertar);
		
		JRadioButton rdbtnBorrar = new JRadioButton("Borrar");
		buttonGroup.add(rdbtnBorrar);
		rdbtnBorrar.setBounds(6, 58, 65, 23);
		contentPane.add(rdbtnBorrar);
		
		JLabel lblOperaciones = new JLabel("Operaciones:");
		lblOperaciones.setBounds(10, 11, 85, 14);
		contentPane.add(lblOperaciones);
		
		tfPersona = new JTextField();
		tfPersona.setBounds(88, 46, 86, 20);
		contentPane.add(tfPersona);
		tfPersona.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(199, 10, 225, 93);
		contentPane.add(scrollPane);
		
		dtm = new DefaultTableModel();
		dtm.setRowCount(0);
		dtm.setColumnCount(0);
		dtm.setColumnIdentifiers(cabecera);
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setModel(dtm);
		scrollPane.setViewportView(table);
		
		JButton btnRealizarOperacin = new JButton("Realizar operaci\u00F3n");
		btnRealizarOperacin.setBounds(16, 88, 148, 23);
		contentPane.add(btnRealizarOperacin);
		
		btnRealizarOperacin.addActionListener(new ControladorBoton(this, op));
		rdbtnInsertar.setSelected(true);
		rdbtnInsertar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				op = 0;
			}
		});
		rdbtnBorrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				op = 1;
			}
		});
		
		//contentPane.addFocusListener(new ControladorBoton(this,op));
	}
	
	public String getPNombre(){
		return tfPersona.getText();
	}

	public void insertaFila(Persona p) {
		String[] fila = {String.valueOf(p.getId()), p.getNombre()};
		dtm.addRow(fila);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setModel(dtm);
	}
	
	public void rellenaTabla(List<Persona> personas) {
		dtm.setRowCount(0);
		dtm.setColumnCount(0);
		dtm.setColumnIdentifiers(cabecera);
		for(int i = 0; i < personas.size(); i++) {
			String[] fila = {String.valueOf(personas.get(i).getId()), 
					personas.get(i).getNombre()};
			dtm.addRow(fila);
		}
		table.setModel(dtm);
	}

	public void manejaError() {
		JOptionPane.showMessageDialog(this, 
				"El elemento que quiere borrar no existe", "Error", 
				JOptionPane.ERROR_MESSAGE);
	}

}
