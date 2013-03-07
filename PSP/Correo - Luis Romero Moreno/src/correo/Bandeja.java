package correo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Color;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
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
					Bandeja frame = new Bandeja("aaa", "aaa");
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
	public Bandeja(String usuario, String password) {
		setTitle("Bandeja de Correo Electr\u00F3nico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCorreo.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 27));
		lblCorreo.setBounds(10, 11, 149, 39);
		contentPane.add(lblCorreo);
		
		JButton btnRedactar = new JButton("Redactar");
		btnRedactar.setBounds(10, 61, 149, 23);
		contentPane.add(btnRedactar);
		
		JButton btnSincronizarCorreo = new JButton("Sincronizar correo");
		btnSincronizarCorreo.setBounds(10, 95, 149, 23);
		contentPane.add(btnSincronizarCorreo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 129, 414, 122);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(169, 11, 252, 107);
		contentPane.add(scrollPane_2);
		
		JList<String> list = new JList<String>();
		scrollPane_2.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Hola", "Hola", "Hola"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
	}
}
