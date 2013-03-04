package eShop.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;

public class DetallesPedidoBD {

	public static void insertarDetallesPedido(Statement stmt, long idPedido,
			Hashtable carritoCompra) {
		try {
			ResultSet rs = stmt.executeQuery("INSERT INTO ORDER_DETAILS VALUES ("+
					idPedido+","+carritoCompra.get(carritoCompra)+")");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
