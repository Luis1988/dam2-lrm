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

public class Bandeja extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		
		JButton btnRedactar = new JButton("Redactar");
		btnRedactar.setBounds(10, 61, 178, 23);
		contentPane.add(btnRedactar);
		
		JButton btnSincronizarCorreo = new JButton("Sincronizar correo");
		btnSincronizarCorreo.setBounds(10, 96, 178, 23);
		contentPane.add(btnSincronizarCorreo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 166, 414, 122);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(209, 10, 252, 122);
		contentPane.add(scrollPane_2);
		
		JList<String> list = new JList<String>();
		scrollPane_2.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ArrayList<String> lista = lc.getCorreos();
		ListaCorreo<String> listaCorreo = new ListaCorreo<String>(lista);
		list.setModel(listaCorreo);
		
		JButton btnExit = new JButton("Salir del Programa");
		btnExit.setBounds(10, 131, 178, 23);
		contentPane.add(btnExit);
	}
}
