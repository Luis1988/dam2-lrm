package eShop.beans;

public class Categoria {
  private int idCategoria;
  private String nombreCategoria;

  public Categoria(int id, String nombreCategoria) {
    this.idCategoria = id;
    this.nombreCategoria = nombreCategoria;
    }

  public int getIdCategoria() { return idCategoria; }
  public void setIdCategoria(int id) { this.idCategoria = id; }

  public String getNombreCategoria() { return nombreCategoria; }
  public void setNombreCategoria(String nombreCategoria) { this.nombreCategoria = nombreCategoria; }
  }
