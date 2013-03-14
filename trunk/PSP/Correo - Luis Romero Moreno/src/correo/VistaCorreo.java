package correo;

public interface VistaCorreo {

	public static final String ACEPTAR = "ACEPTAR";
	public static final String CANCELAR = "CANCELAR";
	
	public String getUsuario();
	public String getPassword();
	public void setVisibilidad();
	public String getSMTPIP();
	public int getSMTPPUERTO();
	public String getPOP3IP();
	public int getPOP3PUERTO();

}
