package dominio.intro;

public class Persona {
	
	private long id;
	private String nombre;
	
	public Persona(){}
	
	public Persona(String nom){
		nombre = nom;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
