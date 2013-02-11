package ejercicio1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Login extends JFrame implements VistaLogin {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frmLoginLuis;
	private JTextField tfUsuario;
	private JPasswordField tfPassword;
	private JButton btnAceptar, btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLoginLuis.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLoginLuis = new JFrame();
		frmLoginLuis.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLoginLuis.setResizable(false);
		frmLoginLuis.setTitle("Login - Luis Romero Moreno");
		frmLoginLuis.setBounds(100, 100, 217, 120);
		frmLoginLuis.getContentPane().setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(10, 11, 71, 14);
		frmLoginLuis.getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a:");
		lblPassword.setBounds(10, 36, 71, 14);
		frmLoginLuis.getContentPane().add(lblPassword);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(91, 8, 107, 20);
		frmLoginLuis.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setBounds(91, 33, 107, 20);
		frmLoginLuis.getContentPane().add(tfPassword);
		tfPassword.setColumns(10);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(10, 61, 89, 23);
		frmLoginLuis.getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(109, 61, 89, 23);
		frmLoginLuis.getContentPane().add(btnCancelar);
		
		controlador(this);
	}
	
	public void controlador(VistaLogin vl){
		btnAceptar.addActionListener(new ControladorLogin(vl));
		btnCancelar.addActionListener(new ControladorLogin(vl));
		btnAceptar.setActionCommand(VistaLogin.ACEPTAR);
		btnCancelar.setActionCommand(VistaLogin.CANCELAR);
	}

	@Override
	public String getUsuario() {
		return tfUsuario.getText();
	}

	@SuppressWarnings("deprecation")
	@Override
	public String getPass() {
		return tfPassword.getText();
	}

	@Override
	public void muestraError(Exception e) {
		JOptionPane.showMessageDialog(this, e.getMessage(), "Error SQL", JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostrarLogin(boolean flag){
		this.setVisible(flag);
	}
	
}
