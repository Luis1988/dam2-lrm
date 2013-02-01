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
	 * Constructor con un parámetro
	 * @param num double con el valor del número entero
	 */
	public Numero(double num){
		this.num = num;
	}
	
	/**
	 * Constructor con un parámetro
	 * @param num de tipo String
	 */
	public Numero(String num){
		this.num = Double.parseDouble(num);
	}
	
	/**
	 * Método observador
	 * @return double con el valor del número
	 */
	public double getNum(){
		return num;
	}
	
	/**
	 * Método modificador
	 * @param num double con el valor a modificar
	 */
	public void setNum(double num){
		this.num = num;
	}
	
	/**
	 * Método que suma al número
	 * @param aux double con el valor a sumar
	 */
	public void sumar(double aux){
		num+=aux;
	}
	
	/**
	 * Método que resta al número
	 * @param aux double con el valor a restar
	 */
	public void restar(double aux){
		num-=aux;
	}
	
	/**
	 * Método que multiplica al número
	 * @param aux double con el valor a multiplicar
	 */
	public void multiplicar(double aux){
		num*=aux;
	}
	
	/**
	 * Método que divide al número
	 * @param aux double con el valor a dividir
	 */
	public void dividir(double aux){
		num/=aux;
	}
	
	/**
	 * Método que obtiene el resto de divir el número
	 * @param aux double con el valor de la división
	 */
	public void modulo(double aux){
		num%=aux;
	}
	
	/**
	 * Método observador que mostrará el valor por pantalla
	 * @return String con el valor del número en cadena
	 */
	public String toString(){
		return ""+num;
	}

}
