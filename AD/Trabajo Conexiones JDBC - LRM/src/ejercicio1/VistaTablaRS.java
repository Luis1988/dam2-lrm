package ejercicio1;

import java.sql.SQLException;

public interface VistaTablaRS {
	
	public static final String SELECT = "SELECT";
	
	public String getTabla();
	public void muestraError(SQLException e);
	public void escribeTabla(String s);

}
