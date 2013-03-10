package colores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataManager {
	private String dbURL = "";
	private String dbUsuario = "";
	private String dbPassword = "";

	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	public String getDbURL() {
		return dbURL;
	}

	public void setDbUsuario(String dbUserName) {
		this.dbUsuario = dbUserName;
	}
	public String getDbUsuario() {
		return dbUsuario;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	public String getDbPassword() {
		return dbPassword;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(getDbURL(), getDbUsuario(),
					getDbPassword());
		}
		catch (SQLException e) {
		}
		return conn;
	}
	public void putConnection(Connection conn, VistaColores vc) {
		if (conn != null) {
			try { conn.close(); }
			catch (SQLException e) { 
				vc.setConexion("Fallo en la conexión");
			}
		}
	}

}
