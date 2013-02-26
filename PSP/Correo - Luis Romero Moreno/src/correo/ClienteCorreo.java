package correo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPasswordField;

public class ClienteCorreo extends JFrame implements VistaCorreo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTextField tfUsuario = new JTextField();
	private JPasswordField tfPassword;
	private JButton btnAceptar, btnCancelar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteCorreo frame = new ClienteCorreo();
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
	public ClienteCorreo() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 338, 186);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(35, 116, 117, 28);
		contentPane.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(196, 116, 117, 28);
		contentPane.add(btnAceptar);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(12, 57, 101, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(12, 84, 101, 15);
		contentPane.add(lblContrasea);
		tfUsuario.setBounds(131, 52, 190, 25);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(131, 79, 190, 25);
		contentPane.add(tfPassword);
		
		JLabel lblClienteCorreo = new JLabel("Cliente Correo");
		lblClienteCorreo.setForeground(Color.BLUE);
		lblClienteCorreo.setFont(new Font("Loma", Font.BOLD, 23));
		lblClienteCorreo.setBounds(93, 17, 156, 28);
		contentPane.add(lblClienteCorreo);
		
		controladorBotones(this);
	}

	private void controladorBotones(VistaCorreo clienteCorreo) {
		btnAceptar.addActionListener(new ControladorBotones(clienteCorreo));
		btnCancelar.addActionListener(new ControladorBotones(clienteCorreo));
		btnAceptar.setActionCommand(VistaCorreo.ACEPTAR);
		btnCancelar.setActionCommand(VistaCorreo.CANCELAR);
	}

	@Override
	public String getUsuario() {
		return tfUsuario.getText();
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return tfPassword.getText();
	}
	
	public void setVisibilidad() {
		this.setVisible(false);
	}
}
