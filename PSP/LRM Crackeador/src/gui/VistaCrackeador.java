package gui;

public interface VistaCrackeador {
	
	public static final String CRACK = "CRACK";
	public static final String ABORTAR = "ABORTAR";
	
	public boolean isSecuencial();
	public String getFichUsuarios();
	public String getFichPasswords();
	public String getHost();
	public int getPuerto();
	public void setResultado(String res);
	public void habilitaBotones(boolean flag);
	public void setTiempo(long tiempo);

}
