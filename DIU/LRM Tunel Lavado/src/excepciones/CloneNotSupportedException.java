package excepciones;

/**
 * <b>CloneNotSupportedException</b><br>
 * Fecha de creaci�n 28/12/2012
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Exceptiones
 * @version 1.0
 */
public class CloneNotSupportedException extends Exception {

	/**
	 * Serie predeterminada de la excepci�n.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor vac�o
	 */
	public CloneNotSupportedException(){
		super();
	}
	
	/**
	 * Constructor con un par�metro
	 * @param mensaje String que contiene el mensaje de error
	 */
	public CloneNotSupportedException(String mensaje){
		super(mensaje);
	}

}
