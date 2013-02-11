import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class FrameAddPerson extends JFrame{

	private Persona p;
	private JTextField txtNombreApellido, txtDir, txtLoc, txtTel;
	public JTextField getTxtDir() {
		return txtDir;
	}

	public void setTxtDir(JTextField txtDir) {
		this.txtDir = txtDir;
	}

	public JTextField getTxtLoc() {
		return txtLoc;
	}

	public void setTxtLoc(JTextField txtLoc) {
		this.txtLoc = txtLoc;
	}

	public JTextField getTxtTel() {
		return txtTel;
	}

	public void setTxtTel(JTextField txtTel) {
		this.txtTel = txtTel;
	}

	public JTextField getTxtNombreApellido() {
		return txtNombreApellido;
	}
	

	public void setTxtNombreApellido(JTextField txtNombreApellido) {
		this.txtNombreApellido = txtNombreApellido;
	}


	private JLabel lblNombreApellido, lblDir, lblLoc, lblTel;
	private JButton btnAgregar;
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}


	private GUI gui;
	
	
	public FrameAddPerson(GUI gui){
		super("Agregar Persona");
		this.gui=gui;
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLayout(new FlowLayout());
		this.setSize(400,200);
		this.setComponents();
		this.setVisible(true);
				
	}
	
	public void setComponents(){
		lblNombreApellido= new JLabel("Introduzca Nombre y Apellido");
		this.add(lblNombreApellido);
		txtNombreApellido = new JTextField(15);
		this.add(txtNombreApellido);
		lblDir = new JLabel("Introduzca Dirección");
		this.add(lblDir);
		txtDir = new JTextField(15);
		this.add(txtDir);
		lblLoc = new JLabel ("Introduzca Localidad");
		this.add(lblLoc);
		txtLoc = new JTextField(15);
		this.add(txtLoc);
		lblTel = new JLabel ("Introduzca teléfono");
		this.add(lblTel);
		txtTel= new JTextField(15);
		this.add(txtTel);
		btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(gui);
		this.add(btnAgregar);
		
	}
	
	
		

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
