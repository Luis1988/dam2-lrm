package utiles;

/**
 * <b>Sequence</b><br>
 * Representa la abstracci�n de aquellos tipos de datos que tienen una estructura esencial en los elementos que agrega.<br>
 * Fecha de creaci�n 28/12/2012
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Utilidades
 * @version 1.0
 */
public interface Sequence extends Aggregate{
	/**
	 * @param o A�ade el objeto <code>o</code> en un extremo de la secuencia. Si la secuencia es ordenada, se a�ade en el lugar adecuado.
	 */
	public void add(Object o);
	/**
	 * @return Object Elimina un objeto de un extremo de la secuencia, devolvi�ndolo como resultado. Si la secuencia est� 
	 * vac�a eleva la excepci�n <code>NoSuchElementException</code>.
	 */
	public Object remove();
	/**
	 * @return Object Consulta un objeto de un extremo de la secuencia, devolviendo el objeto como resultado. (Se exige
	 * que para que una implementaci�n de Sequence sea v�lida debe consultar por el mismo extremo por
	 * el que se borren los elementos). Si la secuencia est� vac�a eleva la excepci�n
	 * <code>NoSuchElementException</code>.
	 */
	public Object get();
	
	/**
	 * Devuelve un booleano indicando si los objetos son iguales (en el sentido que indique la operaci�n
	 * <code>equals</code> sobre los objetos) y est�n en la misma posici�n.
	 */
	public boolean equals(Object o);
	/**
	 * Devuelve un <code>String</code> que representa a la secuencia, de forma que los elementos aparecen separados
	 * por comas y encerrada la secuencia entre par�ntesis.
	 */
	public String toString();

}
