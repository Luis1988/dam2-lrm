package correo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingConstants;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class Bandeja extends JFrame implements VistaBandeja {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnRedactar, btnSincronizarCorreo, btnExit;
	private JTextArea taCorreo;
	private JScrollPane scrollPane, scrollPane_2;
	private LecturaCorreo lc;
	private JList<String> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bandeja frame = new Bandeja(null);
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
	public Bandeja(LecturaCorreo lc) {
		this.lc = lc;
		setTitle("Bandeja de Correo Electr\u00F3nico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 473, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 27));
		lblCorreo.setBounds(26, 10, 149, 39);
		contentPane.add(lblCorreo);
		
		btnRedactar = new JButton("Redactar");
		btnRedactar.setBounds(10, 61, 178, 23);
		contentPane.add(btnRedactar);
		
		btnSincronizarCorreo = new JButton("Sincronizar correo");
		btnSincronizarCorreo.setBounds(10, 96, 178, 23);
		contentPane.add(btnSincronizarCorreo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 451, 122);
		contentPane.add(scrollPane);
		
		taCorreo = new JTextArea();
		taCorreo.setEditable(false);
		scrollPane.setViewportView(taCorreo);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(209, 10, 252, 144);
		contentPane.add(scrollPane_2);
		
		list = new JList<String>();
		scrollPane_2.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArrayList<String> lista = lc.getCorreos();
		ListaCorreo<String> listaCorreo = new ListaCorreo<String>(lista);
		list.setModel(listaCorreo);
		
		btnExit = new JButton("Salir del Programa");
		btnExit.setBounds(10, 131, 178, 23);
		contentPane.add(btnExit);
		
		addComponentListener(new ControladorVentana(this));
		addWindowStateListener(new ControladorVentana(this));
		
		controlador(this);
	}

	private void controlador(VistaBandeja vb) {
		btnExit.addActionListener(new ControladorBandeja(vb));
		btnSincronizarCorreo.addActionListener(new ControladorBandeja(vb));
		btnRedactar.addActionListener(new ControladorBandeja(vb));
		btnExit.setActionCommand(VistaBandeja.SALIR);
		btnSincronizarCorreo.setActionCommand(VistaBandeja.SINCRONIZAR);
		btnRedactar.setActionCommand(VistaBandeja.REDACTAR);
		list.addListSelectionListener(new ControladorBandeja(vb));
	}

	@Override
	public int getAlturaVentana() {
		return this.getHeight();
	}

	@Override
	public int getAnchuraVentana() {
		return this.getWidth();
	}

	@Override
	public void setTamañoComponentes(int ancho, int alto) {
		scrollPane.setSize(ancho-20, alto-scrollPane_2.getHeight()-30);
		scrollPane_2.setSize(ancho-btnExit.getWidth()-40, scrollPane_2.getHeight());
	}

	@Override
	public LecturaCorreo getLectura() {
		return lc;
	}

	@Override
	public void actualizaLista(ArrayList<String> correos) {
		ListaCorreo<String> listaCorreo = new ListaCorreo<String>(correos);
		list.setModel(listaCorreo);
	}

	@Override
	public JList<String> getList() {
		return list;
	}

	@Override
	public void setCorreoLeido(String s) {
		taCorreo.setText(s);	
	}
}
