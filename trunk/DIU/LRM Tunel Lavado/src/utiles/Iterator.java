package utiles;

/**
 * <b>Iterator</b><br>
 * Interfaz que sirve para describir los recorridos sobre los agregados<br>
 * Fecha de creaci�n 28/12/2012
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Utilidades
 * @version 1.0
 */
public interface Iterator {
	/**
	 * La siguiente iteraci�n del objeto
	 * @return Object Devuelve el siguiente objeto correspondiente en la iteraci�n.
	 */
	public Object next();
	/**
	 * Comprueba si hay m�s iteraciones en la lista
	 * @return boolean Devuelve <code>true</code> si hay m�s elementos en la iteraci�n.
	 */
	public boolean hasNext();

}
