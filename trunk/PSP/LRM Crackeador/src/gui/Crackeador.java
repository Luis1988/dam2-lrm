package gui;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.Color;

public class Crackeador extends JFrame implements VistaCrackeador {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPuerto;
	private JFileChooser fileChooser;
	private JTextField tfUsuarios, tfPasswords, tfHost, tfTiempo;
	private JCheckBox chckbxSecuencial;
	private JButton btnCrackearFtp, btnAbortar;
	private JTextArea txtResultado;
	private JLabel lblCrackeadorFtp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crackeador frame = new Crackeador();
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
	public Crackeador() {
		setTitle("Crackeador FTP - Luis Romero Moreno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIp = new JLabel("IP:");
		lblIp.setBounds(10, 53, 46, 14);
		contentPane.add(lblIp);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setBounds(10, 78, 46, 14);
		contentPane.add(lblPuerto);
		
		tfPuerto = new JTextField();
		tfPuerto.setBounds(56, 75, 131, 20);
		contentPane.add(tfPuerto);
		tfPuerto.setColumns(10);
		
		JButton btnSeleccionarFicheroUsuarios = new JButton("Seleccionar Usuarios");
		btnSeleccionarFicheroUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = fileChooser.showOpenDialog(getContentPane());
				if(seleccion == JFileChooser.APPROVE_OPTION){
					tfUsuarios.setText(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		btnSeleccionarFicheroUsuarios.setBounds(10, 137, 177, 23);
		contentPane.add(btnSeleccionarFicheroUsuarios);
		
		JButton btnSeleccionarPasswords = new JButton("Seleccionar Passwords");
		btnSeleccionarPasswords.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seleccion = fileChooser.showOpenDialog(getContentPane());
				if(seleccion == JFileChooser.APPROVE_OPTION){
					tfPasswords.setText(fileChooser.getSelectedFile().getAbsolutePath());
				}
			}
		});
		btnSeleccionarPasswords.setBounds(10, 202, 177, 23);
		contentPane.add(btnSeleccionarPasswords);
		
		tfUsuarios = new JTextField();
		tfUsuarios.setEditable(false);
		tfUsuarios.setBounds(10, 106, 177, 20);
		contentPane.add(tfUsuarios);
		tfUsuarios.setColumns(10);
		
		tfPasswords = new JTextField();
		tfPasswords.setEditable(false);
		tfPasswords.setBounds(10, 171, 177, 20);
		contentPane.add(tfPasswords);
		tfPasswords.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(197, 47, 227, 178);
		contentPane.add(scrollPane);
		
		txtResultado = new JTextArea();
		txtResultado.setEditable(false);
		scrollPane.setViewportView(txtResultado);
		
		chckbxSecuencial = new JCheckBox("Secuencial");
		chckbxSecuencial.setBounds(6, 232, 97, 23);
		contentPane.add(chckbxSecuencial);
		
		btnCrackearFtp = new JButton("Crackear FTP");
		btnCrackearFtp.setBounds(140, 232, 112, 23);
		contentPane.add(btnCrackearFtp);
		
		btnAbortar = new JButton("Abortar Operaci\u00F3n");
		btnAbortar.setEnabled(false);
		btnAbortar.setBounds(275, 232, 149, 23);
		contentPane.add(btnAbortar);
		
		tfHost = new JTextField();
		tfHost.setBounds(56, 50, 131, 20);
		contentPane.add(tfHost);
		tfHost.setColumns(10);
		
		tfTiempo = new JTextField();
		tfTiempo.setEditable(false);
		tfTiempo.setBounds(338, 266, 86, 20);
		contentPane.add(tfTiempo);
		tfTiempo.setColumns(10);
		
		JLabel lblTiempoDeEjecucin = new JLabel("Tiempo de ejecuci\u00F3n total:");
		lblTiempoDeEjecucin.setBounds(178, 269, 149, 14);
		contentPane.add(lblTiempoDeEjecucin);
		
		lblCrackeadorFtp = new JLabel("Crackeador FTP");
		lblCrackeadorFtp.setForeground(Color.RED);
		lblCrackeadorFtp.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblCrackeadorFtp.setBounds(127, 8, 159, 28);
		contentPane.add(lblCrackeadorFtp);
		
		fileChooser = new JFileChooser();
		
		controlador(this);

	}

	@Override
	public boolean isSecuencial() {
		return this.chckbxSecuencial.isSelected();
	}
	
	public void controlador(VistaCrackeador vc) {
		btnCrackearFtp.addActionListener(new ControladorCrackeador(vc));
		btnAbortar.addActionListener(new ControladorCrackeador(vc));
		btnCrackearFtp.setActionCommand(VistaCrackeador.CRACK);
		btnAbortar.setActionCommand(VistaCrackeador.ABORTAR);
	}

	@Override
	public String getFichUsuarios() {
		return tfUsuarios.getText();
	}

	@Override
	public String getFichPasswords() {
		return tfPasswords.getText();
	}

	@Override
	public String getHost() {
		return tfHost.getText();
	}

	@Override
	public int getPuerto() {
		return Integer.parseInt(tfPuerto.getText());
	}
	
	public void setTiempo(long tiempo){
		tfTiempo.setText(""+tiempo);
	}

	@Override
	public void setResultado(String res) {
		if(txtResultado.getText().equals("") || txtResultado.getText().equals(null))
			txtResultado.setText(res);
		else
			txtResultado.setText(txtResultado.getText()+"\n"+res);
	}

	@Override
	public void habilitaBotones(boolean flag) {
		chckbxSecuencial.setEnabled(flag);
		btnCrackearFtp.setEnabled(flag);
		btnAbortar.setEnabled(!flag);
	}
}
