package tunel;

public class Coche {
	
	/**
	 * Tiempo en que el coche entró en la
	 * cola de espera.
	 */
	private int tiempoLlegada;
	/**
	 * Número identificativo del coche. Se
	 * corresponde con el orden de llegada
	 */
	private int numeroCoche;
	/**
	 * Número total de coches
	 * que han llegado a la cola de espera
	 * (nº de objetos creados de la clase Coche).
	 */
	private static int numeroTotalCoches = 0;
	
	/**
	 * Crea un objeto de la clase
	 * asignando el parámetro al atributo asociado,
	 * y usando el contador de coches para asigna
	 * el número de coche identificativo
	 * @param tiempoLlegada
	 */
	public Coche(int tiempoLlegada){
		this.tiempoLlegada = tiempoLlegada;
		numeroCoche=numeroTotalCoches;
		numeroTotalCoches++;
	}
	
	public int getTiempoLlegada(){
		return tiempoLlegada;
	}
	
	public int getNumeroCoche(){
		return numeroCoche;
	}

}
