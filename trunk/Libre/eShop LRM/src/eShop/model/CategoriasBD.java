package eShop.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

import eShop.beans.Categoria;

public class CategoriasBD {

	public static Categoria getCategoriaPorID(DataManager dataManager,
			String idCategoria) {
		Categoria cat = null;
		Connection conn = dataManager.getConnection();
		try {
			Statement stmt = conn.createStatement();
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM CATEGORIES WHERE CATEGORY_ID ="+idCategoria);
				cat = new Categoria(rs.getInt(1), rs.getString(2));
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
		return cat;
	}

	public static Hashtable getTodasCategorias(DataManager dataManager) {
		Hashtable categorias = new Hashtable<String,String>();
		Connection conn = dataManager.getConnection();
		try {
			Statement stmt = conn.createStatement();
			try {
				ResultSet rs = stmt.executeQuery("SELECT * FROM CATEGORIES");
				while(rs.next()) {
					categorias.put(rs.getString(1), rs.getString(2));
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
		return categorias;
	}

}
