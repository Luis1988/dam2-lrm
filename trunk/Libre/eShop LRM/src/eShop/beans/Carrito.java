package eShop.beans;

public class Carrito {
  private String autor;
  private String titulo;
  private double precio;
  private String idLibro;
  private String cantidad;

	public Carrito(Libro libro, int cantidad) {
		idLibro = libro.getIdLibro();
		titulo = libro.getTitulo();
		autor = libro.getAutor();
		precio = libro.getPrecio();
		this.cantidad = new Integer(cantidad).toString();
	  }

	public String getAutor() { return autor; }
	public void setAutor(String autor) { this.autor = autor; }

	public String getTitulo() { return titulo; }
	public void setTitulo(String titulo) { this.titulo = titulo; }

	public double getPrecio() { return precio; }
	public void setPrecio(double precio) { this.precio = precio; }

	public String getIdLibro() { return idLibro; }
	public void setlibroId(String idLibro) { this.idLibro = idLibro; }

	public String getCantidad() { return cantidad; }
	public void setCantidad(String cantidad) { this.cantidad = cantidad; }
  }
