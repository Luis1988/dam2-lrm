package correo;

import java.util.ArrayList;

import javax.swing.JList;

public interface VistaBandeja {
	
	public static final String SALIR = "SALIR";
	public static final String REDACTAR = "REDACTAR";
	public static final String SINCRONIZAR = "SINCRONIZAR";
	
	public int getAlturaVentana();
	public int getAnchuraVentana();
	public void setTamañoComponentes(int ancho, int alto);
	public LecturaCorreo getLectura();
	public void actualizaLista(ArrayList<String> correos);
	public JList<String> getList();
	public void setCorreoLeido(String s);

}
