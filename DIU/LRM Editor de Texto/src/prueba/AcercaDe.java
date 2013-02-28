package prueba;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Font;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JButton;

/**
 * Panel que muestra los datos generales de este programa
 * @author Luis Romero Moreno
 * @version v1.7
 */
public class AcercaDe extends JFrame {

	/**
	 * Identificador de la clase
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Panel principal de la clase que contiene al JFrame
	 */
	private JPanel panel;
	/**
	 * Etiquetas que muestran una imagen y los datos del programa
	 */
	private JLabel foto1, lblAutor, lblProfesor, lblCurso;
	/**
	 * Area textual (no editable) que muestra el changelog del
	 * programa
	 */
	private JTextArea areaTexto;
	/**
	 * Barra de desplazamiento que contendrá el área de texto
	 */
	private JScrollPane barraDesplazamiento;
	/**
	 * Botón que liberará de la memoria esta ventana
	 */
	private JButton btnAceptar;
	
	/**
	 * Constructor principal de la clase
	 */
	public AcercaDe() {
		this.setTitle("Acerca del Editor de Texto");
		getContentPane().setLayout(null);
		this.setBounds(200,200,300,267);
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
		
		lblProfesor = new JLabel("<html><b>Profesor: </b>Rafael Reina</html>");
		lblProfesor.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfesor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblProfesor.setBounds(87, 36, 200, 20);
		
		lblCurso = new JLabel("<html><b>Curso: </b>2º de DAM - IES Ramón del Valle-Inclán</html>");
		lblCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurso.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblCurso.setBounds(87, 62, 200, 30);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(99, 210, 89, 23);
		
		barraDesplazamiento = new JScrollPane();
		barraDesplazamiento.setBounds(10, 97, 274, 102);
		
		panel.add(foto1);
		panel.add(lblAutor);
		panel.add(lblProfesor);
		panel.add(lblCurso);
		panel.add(btnAceptar);
		panel.add(barraDesplazamiento);
		
		areaTexto = new JTextArea();
		añadeTexto();
		areaTexto.setEditable(false);
		barraDesplazamiento.setViewportView(areaTexto);
		
		btnAceptar.addActionListener(new ControladorAcercaDe(this));
		
		getContentPane().add(panel);
		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Recoge una foto de una ruta propia del programa, la inserta en la etiqueta 
	 * foto1 y la redimensiona al tamaño de dicha etiqueta
	 * @param ruta String que recoge la ruta del archivo desde donde se accederá a 
	 * la imagen
	 */
	public void imprimeFoto(String ruta) {
		ImageIcon fot = new ImageIcon(AcercaDe.class.getResource(ruta));
		Icon icono = new ImageIcon(fot.getImage().getScaledInstance(foto1.getWidth(), 
				foto1.getHeight(), Image.SCALE_DEFAULT));
		foto1.setIcon(icono);
	}
	
	/**
	 * Lee desde un fichero propio de la aplicación Java (changeog.txt), e inserta 
	 * el contenido en al área de texto de la clase 
	 */
	public void añadeTexto() {
		FileReader fichero;
		try{
			String ruta = AcercaDe.class.getResource("/img/changelog.txt").getFile();
			ruta = ruta.substring(1);
			ruta = ruta.replaceAll("/", "\\\\\\\\");
			ruta = ruta.replaceAll("%20", " ");
			fichero = new FileReader(ruta);
			areaTexto.setText("");
			char[] buffer=new char[256];
			int longitud;
			while((longitud = fichero.read(buffer))!=-1){
				String s = new String(buffer, 0,longitud);
				areaTexto.setText(areaTexto.getText()+s);
			}
			fichero.close();
		}catch(IOException ioe){
			JOptionPane.showMessageDialog(this, "Error al leer el fichero changelog.txt", 
					"Error de lectura", JOptionPane.ERROR_MESSAGE);
		}
		areaTexto.setCaretPosition(0);
	}
}
