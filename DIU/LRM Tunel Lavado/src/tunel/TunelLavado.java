package tunel;

import java.util.Random;

import utiles.Queue;

public class TunelLavado {
	
	/**
	 * Cola de espera de coches
	 */
	private Queue colaEspera;
	/**
	 * N�mero de coches servidor
	 */
	private int numeroCoches;
	/**
	 * Tiempo medio de espera de los coches que han 
	 * pasado por el t�nel
	 */
	private double mediaEspera;
	/**
	 * Tiempo l�mite de la simulaci�n
	 */
	private int tiempoLimite;
	/**
	 * Tiempo estimado de servicio
	 * para cada coche
	 */
	private int tiempoServicio;
	/**
	 * Probabilidad de llegada de 1 coche
	 */
	private double probLlegada;
	/**
	 * Controla si ha terminado la simulaci�n. En caso 
	 * contrario, la ejecuci�n de ciertos m�todos provocar� 
	 * la elevaci�n de la excepci�n 
	 * <code>NoSimulacionExcepcion</code>
	 */
	private boolean simulado;
	/**
	 * Generador de n�mero aleatorios
	 */
	private double rand;
	
	/**
	 * Crea un objeto de la clase,
	 * asignando los par�metros en los atributos asociados,
	 * e inicializando adecuadamente los dem�s atributos
	 * @param tiempoLimite
	 * @param tiempoServicio
	 * @param probLlegada
	 */
	public TunelLavado(int tiempoLimite, int tiempoServicio, 
			double probLlegada){
		this.tiempoLimite = tiempoLimite;
		this.tiempoServicio = tiempoServicio;
		this.probLlegada = probLlegada;
		colaEspera = new ColaCoches();
		numeroCoches = colaEspera.size();
		mediaEspera = (tiempoLimite+tiempoServicio)/numeroCoches;
		simulado = true;
		rand = Math.random();
		probLlegada = rand;
	}

}
