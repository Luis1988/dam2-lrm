package ejemplosMySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejemplo1 {
	
	private static String crearCafe = "CREATE TABLE CAFES "+
			"(CAFE_NOMBRE VARCHAR(32), "+
			"PROV_ID INTEGER, "+
			"PRECIO FLOAT, "+
			"VENTAS INTEGER, "+
			"TOTAL INTEGER)";
	
	public static void main(String[] args){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/datoslrm", 
					"root", "usuario");
			Statement stm = conn.createStatement();
			stm.executeUpdate(crearCafe);
			stm.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("--- SQLException Capturada ---/n");
			while(e!=null){
				System.out.println("Mensaje: 	"+e.getMessage());
				System.out.println("Estado: 	"+e.getSQLState());
				System.out.println("ErrorCode: 	"+e.getErrorCode());
				e = e.getNextException();
			}
		}
	}

}
