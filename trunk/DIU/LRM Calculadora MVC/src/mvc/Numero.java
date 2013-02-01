package mvc;

/**
 * Numero
 * Creado el 12/01/2013
 * @author Luis Romero Moreno <a href="mailto:luisillosevillano1988@gmail.com">luisillosevillano1988@gmail.com</a>
 * @category Modelo
 * @version 1.1
 */

public class Numero{
	
	private double num;
	
	/**
	 * Constructor con un par�metro
	 * @param num double con el valor del n�mero entero
	 */
	public Numero(double num){
		this.num = num;
	}
	
	/**
	 * Constructor con un par�metro
	 * @param num de tipo String
	 */
	public Numero(String num){
		this.num = Double.parseDouble(num);
	}
	
	/**
	 * M�todo observador
	 * @return double con el valor del n�mero
	 */
	public double getNum(){
		return num;
	}
	
	/**
	 * M�todo modificador
	 * @param num double con el valor a modificar
	 */
	public void setNum(double num){
		this.num = num;
	}
	
	/**
	 * M�todo que suma al n�mero
	 * @param aux double con el valor a sumar
	 */
	public void sumar(double aux){
		num+=aux;
	}
	
	/**
	 * M�todo que resta al n�mero
	 * @param aux double con el valor a restar
	 */
	public void restar(double aux){
		num-=aux;
	}
	
	/**
	 * M�todo que multiplica al n�mero
	 * @param aux double con el valor a multiplicar
	 */
	public void multiplicar(double aux){
		num*=aux;
	}
	
	/**
	 * M�todo que divide al n�mero
	 * @param aux double con el valor a dividir
	 */
	public void dividir(double aux){
		num/=aux;
	}
	
	/**
	 * M�todo que obtiene el resto de divir el n�mero
	 * @param aux double con el valor de la divisi�n
	 */
	public void modulo(double aux){
		num%=aux;
	}
	
	/**
	 * M�todo observador que mostrar� el valor por pantalla
	 * @return String con el valor del n�mero en cadena
	 */
	public String toString(){
		return ""+num;
	}

}
