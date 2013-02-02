package examenAntiguo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDAlumnos {

	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	private String[] tablas;

	public BDAlumnos() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conectar();
	}

	public void conectar() throws SQLException {
		conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:datoslrm", "alumno", "alumno");
		stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE);
		System.out.println("Conexión realizada con éxito.\n");
		tablas = tablas();
	}

	public String[] tablas() throws SQLException {
		rs = stmt.executeQuery("SELECT TABLE_NAME FROM USER_TABLES");
		ultimo();
		String[] res = new String[rs.getRow()];
		primero();
		System.out.println("Tablas de la base de datos:");
		for(int i = 0; rs.next(); i++){
			System.out.println(rs.getString(1));
			res[i] = rs.getString(1);
		}
		return res;
	}

	public ResultSet obtenerTabla(String nomTabla) 
			throws SQLException {
		rs = stmt.executeQuery("SELECT * FROM "+nomTabla);
		return stmt.executeQuery("SELECT * FROM "+nomTabla);
	}

	public ResultSet buscarFilaEnAlumnos(String apellido, int op) 
			throws SQLException {
		String sentencia = "SELECT * FROM ALUMNOS WHERE APELLIDO LIKE ";
		ResultSet res = null;
		switch(op){
		case 0:
			res = stmt.executeQuery(sentencia+"'"+apellido+"%'");
			break;
		case 1:
			res = stmt.executeQuery(sentencia+"'%"+apellido+"%'");
			break;
		}
		return res;
	}

	public void insertarFilasEnAlumnos(int id_alum, String apellido, 
			String nombre, int curso, int titulacion) throws SQLException {
		rs = obtenerTabla("ALUMNOS");
		rs.moveToInsertRow();
		rs.updateInt(1, id_alum);
		rs.updateString(2, apellido);
		rs.updateString(3, nombre);
		rs.updateInt(4, curso);
		rs.updateInt(5, titulacion);
		rs.insertRow();
	}

	public void borrarFilaEnAlumnos(int id_alumno) throws SQLException {
		stmt.executeUpdate("DELETE FROM ALUMNOS WHERE ID_ALUMNO = "+id_alumno);
	}

	public void mostrarTabla(String nom_tabla) throws SQLException {
		rs = obtenerTabla(nom_tabla);
		int numCol = rs.getMetaData().getColumnCount();
		primero();
		while(rs.next()){
			for(int i = 1; i < numCol; i++){
				System.out.print(rs.getObject(i)+" ");
			}
			System.out.println();
		}
	}

	public void mostrarFilasDeAlumnos(String apellidos, int op) throws SQLException {
		rs = buscarFilaEnAlumnos(apellidos, op);
		int numCol = rs.getMetaData().getColumnCount();
		primero();
		while(rs.next()){
			for(int i = 1; i < numCol; i++){
				System.out.print(rs.getObject(i)+" ");
			}
			System.out.println();
		}
	}

	public void mostrarFilaActual() throws SQLException {
		int numCol = rs.getMetaData().getColumnCount();
		for(int i = 1; i <= numCol; i++)
			System.out.print(rs.getObject(i)+" ");
		System.out.println();
	}

	public void siguiente() throws SQLException {
		if(!rs.isLast())
			rs.next();
	}

	public void anterior() throws SQLException {
		if(!rs.isFirst())
			rs.previous();
	}

	public void primero() throws SQLException {
		rs.beforeFirst();
	}	

	public void ultimo() throws SQLException {
		rs.last();
	}

	public void cerrarConexion() throws SQLException {
		rs.close();
		stmt.close();
		conn.close();
	}

}
