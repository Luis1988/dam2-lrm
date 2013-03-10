package colores;

import javax.swing.ImageIcon;

public interface VistaColores {
	
	public static final String CONEXION = "CONEXION";
	public static final String MOSTRAR = "MOSTRAR";

	public String getUsuario();
	public String getPassword();
	public void setListaColores(String[] listaColores);
	public void setConexion(String resultado);
	public void deshabilitarComponentes(boolean flag);
	public String getComboBox();
	public void setColor(ImageIcon imagen);

}
