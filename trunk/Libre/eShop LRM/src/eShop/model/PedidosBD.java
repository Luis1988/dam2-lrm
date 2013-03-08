package eShop.model;

import java.sql.SQLException;
import java.sql.Statement;

import eShop.beans.Cliente;

public class PedidosBD {

	public static void insertarPedido(Statement stmt, long idPedido,
			Cliente cliente) {
			try {
				stmt.executeUpdate("INSERT INTO ORDERS VALUES ("+
						idPedido+",'"+cliente.getNombreEntrega()+"','"+
						cliente.getDireccionEntrega()+"','"+cliente.getNombreTarjeta()+
						"','"+cliente.getNumeroTarjeta()+"','"+cliente.getCaducidadTarjeta()+"')");
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

}
