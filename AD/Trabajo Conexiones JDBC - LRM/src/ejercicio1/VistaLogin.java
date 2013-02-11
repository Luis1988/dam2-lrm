package ejercicio1;

public interface VistaLogin {
	
	public static final String ACEPTAR = "ACEPTAR";
	public static final String CANCELAR = "CANCELAR";
	
	public String getUsuario();
	public String getPass();
	public void muestraError(Exception e);
	public void mostrarLogin(boolean flag);

}
