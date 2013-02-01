package mvc;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * PanelCalculadora
 * Creado el 12/01/2013
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @version 1.1
 * @category Panel
 */
public class PanelCalculadora extends JFrame implements VistaCalculadora{
	
	/**
	 * Serie del panel 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Panel principal de la calculadora
	 */
	private JPanel panel;
	/**
	 * Pantalla de la calculadora
	 */
	private JTextField pantalla;
	/**
	 * Parámetros booleanos que controlarán posibles errores y operaciones dentro de la calculadora
	 */
	private boolean op, decimal, errDecimal;
	/**
	 * Operación llevada a cabo
	 */
	private String operacion;
	/**
	 * Parámetro que ayudará a realizar las operaciones
	 */
	private double aux;
	/**
	 * Botones numéricos
	 */
	private JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnDecimal;
	/**
	 * Botones de las operaciones
	 */
	private JButton btnSuma, btnResta, btnMultiplica, btnDivide, btnModulo, btnSimbolo, btnIgual;
	
	/**
	 * Constructor principal de la calculadora que hará funcionar esta
	 */
	public PanelCalculadora(){
		this.setBounds(250, 250, 290, 310);
		this.setTitle("Calculadora Java - Luis Romero Moreno");
		this.setResizable(false);
		
		btn0 = new JButton("0"); btn1 = new JButton("1"); btn2 = new JButton("2");
		btn3 = new JButton("3"); btn4 = new JButton("4"); btn5 = new JButton("5");
		btn6 = new JButton("6"); btn7 = new JButton("7"); btn8 = new JButton("8");
		btn9 = new JButton("9");
		
		btnSuma = new JButton("+"); btnResta = new JButton("-"); btnMultiplica = new JButton("*");
		btnDivide = new JButton("/"); btnDecimal = new JButton("."); btnModulo = new JButton("%");
		btnSimbolo = new JButton("+/-"); btnIgual = new JButton("=");
		
		btn0.setFont(new Font("SERIF", Font.BOLD, 20)); btn1.setFont(new Font("SERIF", Font.BOLD, 20));
		btn2.setFont(new Font("SERIF", Font.BOLD, 20));	btn3.setFont(new Font("SERIF", Font.BOLD, 20));
		btn4.setFont(new Font("SERIF", Font.BOLD, 20)); btn5.setFont(new Font("SERIF", Font.BOLD, 20));
		btn6.setFont(new Font("SERIF", Font.BOLD, 20)); btn7.setFont(new Font("SERIF", Font.BOLD, 20));
		btn8.setFont(new Font("SERIF", Font.BOLD, 20)); btn9.setFont(new Font("SERIF", Font.BOLD, 20));
		
		btnSuma.setFont(new Font("Arial", Font.BOLD, 22));
		btnSuma.setBackground(Color.YELLOW);
		btnSuma.setForeground(Color.RED);
		btnResta.setFont(new Font("Arial", Font.BOLD, 22));
		btnResta.setBackground(Color.YELLOW);
		btnResta.setForeground(Color.RED);
		btnMultiplica.setFont(new Font("Arial", Font.BOLD, 22));
		btnMultiplica.setBackground(Color.YELLOW);
		btnMultiplica.setForeground(Color.RED);
		btnDivide.setFont(new Font("Arial", Font.BOLD, 22));
		btnDivide.setBackground(Color.YELLOW);
		btnDivide.setForeground(Color.RED);
		btnDecimal.setFont(new Font("Arial", Font.BOLD, 22));
		btnDecimal.setBackground(Color.YELLOW);
		btnDecimal.setForeground(Color.RED);
		btnModulo.setFont(new Font("Arial", Font.BOLD, 22));
		btnModulo.setBackground(Color.YELLOW);
		btnModulo.setForeground(Color.RED);
		btnSimbolo.setFont(new Font("Arial", Font.BOLD, 22));
		btnSimbolo.setBackground(Color.YELLOW);
		btnSimbolo.setForeground(Color.RED);
		btnIgual.setFont(new Font("Arial", Font.BOLD, 22));
		btnIgual.setBackground(Color.YELLOW);
		btnIgual.setForeground(Color.RED);
		
		pantalla = new JTextField(25);
		pantalla.setEditable(false);
		pantalla.setText("0");
		pantalla.setHorizontalAlignment(JTextField.RIGHT);
		pantalla.setFont(new Font("SERIF", Font.BOLD, 20));
		pantalla.setForeground(Color.BLACK);
		panel = new JPanel(null);
		
		pantalla.setBounds(30, 10, 225, 25); panel.add(pantalla);
		
		btn0.setBounds(20, 190, 95, 45); panel.add(btn0);
		btn1.setBounds(20, 140, 45, 45); panel.add(btn1);
		btn2.setBounds(70, 140, 45, 45); panel.add(btn2);
		btn3.setBounds(120, 140, 45, 45); panel.add(btn3);
		btn4.setBounds(20, 90, 45, 45); panel.add(btn4);
		btn5.setBounds(70, 90, 45, 45); panel.add(btn5);
		btn6.setBounds(120, 90, 45, 45); panel.add(btn6);
		btn7.setBounds(20, 40, 45, 45); panel.add(btn7);
		btn8.setBounds(70, 40, 45, 45); panel.add(btn8);
		btn9.setBounds(120, 40, 45, 45); panel.add(btn9);
		
		btnSuma.setBounds(170, 40, 45, 45); panel.add(btnSuma);
		btnSuma.setMargin(new Insets(0,0,0,0));
		btnResta.setBounds(170, 90, 45, 45); panel.add(btnResta);
		btnMultiplica.setBounds(170, 140, 45, 45); panel.add(btnMultiplica);
		btnDivide.setBounds(170, 190, 45, 45); panel.add(btnDivide);
		btnDecimal.setBounds(120, 190, 45, 45); panel.add(btnDecimal);
		btnModulo.setBounds(220, 40, 45, 45); panel.add(btnModulo);
		btnModulo.setMargin(new Insets(0,0,0,0));
		btnSimbolo.setBounds(220, 90, 45, 45); panel.add(btnSimbolo);
		btnSimbolo.setMargin(new Insets(0,0,0,0));
		btnIgual.setBounds(220, 140, 45, 95); panel.add(btnIgual);
		btnIgual.setMargin(new Insets(0,0,0,0));
		
		op = true;
		aux = 0.0;
		operacion = "";
		decimal = false;
		errDecimal = false;
		
		controladorN(new ControladorNumerico(this));
		controladorF();

		this.add(panel);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}
	
