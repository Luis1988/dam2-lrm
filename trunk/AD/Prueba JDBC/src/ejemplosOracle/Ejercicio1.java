package ejemplosOracle;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Ejercicio1 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Ejercicio1(){
		super();
		iniciaVentana();
	}
	
	public void iniciaVentana(){
		this.setSize(new Dimension(300,300));
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new Ejercicio1();
	}

}
