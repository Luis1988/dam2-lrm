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
	private JTextField tfSMTP_ip;
	private JTextField tfSMTP_puerto;
	private JTextField tfPOP3_ip;
	private JTextField tfPOP3_puerto;

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
		setTitle("Cliente Correo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 338, 266);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(12, 106, 117, 28);
		contentPane.add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(209, 106, 117, 28);
		contentPane.add(btnAceptar);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(12, 52, 101, 15);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contraseña:");
		lblContrasea.setBounds(12, 79, 101, 15);
		contentPane.add(lblContrasea);
		tfUsuario.setBounds(136, 47, 190, 25);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfPassword = new JPasswordField();
		tfPassword.setColumns(10);
		tfPassword.setBounds(136, 74, 190, 25);
		contentPane.add(tfPassword);
		
		JLabel lblClienteCorreo = new JLabel("Cliente Correo");
		lblClienteCorreo.setForeground(Color.BLUE);
		lblClienteCorreo.setFont(new Font("Loma", Font.BOLD, 23));
		lblClienteCorreo.setBounds(64, 12, 190, 28);
		contentPane.add(lblClienteCorreo);
		
		JLabel lblSmtpIp = new JLabel("SMTP IP:");
		lblSmtpIp.setBounds(12, 146, 101, 15);
		contentPane.add(lblSmtpIp);
		
		JLabel lblSmtpPuerto = new JLabel("SMTP Puerto:");
		lblSmtpPuerto.setBounds(12, 173, 101, 15);
		contentPane.add(lblSmtpPuerto);
		
		JLabel lblPopIp = new JLabel("POP3 IP:");
		lblPopIp.setBounds(12, 200, 101, 15);
		contentPane.add(lblPopIp);
		
		JLabel lblPopPuerto = new JLabel("POP3 Puerto:");
		lblPopPuerto.setBounds(12, 227, 101, 15);
		contentPane.add(lblPopPuerto);
		
		tfSMTP_ip = new JTextField();
		tfSMTP_ip.setText("localhost");
		tfSMTP_ip.setColumns(10);
		tfSMTP_ip.setBounds(136, 144, 190, 25);
		contentPane.add(tfSMTP_ip);
		
		tfSMTP_puerto = new JTextField();
		tfSMTP_puerto.setText("25");
		tfSMTP_puerto.setColumns(10);
		tfSMTP_puerto.setBounds(136, 171, 190, 25);
		contentPane.add(tfSMTP_puerto);
		
		tfPOP3_ip = new JTextField();
		tfPOP3_ip.setText("localhost");
		tfPOP3_ip.setColumns(10);
		tfPOP3_ip.setBounds(136, 198, 190, 25);
		contentPane.add(tfPOP3_ip);
		
		tfPOP3_puerto = new JTextField();
		tfPOP3_puerto.setText("110");
		tfPOP3_puerto.setColumns(10);
		tfPOP3_puerto.setBounds(136, 222, 190, 25);
		contentPane.add(tfPOP3_puerto);
		
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

	@SuppressWarnings("deprecation")
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return tfPassword.getText();
	}
	
	public void setVisibilidad() {
		this.setVisible(false);
	}

	@Override
	public String getSMTPIP() {
		return tfSMTP_ip.getText();
	}

	@Override
	public int getSMTPPUERTO() {
		return Integer.parseInt(tfSMTP_puerto.getText());
	}

	@Override
	public String getPOP3IP() {
		return tfPOP3_ip.getText();
	}

	@Override
	public int getPOP3PUERTO() {
		return Integer.parseInt(tfPOP3_puerto.getText());
	}
}
