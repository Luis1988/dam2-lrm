package agenciaLRM.beans;

public class Aeropuertos {
	
	private String codigo, nombre, ciudad, pais;
	
	public String getCodigo() {
		return codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setCodigo(String cod) {
		codigo = cod;
	}
	
	public void setNombre(String nom) {
		nombre = nom;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}

}
