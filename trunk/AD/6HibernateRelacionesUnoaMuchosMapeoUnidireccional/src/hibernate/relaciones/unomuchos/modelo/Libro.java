package hibernate.relaciones.unomuchos.modelo;
public class Libro 

{ 
	private long id; 
	private String titulo;

	public Libro() 
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

	public String getTitulo() 
	{ 
		return titulo; 
	}  

	public void setTitulo(String titulo) 
	{ 
		this.titulo = titulo; 
	} 
}