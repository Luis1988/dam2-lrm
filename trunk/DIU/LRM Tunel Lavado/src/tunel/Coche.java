package tunel;

public class Coche {
	
	/**
	 * Tiempo en que el coche entr� en la
	 * cola de espera.
	 */
	private int tiempoLlegada;
	/**
	 * N�mero identificativo del coche. Se
	 * corresponde con el orden de llegada
	 */
	private int numeroCoche;
	/**
	 * N�mero total de coches
	 * que han llegado a la cola de espera
	 * (n� de objetos creados de la clase Coche).
	 */
	private static int numeroTotalCoches = 0;
	
	/**
	 * Crea un objeto de la clase
	 * asignando el par�metro al atributo asociado,
	 * y usando el contador de coches para asigna
	 * el n�mero de coche identificativo
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