	public void controladorN(ControladorNumerico cn){

		btn0.addActionListener(cn);
		btn1.addActionListener(cn);
		btn2.addActionListener(cn);
		btn3.addActionListener(cn);
		btn4.addActionListener(cn);
		btn5.addActionListener(cn);
		btn6.addActionListener(cn);
		btn7.addActionListener(cn);
		btn8.addActionListener(cn);
		btn9.addActionListener(cn);
		btn0.addKeyListener(cn);
		btn1.addKeyListener(cn);
		btn2.addKeyListener(cn);
		btn3.addKeyListener(cn);
		btn4.addKeyListener(cn);
		btn5.addKeyListener(cn);
		btn6.addKeyListener(cn);
		btn7.addKeyListener(cn);
		btn8.addKeyListener(cn);
		btn9.addKeyListener(cn);
		btnSuma.addKeyListener(cn);
		btnResta.addKeyListener(cn);
		btnDivide.addKeyListener(cn);
		btnMultiplica.addKeyListener(cn);
		btnModulo.addKeyListener(cn);
		btnSimbolo.addKeyListener(cn);
		btnIgual.addKeyListener(cn);
		pantalla.addKeyListener(cn);
		btnDecimal.addActionListener(cn);
		setFocusable(true);
		this.addKeyListener(cn);
		btn0.setActionCommand(VistaCalculadora.BTN0);
		btn1.setActionCommand(VistaCalculadora.BTN1);
		btn2.setActionCommand(VistaCalculadora.BTN2);
		btn3.setActionCommand(VistaCalculadora.BTN3);
		btn4.setActionCommand(VistaCalculadora.BTN4);
		btn5.setActionCommand(VistaCalculadora.BTN5);
		btn6.setActionCommand(VistaCalculadora.BTN6);
		btn7.setActionCommand(VistaCalculadora.BTN7);
		btn8.setActionCommand(VistaCalculadora.BTN8);
		btn9.setActionCommand(VistaCalculadora.BTN9);
		btnDecimal.setActionCommand(VistaCalculadora.DECIMAL);
	}
	
	public void controladorF(){
		btnSuma.addActionListener(new ControladorFuncion(this, VistaCalculadora.SUMAR));
		btnResta.addActionListener(new ControladorFuncion(this, VistaCalculadora.RESTAR));
		btnMultiplica.addActionListener(new ControladorFuncion(this, VistaCalculadora.MULTIPLICAR));
		btnDivide.addActionListener(new ControladorFuncion(this, VistaCalculadora.DIVIDIR));
		btnModulo.addActionListener(new ControladorFuncion(this, VistaCalculadora.MODULO));
		btnSimbolo.addActionListener(new ControladorFuncion(this, VistaCalculadora.SIGNO));
		btnIgual.addActionListener(new ControladorFuncion(this, VistaCalculadora.IGUAL));
	}

	@Override
	public void setPantalla(String num) {
		pantalla.setText(num);
		
	}

	@Override
	public JTextField getPantalla() {
		return pantalla;
	}

	@Override
	public boolean getOp() {
		return op;
	}

	@Override
	public double getAux() {
		return aux;
	}

	@Override
	public String getOperacion() {
		return operacion;
	}

	@Override
	public boolean getDecimal() {
		return decimal;
	}

	@Override
	public boolean getErrDecimal() {
		return errDecimal;
	}

	@Override
	public void setOp(boolean op) {
		this.op = op;
	}

	@Override
	public void setAux(double aux) {
		this.aux = aux;
	}

	@Override
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	@Override
	public void setDecimal(boolean decimal) {
		this.decimal = decimal;
	}

	@Override
	public void setErrDecimal(boolean errDecimal) {
		this.errDecimal = errDecimal;
	}

	@Override
	public JPanel getPanel() {
		return panel;
	}

}
