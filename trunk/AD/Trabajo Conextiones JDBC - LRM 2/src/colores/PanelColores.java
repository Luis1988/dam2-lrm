package colores;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class PanelColores extends JFrame implements VistaColores {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuario;
	private JFormattedTextField tfPassword;
	private JButton btnConexion, btnMostrar;
	private JComboBox<String> comboBox;
	private JTextArea tfConexion;
	private JLabel color;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelColores frame = new PanelColores();
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
	public PanelColores() {
		setTitle("Ejercicio Colores - Luis Romero Moreno");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 244);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 11, 59, 14);
		contentPane.add(lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(84, 8, 86, 20);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(180, 11, 75, 14);
		contentPane.add(lblContrasea);
		
		tfPassword = new JFormattedTextField();
		tfPassword.setBounds(265, 8, 95, 20);
		contentPane.add(tfPassword);
		tfPassword.setColumns(10);
		
		btnConexion = new JButton("Conectarse");
		btnConexion.setBounds(10, 36, 103, 23);
		contentPane.add(btnConexion);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(123, 35, 237, 52);
		contentPane.add(scrollPane);
		
		tfConexion = new JTextArea();
		tfConexion.setEditable(false);
		scrollPane.setViewportView(tfConexion);
		
		comboBox = new JComboBox<String>();
		comboBox.setBounds(10, 98, 103, 20);
		contentPane.add(comboBox);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.setBounds(123, 98, 89, 23);
		contentPane.add(btnMostrar);
		
		color = new JLabel();
		color.setIcon(new ImageIcon());
		color.setBounds(222, 101, 138, 104);
		contentPane.add(color);
		
		deshabilitarComponentes(false);
		controlador(this);
	}
	
	@Override
	public void setListaColores(String[] lista) {
		comboBox.setModel(new DefaultComboBoxModel<String>(lista));
	}

	@Override
	public String getUsuario() {
		return tfUsuario.getText();
	}

	@Override
	public String getPassword() {
		return tfPassword.getText();
	}

	@Override
	public void setConexion(String resultado) {
		tfConexion.setText(resultado);
	}
	
	public void controlador(VistaColores vc) {
		btnConexion.addActionListener(new ControladorColores(vc));
		btnConexion.setActionCommand(VistaColores.CONEXION);
		btnMostrar.addActionListener(new ControladorColores(vc));
		btnMostrar.setActionCommand(VistaColores.MOSTRAR);
	}

	@Override
	public void deshabilitarComponentes(boolean flag) {
		btnConexion.setEnabled(!flag);
		tfUsuario.setEnabled(!flag);
		tfPassword.setEnabled(!flag);
		btnConexion.setEnabled(!flag);
		comboBox.setEnabled(flag);
		btnMostrar.setEnabled(flag);
	}
	
	@Override
	public String getComboBox() {
		return String.valueOf(comboBox.getSelectedItem());
	}

	@Override
	public void setColor(ImageIcon imagen) {
		color.setIcon(imagen);
	}
}
