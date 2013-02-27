package prueba;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class AcercaDe extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JLabel foto1, lblAutor;
	
	public AcercaDe() {
		this.setTitle("Acerca del Editor de Texto");
		getContentPane().setLayout(null);
		this.setBounds(200,200,300,300);
		this.setResizable(false);
		panel = new JPanel(null);
		panel.setBounds(0, 0, 294, 268);
		
		foto1 = new JLabel();
		foto1.setBounds(10, 10, 73, 76);
		imprimeFoto("/img/ic_bloc.png");
		lblAutor = new JLabel("<html><b>Autor: </b>Luis Romero Moreno</html>");
		lblAutor.setHorizontalAlignment(SwingConstants.LEFT);
		lblAutor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblAutor.setBounds(87, 10, 200, 20);
		panel.add(foto1);
		panel.add(lblAutor);
		
		getContentPane().add(panel);
		this.setVisible(true);
	}
	
	public void imprimeFoto(String ruta) {
		ImageIcon fot = new ImageIcon(AcercaDe.class.getResource(ruta));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(foto1.getWidth(), 
				foto1.getHeight(), Image.SCALE_DEFAULT));
		foto1.setIcon(icono);
	}
}
