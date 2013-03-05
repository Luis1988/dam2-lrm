package eShop.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.Hashtable;

import eShop.beans.Carrito;

public class DetallesPedidoBD {

	public static void insertarDetallesPedido(Statement stmt, long idPedido,
			Hashtable carritoCompra) {
		Enumeration enumList = carritoCompra.elements();
		while(enumList.hasMoreElements()) {
			Carrito item = (Carrito) enumList.nextElement();
			try {
				stmt.executeUpdate("INSERT INTO ORDER_DETAILS(BOOK_ID,TITLE,AUTHOR,"+
						"QUANTITY,PRICE,ORDER_ID) VALUES("+item.getIdLibro()+","+
						item.getTitulo()+","+item.getAutor()+","+
						item.getCantidad()+","+item.getPrecio()+","+idPedido);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
