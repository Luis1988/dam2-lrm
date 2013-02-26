package correo;

public interface VistaCorreo {

	public static final String ACEPTAR = "ACEPTAR";
	public static final String CANCELAR = "CANCELAR";
	
	public String getUsuario();
	public String getPassword();
	public void setVisibilidad();

}
