package eShop.model;

import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import eShop.beans.*;

public class DataManager {
  private String dbURL = "";
  private String dbUsuario = "";
  private String dbPassword = "";

  public void setDbURL(String dbURL) {
    this.dbURL = dbURL;
    }
  public String getDbURL() {
    return dbURL;
    }

  public void setDbUsuario(String dbUserName) {
    this.dbUsuario = dbUserName;
    }
  public String getDbUsuario() {
    return dbUsuario;
    }

  public void setDbPassword(String dbPassword) {
    this.dbPassword = dbPassword;
    }
  public String getDbPassword() {
    return dbPassword;
    }

  public Connection getConnection() {
    Connection conn = null;
    try {
      conn = DriverManager.getConnection(getDbURL(), getDbUsuario(),
          getDbPassword());
      }
    catch (SQLException e) {
      System.out.println("No se puede conectar a la DB: " + e.getMessage());
      }
    return conn;
    }
  public void putConnection(Connection conn) {
    if (conn != null) {
      try { conn.close(); }
      catch (SQLException e) { }
      }
    }

 
  //---------- Operaciones con Categorías ----------
  public String getNombreCategoria(String idCategoria) {
    Categoria categoria = CategoriasBD.getCategoriaPorID(this, idCategoria);
    return (categoria == null) ? null : categoria.getNombreCategoria();
    }

  public Hashtable getCategorias() {
    return CategoriasBD.getTodasCategorias(this);
    }

  public Enumeration getIDsCategoria() {
    return CategoriasBD.getTodasCategorias(this).keys();
    }

  //---------- Operaciones con Libros ----------
  public ArrayList getResultadosBusqueda(String clave) {
    return LibroBD.buscarLibros(this, clave);
    }

  public ArrayList getLibrosEnCategoria(String idCategoria) {
    return LibroBD.getLibrosPorCategoria(this, idCategoria);
    }

  public Libro getDetallesLibro(String idLibro) {
    return LibroBD.getLibroPorID(this, idLibro);
    }

  //---------- Operaciones con Pedidos ----------
  public long insertarPedido(Cliente cliente, Hashtable carritoCompra) {
    long valorRetorno = 0L;
    long idPedido = System.currentTimeMillis();
    Connection connection = getConnection();
    if (connection != null) {
      Statement stmt = null;
      try {
        connection.setAutoCommit(false);
        stmt = connection.createStatement();
        try {
          PedidosBD.insertarPedido(stmt, idPedido, cliente);
          DetallesPedidoBD.insertarDetallesPedido(stmt, idPedido, carritoCompra);
          try { stmt.close(); }
          finally { stmt = null; }
          connection.commit();
          valorRetorno = idPedido;
          }
        catch (SQLException e) {
          System.out.println("No se puede insertar el pedido: " + e.getMessage());
          try { connection.rollback(); }
          catch (SQLException ee) { }
          }
        }
      catch (SQLException e) {
        System.out.println("No se puede insertar el pedido: " + e.getMessage());
        }
      finally {
        if (stmt != null) {
          try { stmt.close(); }
          catch (SQLException e) { }
          }
        putConnection(connection);
        }
      }
    return valorRetorno;
    }
  }
