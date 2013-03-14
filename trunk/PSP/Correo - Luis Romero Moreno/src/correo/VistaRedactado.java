package correo;

public interface VistaRedactado {
	
	public static final String ENVIAR = "ENVIAR";
	public static final String DESCARTAR = "DESCARTAR";
	
	public String getRemitente();
	public String getDestinatario();
	public String getAsunto();
	public String getRedactado();
	public String getIp();
	public int getPuerto();
	public void liberarVentana();
	public VistaCorreo getVistaCorreo();

}
