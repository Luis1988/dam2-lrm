package utiles;

/**
 * <b>Queue</b><br>
 * Se trata de una secuencia que se comporta como una cola de objetos, es decir, el orden de
 * extracción de objetos se corresponde con el de inserción.<br>
 * Fecha de creación 28/12/2012
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Utilidades
 * @version 1.0
 */
public interface Queue extends Sequence{
	/**
	 * Añade el objecto <code>x</code> por el final de la cola.
	 */
	public void add(Object x);
	/**
	 * Elimina un objeto del frente de la cola, devolviéndolo como resultado. Si la cola está vacía eleva la
	 * excepción <code>NoSuchElementException</code>.
	 */
	public Object remove();
	/**
	 * Consulta el objeto situado en el frente de la cola. Si ésta está vacía eleva la excepción
	 * <code>NoSuchElementException</code>.
	 */
	public Object get();

}
