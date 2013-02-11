package ejemplosOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

import com.mysql.jdbc.CallableStatement;

public class Ejemplo7 {

	public static void main (String args [])
			throws SQLException, ClassNotFoundException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		String url = "jdbc:oracle:thin:@localhost:1521:datoslrm";
		try {
			String url1 = System.getProperty("JDBC_URL");
			if (url1 != null)
				url = url1;
		} catch (Exception e) {
			// Si alguna excepción se ignora y se usa la definida por defecto
		}
		// Conexión a la base de datos
		Connection conn =
				DriverManager.getConnection (url, "scott", "tiger");
		// Crea los procedimientos almacenados
		inicializarproc (conn);
		// llamada a un procedimiento sin parámetros
		{
			java.sql.CallableStatement sinparametros = conn.prepareCall ("begin sinparametros; end;");
			sinparametros.execute ();
			System.out.println("\nCafes después de llamar a sinparametros "
					+ "insertando Solo de máquina 101\n");
			verTabla (conn);
			sinparametros.close();
		}
		// llamada a un procedimiento con un parámetro
		{
			java.sql.CallableStatement procin = conn.prepareCall ("begin procin (?, ?); end;");
			procin.setString (1, "Cortado");
			procin.setInt (2, 202);
			procin.execute ();
			System.out.println("\ntabla cafes después de llamar a procin--"
					+ "Cortado 202\n");
			verTabla (conn);
			procin.close();
		}
		// llamada a un procedimiento con un parametro OUT
		{
			java.sql.CallableStatement procout = conn.prepareCall ("begin procout (?, ?); end;");
			procout.registerOutParameter (1, Types.CHAR);
			procout.registerOutParameter (2, Types.INTEGER);
			procout.execute ();
			System.out.println ("\nEl argumento Out en procout es:\n\t" +
					procout.getString (1) + " " + procout.getInt (2));
			procout.close();
		}
		// Cerrar la conexion
		conn.close();
	}
	// Ver el contenido de la tabla
	static void verTabla (Connection conn)
			throws SQLException
			{
		Statement stmt = conn.createStatement ();
		ResultSet rset = stmt.executeQuery ("select cafe_nombre, prov_id from cafes");
		while (rset.next ())
			System.out.println (rset.getString(1) + " " + rset.getInt(2));
		rset.close();
		stmt.close();
			}
	// Crea los procedimientos almacenados en la base de datos
	static void inicializarproc (Connection conn)
			throws SQLException
			{
		Statement stmt = conn.createStatement ();
		try { stmt.execute ("delete from cafes where prov_id > 200"); } catch (SQLException e) { }
		stmt.execute ("create or replace procedure sinparametros is " +
				"begin insert into cafes values ('Solo de máquina', 201, 5,0,0); end;");
		stmt.execute ("create or replace procedure procin (x char, y number) is " +
				"begin insert into cafes(cafe_nombre, prov_id) values (x, y); end;");
		stmt.execute ("create or replace procedure procout (x out char, y out number) is " +
				"begin x := 'Manchado'; y := 203; end;");
		stmt.close();
	}
}
