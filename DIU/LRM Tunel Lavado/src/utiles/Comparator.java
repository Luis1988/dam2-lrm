package utiles;

/**
 * <b>Comparator</b><br>
 * Es una interfaz que obliga a la clase que la implemente a definir una función de comparación
 * entre sus objetos.
 * Fecha de creación 28/12/2012
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Utilidades
 * @version 1.0
 */
public interface Comparator {
	/**
	 * Compara dos elementos
	 * @param o1 Object Primer objeto a comparar
	 * @param o2 Object Segundo objeto a comparar
	 * @return int Devuelve un número positivo si x es mayor que y, un número negativo si y es mayor que x y cero en
	 * caso contrarios
	 */
	public int compare(Object o1, Object o2);

}
