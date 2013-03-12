package agenciaLRM.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import agenciaLRM.beans.Vuelos;

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
			System.out.println("No se puede conectar a la DB: " + e.getMessage());
		}
		return conn;
	}
	public void putConnection(Connection conn) {
		if (conn != null) {
			try { conn.close(); }
			catch (SQLException e) { }
		}
	}
	
	// Operaciones con la búsqueda
	
	public ArrayList<Vuelos> busquedaVuelos(DataManager dataManager, String origen, 
			String destino, String fechaSalida, String num, String orden) {
		return AgenciaBD.buscaVuelos(dataManager, origen, destino, fechaSalida, num, orden);
	}
	
	public ArrayList<Vuelos> busquedaVuelosVuelta(DataManager dataManager, String destino,
			String origen, String fechaLlegada, String num, String orden) {
		return AgenciaBD.buscaVuelos(dataManager, destino, origen, fechaLlegada, num, orden);
	}

}