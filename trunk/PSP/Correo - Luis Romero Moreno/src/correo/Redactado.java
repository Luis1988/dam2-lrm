package correo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Redactado extends JFrame implements VistaRedactado {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField destinatario, asunto;
	private VistaBandeja vb;
	private JTextArea redactado;
	private JButton btnEnviarCorreo, btnDescartar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Redactado frame = new Redactado(null);
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
	public Redactado(VistaBandeja vb) {
		this.vb = vb;
		setTitle("Redactar correo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 500, 450, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnEnviarCorreo = new JButton("Enviar correo");
		btnEnviarCorreo.setBounds(10, 228, 428, 23);
		contentPane.add(btnEnviarCorreo);
		
		JLabel lblDestinatario = new JLabel("Destinatario:");
		lblDestinatario.setBounds(10, 11, 101, 14);
		contentPane.add(lblDestinatario);
		
		JLabel lblAsunto = new JLabel("Asunto:");
		lblAsunto.setBounds(10, 36, 101, 14);
		contentPane.add(lblAsunto);
		
		destinatario = new JTextField();
		destinatario.setBounds(119, 9, 319, 20);
		contentPane.add(destinatario);
		destinatario.setColumns(10);
		
		asunto = new JTextField();
		asunto.setBounds(119, 34, 319, 20);
		contentPane.add(asunto);
		asunto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 61, 428, 156);
		contentPane.add(scrollPane);
		
		redactado = new JTextArea();
		scrollPane.setViewportView(redactado);
		
		btnDescartar = new JButton("Descartar");
		btnDescartar.setBounds(10, 263, 428, 23);
		contentPane.add(btnDescartar);
		
		controlador(this);
	}

	private void controlador(VistaRedactado vr) {
		btnEnviarCorreo.addActionListener(new ControladorRedactado(vr));
		btnDescartar.addActionListener(new ControladorRedactado(vr));
		btnEnviarCorreo.setActionCommand(VistaRedactado.ENVIAR);
		btnDescartar.setActionCommand(VistaRedactado.DESCARTAR);
	}

	@Override
	public String getRemitente() {
		return vb.getLectura().getUsuario();
	}

	@Override
	public String getDestinatario() {
		return destinatario.getText();
	}

	@Override
	public String getAsunto() {
		return asunto.getText();
	}
	
	@Override
	public String getRedactado() {
		return redactado.getText();
	}

	@Override
	public String getIp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPuerto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void liberarVentana() {
		dispose();
	}
}
