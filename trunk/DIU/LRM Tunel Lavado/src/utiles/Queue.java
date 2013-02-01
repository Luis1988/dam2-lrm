package utiles;

/**
 * <b>Queue</b><br>
 * Se trata de una secuencia que se comporta como una cola de objetos, es decir, el orden de
 * extracci�n de objetos se corresponde con el de inserci�n.<br>
 * Fecha de creaci�n 28/12/2012
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Utilidades
 * @version 1.0
 */
public interface Queue extends Sequence{
	/**
	 * A�ade el objecto <code>x</code> por el final de la cola.
	 */
	public void add(Object x);
	/**
	 * Elimina un objeto del frente de la cola, devolvi�ndolo como resultado. Si la cola est� vac�a eleva la
	 * excepci�n <code>NoSuchElementException</code>.
	 */
	public Object remove();
	/**
	 * Consulta el objeto situado en el frente de la cola. Si �sta est� vac�a eleva la excepci�n
	 * <code>NoSuchElementException</code>.
	 */
	public Object get();

}
