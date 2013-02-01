package utiles;

/**
 * <b>Sequence</b><br>
 * Representa la abstracción de aquellos tipos de datos que tienen una estructura esencial en los elementos que agrega.<br>
 * Fecha de creación 28/12/2012
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Utilidades
 * @version 1.0
 */
public interface Sequence extends Aggregate{
	/**
	 * @param o Añade el objeto <code>o</code> en un extremo de la secuencia. Si la secuencia es ordenada, se añade en el lugar adecuado.
	 */
	public void add(Object o);
	/**
	 * @return Object Elimina un objeto de un extremo de la secuencia, devolviéndolo como resultado. Si la secuencia está 
	 * vacía eleva la excepción <code>NoSuchElementException</code>.
	 */
	public Object remove();
	/**
	 * @return Object Consulta un objeto de un extremo de la secuencia, devolviendo el objeto como resultado. (Se exige
	 * que para que una implementación de Sequence sea válida debe consultar por el mismo extremo por
	 * el que se borren los elementos). Si la secuencia está vacía eleva la excepción
	 * <code>NoSuchElementException</code>.
	 */
	public Object get();
	
	/**
	 * Devuelve un booleano indicando si los objetos son iguales (en el sentido que indique la operación
	 * <code>equals</code> sobre los objetos) y están en la misma posición.
	 */
	public boolean equals(Object o);
	/**
	 * Devuelve un <code>String</code> que representa a la secuencia, de forma que los elementos aparecen separados
	 * por comas y encerrada la secuencia entre paréntesis.
	 */
	public String toString();

}
