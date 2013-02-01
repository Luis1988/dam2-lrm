package utiles;

/**
 * <b>Aggregate</b> <br>
 * Cualquier objeto que implemente esta interfaz ser� visto como una colecci�n de objetos <br>
 * Fecha de creaci�n 28/12/2012
 * @author Luis Romero Moreno <a href="luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Utilidades
 * @version 1.0
 */
public interface Aggregate {
	/**
	 * Crea un iterador agregado
	 * @param itor
	 * @return Iterator Devuelve un iterador que va a actuar sobre el agregado, de acuerdo con el <code>String x</code> que se le pasa.
	 * Si <code>x</code> no se corresponde con ning�n iterador de los que se definen para el objeto que implementa esta 
	 * interfaz, se eleva la excepci�n <code>NoSuchTypeException</code>.
	 */
	public Iterator createIterator(String itor);
	/**
	 * Crea un iterador agregado
	 * @return Iterator Devuelve el iterador definido por defecto para el agregado.
	 */
	public Iterator createIterator();
	/**
	 * Muestra el tama�o de la lista de agregados
	 * @return int Devuelve el n�mero de objetos que contiene el agregado
	 */
	public int size();
	/**
	 * Comprueba si una lista de agregados est� vac�a
	 * @return boolean Devuelve un booleano indicando si el agregado est� vac�o
	 */
	public boolean isEmpty();
	/**
	 * Vac�a el agregado
	 */
	public void removeAll();
	
	/**
	 * Comprueba si dos agregados son iguales
	 * @param o Object Objecto que se quiere comparar
	 * @return boolean devuelve un booleano indicando si los dos agregados son iguales.
	 */
	public boolean equals(Object o);
	/**
	 * Comprueba si un agregado ha sido creado por referencia o por copia
	 * @return boolean Devuelve un booleanp indicando si el agregado se cre� por referencia <code>(true)</code> o por copia <code>(false)</code>.
	 */
	public boolean getRef();
	
	/**
	 * Representaci�n del agregado
	 * @return String Devuelve un <code>String</code> que representa el agregado
	 */
	public String toString();

}
