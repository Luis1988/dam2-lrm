package agenciaLRM.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import agenciaLRM.beans.Vuelos;

public class AgenciaBD {

	public static ArrayList<Vuelos> buscaVuelos(DataManager dataManager, String origen, String destino, 
			String fechaSalida, String num, String orden) {
		ArrayList<Vuelos> res = new ArrayList<Vuelos>();
		if(origen.length() > 3)
			origen = getCodigoAeropuertoPorCiudad(dataManager, origen);
		if(destino.length() > 3)
			destino = getCodigoAeropuertoPorCiudad(dataManager, destino);
		Connection conn = dataManager.getConnection();
		try {
			Statement stmt = conn.createStatement();
			try {
				String sentencia = "SELECT * FROM VUELOS WHERE ORIGEN LIKE '"+origen+"' AND "+
						"DESTINO LIKE '"+destino+"' AND FECHA_SALIDA LIKE TO_DATE('"+fechaSalida+
						"','DD/MM/YY') AND PLAZAS_LIBRES >= "+
						num+" ORDER BY "+orden;
				ResultSet rs = stmt.executeQuery(sentencia);
				while(rs.next()) {
					Vuelos v = new Vuelos();
					v.setCodigo(rs.getInt(1));
					v.setOrigen(rs.getString(2));
					v.setDestino(rs.getString(3));
					v.setCodAero(rs.getString(4));
					v.setFechaSalida(rs.getDate(5));
					v.setHoraSalida(rs.getTime(6));
					v.setFechaLlegada(rs.getDate(7));
					v.setHoraLlegada(rs.getTime(8));
					v.setPlazasTotales(rs.getInt(9));
					v.setPlazasLibres(rs.getInt(10));
					v.setPrecio(rs.getInt(11));
					res.add(v);
				}
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataManager.putConnection(conn);
		}
		return res;
	}
	
	public static String getCodigoAeropuertoPorCiudad(DataManager dataManager, String ciudad) {
		String res = "";
		Connection conn = dataManager.getConnection();
		try {
			Statement stmt = conn.createStatement();
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM AEROPUERTOS WHERE CIUDAD_AEROPUERTOS "+
						"LIKE '"+ciudad+"'");
				rs.next();
				res = rs.getString(1);
				rs.close();
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				stmt.close();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			dataManager.putConnection(conn);
		}
		return res;
	}

}
