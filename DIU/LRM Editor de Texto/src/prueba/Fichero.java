package prueba;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

/**
 * Modelo del PanelEditor que permite leer y guardar ficheros
 * @author Luis Romero Moreno
 * @version v1.8
 */
public class Fichero {
	
	/**
	 * Atributo con la ruta
	 */
	private String ruta;
	/**
	 * Vista que recoge y edita los atributos propios de su
	 * clase PanelEditor
	 */
	private VistaEditor v;
	
	/**
	 * Constructor principal de la clase
	 * @param v VistaEditor que recoge y edita los atributos
	 * de su clase PanelEditor
	 */
	public Fichero(VistaEditor v) {
		this.v = v;
		ruta = "Untitled";
	}
	
	/**
	 * Método que permite guardar los ficheros en la ruta
	 * especificada por la clase y que modifica el título
	 */
	public void guardar() {
		FileWriter fichero;
		try {
			fichero = new FileWriter(getRuta());
			fichero.write(v.getAreaTexto().getText());
			v.setTitulo(getRuta());
			v.habilitarItemEdicion(false);
			fichero.close();
		} catch (IOException ioe) {
			JOptionPane.showMessageDialog(v.getFrame(), "Error al guardar el fichero", 
					"Error de escritura", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método que permite leer los ficheros en la ruta
	 * especificada por la clase y que modifica el título
	 */
	public void abrir() {
		FileReader fichero;
		try{
			fichero = new FileReader(getRuta());
			v.getAreaTexto().setText("");
			char[] buffer=new char[256];
			int longitud;
			while((longitud = fichero.read(buffer))!=-1){
				String s = new String(buffer, 0,longitud);
				v.getAreaTexto().setText(v.getAreaTexto().getText()+s);
			}
			v.setTitulo(getRuta());
			v.habilitarItemEdicion(false);
			fichero.close();
		}catch(IOException ioe){
			JOptionPane.showMessageDialog(v.getFrame(), "Error al leer el fichero", 
					"Error de lectura", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Método que modifica la ruta escrita
	 * @param fich String con la ruta a modificar
	 */
	public void setFichero(String fich) {
		ruta = fich;
	}
	
	/**
	 * Devuelve la ruya del fichero
	 * @return String con la ruta
	 */
	public String getRuta() {
		return ruta;
	}

}
