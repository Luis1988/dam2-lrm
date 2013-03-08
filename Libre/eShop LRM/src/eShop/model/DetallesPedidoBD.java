package eShop.model;

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
				stmt.executeUpdate("INSERT INTO ORDER_DETAILS VALUES(SECUENCIAID.NEXTVAL,"+item.getIdLibro()+",'"+
						item.getTitulo()+"','"+item.getAutor()+"',"+
						item.getCantidad()+","+item.getPrecio()+","+idPedido+")");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
