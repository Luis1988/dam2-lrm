package hibernate.relaciones.unomuchos.modelo;

import java.util.ArrayList;
import java.util.List;
public class Persona 
{
	private long id;
	private String nombre;
	private List<Libro> libros = new ArrayList<Libro>();

	public Persona()
	{
	}

	public long getId()
	{
		return id;
	}

	protected void setId(long id)
	{
		this.id = id;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public List<Libro> getLibros()
	{
		return libros;
	}

	public void setLibros(List<Libro> libros)
	{
		this.libros = libros;
	}

	public void addLibro(Libro libro)
	{
		this.libros.add(libro);
	}
}