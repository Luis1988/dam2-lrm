package eShop.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import eShop.beans.Libro;

public class LibroBD {

	public static ArrayList<Libro> buscarLibros(DataManager dataManager, String clave) {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		Connection conn = dataManager.getConnection();
		try {
			Statement stmt = conn.createStatement();
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS WHERE TITLE LIKE '%"+clave+
						"%' OR AUTHOR LIKE '%"+clave+"%'");
				while(rs.next()) {
					Libro l = new Libro();
					l.setIdLibro(rs.getString(1));
					l.setTitulo(rs.getString(2));					
					l.setAutor(rs.getString(3));
					l.setPrecio(rs.getDouble(4));
					libros.add(l);
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
		return libros;
	}

	public static ArrayList<Libro> getLibrosPorCategoria(DataManager dataManager,
			String idCategoria) {
		ArrayList<Libro> libros = new ArrayList<Libro>();
		Connection conn = dataManager.getConnection();
		try {
			Statement stmt = conn.createStatement();
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS WHERE CATEGORY_ID = "+idCategoria);
				while(rs.next()) {
					Libro l = new Libro();
					l.setIdLibro(rs.getString(1));
					l.setTitulo(rs.getString(2));					
					l.setAutor(rs.getString(3));
					l.setPrecio(rs.getDouble(4));
					libros.add(l);
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
		return libros;
	}

	public static Libro getLibroPorID(DataManager dataManager, String idLibro) {
		Libro l = new Libro();
		Connection conn = dataManager.getConnection();
		try {
			Statement stmt = conn.createStatement();
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM BOOKS WHERE BOOK_ID = "+idLibro);
				while(rs.next()){
					l.setIdLibro(rs.getString(1));
					l.setTitulo(rs.getString(2));					
					l.setAutor(rs.getString(3));
					l.setPrecio(rs.getDouble(4));
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
		return l;
	}

}
