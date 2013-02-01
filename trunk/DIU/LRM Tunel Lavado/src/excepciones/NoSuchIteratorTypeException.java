package excepciones;

/**
 * <b>NoSuchIteratorTypeException</b><br>
 * Fecha de creación 28/12/2012
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Exceptiones
 * @version 1.0
 */
public class NoSuchIteratorTypeException extends Exception {

	/**
	 * Serie predeterminada de la excepción
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor vacío
	 */
	public NoSuchIteratorTypeException(){
		super();
	}
	
	/**
	 * Constructor con un parámetro
	 * @param mensaje String que contiene el mensaje de error
	 */
	public NoSuchIteratorTypeException(String mensaje){
		super(mensaje);
	}

}
