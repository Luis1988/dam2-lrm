package utiles;

/**
 * <b>Iterator</b><br>
 * Interfaz que sirve para describir los recorridos sobre los agregados<br>
 * Fecha de creación 28/12/2012
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Utilidades
 * @version 1.0
 */
public interface Iterator {
	/**
	 * La siguiente iteración del objeto
	 * @return Object Devuelve el siguiente objeto correspondiente en la iteración.
	 */
	public Object next();
	/**
	 * Comprueba si hay más iteraciones en la lista
	 * @return boolean Devuelve <code>true</code> si hay más elementos en la iteración.
	 */
	public boolean hasNext();

}
