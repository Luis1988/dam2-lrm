package eShop.beans;

public class Libro {
	private String autor;
  private String idLibro;
  private double precio;
  private String titulo;

	public String getAutor() { return autor; }
	public void setAutor(String autor) { this.autor = autor; }

	public String getIdLibro() { return idLibro; }
	public void setIdLibro(String id) { this.idLibro = id; }

  public double getPrecio() { return precio; }
  public void setPrecio(double precio) { this.precio = precio; }

	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }
  }
