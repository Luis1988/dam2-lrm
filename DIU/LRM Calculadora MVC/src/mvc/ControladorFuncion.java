package mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

/**
 * ControladorFuncion
 * Creado el 12/01/2013
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Controlador
 * @version 1.1
 */
public class ControladorFuncion implements ActionListener {
	
	/**
	 * Vista
	 */
	private VistaCalculadora vista;
	
	/**
	 * Operador
	 */
	private String funcion;
	
	/**
	 * Creamos el controlador a partir de la vista
	 * @param vc vista a controlar
	 * @param funcion operación que llevará a cabo en un primer plano
	 */
	public ControladorFuncion(VistaCalculadora vc, String funcion){
		vista = vc;
		this.funcion = funcion;
	}

	/**
	 * Controlamos el modelo y la vista a tenor de los distintos eventos
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(funcion.equals(VistaCalculadora.IGUAL)){
			calculaFuncion();
		} else if(funcion.equals(VistaCalculadora.SIGNO)){
			vista.setAux(new Numero(vista.getPantalla().getText()).getNum());
			Numero aux2 = new Numero(vista.getAux());
			aux2.multiplicar(-1);
			vista.setAux(aux2.getNum());
			compruebaError();
			if(!vista.getErrDecimal())
				vista.setPantalla(""+vista.getAux());
			vista.setErrDecimal(false);
		} else {
			vista.setOperacion(funcion);
			if((vista.getAux() != 0) && !vista.getOp()){
				calculaFuncion();
			} else {
				vista.setAux(new Double(vista.getPantalla().getText()));
			}
		}
		vista.setOp(true);
	}
	
	/**
	 * Método auxiliar que nos ayudará a calcular las operaciones
	 */
	public void calculaFuncion(){
		if(vista.getOperacion().equals(VistaCalculadora.SUMAR)){
			Numero aux2 = new Numero(vista.getAux());
			aux2.sumar(new Double(vista.getPantalla().getText()));
			vista.setAux(aux2.getNum());
		} else if(vista.getOperacion().equals(VistaCalculadora.RESTAR)){
			Numero aux2 = new Numero(vista.getAux());
			aux2.restar(new Double(vista.getPantalla().getText()));
			vista.setAux(aux2.getNum());
		} else if(vista.getOperacion().equals(VistaCalculadora.DIVIDIR)){
			Numero aux2 = new Numero(vista.getAux());
			aux2.dividir(new Double(vista.getPantalla().getText()));
			vista.setAux(aux2.getNum());
		} else if(vista.getOperacion().equals(VistaCalculadora.MULTIPLICAR)){
			Numero aux2 = new Numero(vista.getAux());
			aux2.multiplicar(new Double(vista.getPantalla().getText()));
			vista.setAux(aux2.getNum());
		} else if(vista.getOperacion().equals(VistaCalculadora.MODULO)){
			Numero aux2 = new Numero(vista.getAux());
			aux2.modulo(new Double(vista.getPantalla().getText()));
			vista.setAux(aux2.getNum());
		}
		compruebaError();
		if(!vista.getErrDecimal())
			vista.setPantalla(""+vista.getAux());
		vista.setErrDecimal(false);
		vista.setOperacion("");
		if(funcion.equals(VistaCalculadora.IGUAL)){
			vista.setAux(0);
		}
	}
	
	/**
	 * Método auxiliar que nos ayudará a controlar los errores en la calculadora
	 */
	public void compruebaError(){
		String respuesta = ""+vista.getAux();
		if(respuesta.equals("Infinity") || respuesta.equals("NaN")){
			JOptionPane.showMessageDialog(vista.getPanel(), "Error, no se puede dividir entre 0", "Error", JOptionPane.ERROR_MESSAGE);
			vista.setAux(0);
			respuesta = ""+vista.getAux();
		}
		if(respuesta.endsWith(".0")){
			vista.setErrDecimal(true);
			respuesta = respuesta.substring(0, respuesta.length()-2);
			vista.setPantalla(""+respuesta);
		}
	}

}
