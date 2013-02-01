package mvc;

import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * VistaCalculadora
 * Creado el 12/01/2013
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Vista
 * @version 1.1
 */
public interface VistaCalculadora {
	
	public static final String SUMAR = "SUMAR";
	public static final String RESTAR = "RESTAR";
	public static final String MULTIPLICAR = "MULTIPLICAR";
	public static final String DIVIDIR = "DIVIDIR";
	public static final String MODULO = "MODULO";
	public static final String SIGNO = "SIGNO";
	public static final String IGUAL = "IGUAL";
	
	public static final String BTN0 = "0";
	public static final String BTN1 = "1";
	public static final String BTN2 = "2";
	public static final String BTN3 = "3";
	public static final String BTN4 = "4";
	public static final String BTN5 = "5";
	public static final String BTN6 = "6";
	public static final String BTN7 = "7";
	public static final String BTN8 = "8";
	public static final String BTN9 = "9";
	public static final String DECIMAL = "DECIMAL";
	
	/**
	 * Obtenemos el contenido de la pantalla
	 * @return JTextField con el contenido de la pantalla
	 */
	public JTextField getPantalla();
	/**
	 * Si se está llevando a cabo alguna operación
	 * @return boolean con información de operación en curso
	 */
	public boolean getOp();
	/**
	 * Valor auxiliar utilizado para realizar operaciones futuras
	 * @return double con el valor que utilizaremos
	 */
	public double getAux();
	/**
	 * La operación que va a realizarse
	 * @return String con el nombre de la operacion
	 */
	public String getOperacion();
	/**
	 * Controlamos el punto decimal
	 * @return boolean que controla el punto decimal
	 */
	public boolean getDecimal();
	/** 
	 * Controlamos los errores de los resultados que acaban en .0
	 * @return boolean que controla el error del .0
	 */
	public boolean getErrDecimal();
	/**
	 * Panel que utilizaremos en la calculadora
	 * @return JPanel que utilizaremos
	 */
	public JPanel getPanel();
	
	/**
	 * Modificador de pantalla
	 * @param num String valor con el que modificaremos la pantalla
	 */
	public void setPantalla(String num);
	/**
	 * Para establecer el control de operación
	 * @param op boolean con el control de operación
	 */
	public void setOp(boolean op);
	/**
	 * Modificador del valor auxiliar
	 * @param aux double con el valor a modificar el auxiliar
	 */
	public void setAux(double aux);
	/**
	 * Modificador del tipo de operación que se va a llevar a cabo
	 * @param operacion String con el valor de la operación
	 */
	public void setOperacion(String operacion);
	/**
	 * Para establecer el control de decimales
	 * @param decimal boolean con el control de decimal
	 */
	public void setDecimal(boolean decimal);
	/**
	 * Para controlar el error de .0
	 * @param errDecimal boolean con el control de .0
	 */
	public void setErrDecimal(boolean errDecimal);

}
