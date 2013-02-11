package ejercicio1;

import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Font;

public class TablaRS extends JFrame implements VistaTablaRS {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Statement stmt;
	private JButton btnSelect;
	private JTextField tfTable;
	private JTextArea datosTabla;

	/**
	 * Create the application.
	 */
	public TablaRS(Statement stmt) {
		setResizable(false);
		this.stmt = stmt;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("ScrollResultJ");
		getContentPane().setLayout(null);
		
		btnSelect = new JButton("Select");
		btnSelect.setBounds(10, 11, 79, 23);
		getContentPane().add(btnSelect);
		
		JLabel lblTable = new JLabel("Table:");
		lblTable.setBounds(204, 15, 38, 14);
		getContentPane().add(lblTable);
		
		tfTable = new JTextField();
		tfTable.setBounds(252, 12, 144, 20);
		getContentPane().add(tfTable);
		tfTable.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 386, 207);
		getContentPane().add(scrollPane);
		
		datosTabla = new JTextArea();
		datosTabla.setEditable(false);
		datosTabla.setFont(new Font("Lucida Console", Font.PLAIN, 13));
		scrollPane.setViewportView(datosTabla);
		setBounds(100, 100, 450, 300);
		
		controlador(this);
		
	}
	
	public void controlador(VistaTablaRS vtrs) {
		btnSelect.addActionListener(new ControladorTabla(vtrs, stmt));
		btnSelect.setActionCommand(VistaTablaRS.SELECT);
	}

	@Override
	public String getTabla() {
		return tfTable.getText();
	}

	@Override
	public void muestraError(SQLException e) {
		String error = "--- SQLException Capturada ---\n";
		while(e != null){
			error+="Mensaje: "+e.getMessage();
			error+="SQLState: "+e.getSQLState()+"\n";
			error+="ErrorCode: "+e.getErrorCode();
			e = e.getNextException();
			error+="\n";
		}
		JOptionPane.showMessageDialog(this, error, "Error SQL", JOptionPane.ERROR_MESSAGE);	
	}

	@Override
	public void escribeTabla(String s) {
		datosTabla.setText(s);
	}
	
}
