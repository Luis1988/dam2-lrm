package tunel;

import java.util.Random;

import utiles.Queue;

public class TunelLavado {
	
	/**
	 * Cola de espera de coches
	 */
	private Queue colaEspera;
	/**
	 * Número de coches servidor
	 */
	private int numeroCoches;
	/**
	 * Tiempo medio de espera de los coches que han 
	 * pasado por el túnel
	 */
	private double mediaEspera;
	/**
	 * Tiempo límite de la simulación
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
	 * Controla si ha terminado la simulación. En caso 
	 * contrario, la ejecución de ciertos métodos provocará 
	 * la elevación de la excepción 
	 * <code>NoSimulacionExcepcion</code>
	 */
	private boolean simulado;
	/**
	 * Generador de número aleatorios
	 */
	private double rand;
	
	/**
	 * Crea un objeto de la clase,
	 * asignando los parámetros en los atributos asociados,
	 * e inicializando adecuadamente los demás atributos
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
