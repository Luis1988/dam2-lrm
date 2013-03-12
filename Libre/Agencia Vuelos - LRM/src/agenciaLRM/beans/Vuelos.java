package agenciaLRM.beans;

import java.sql.Date;
import java.sql.Time;

public class Vuelos {
	
	private int codigo, plazasTotales, plazasLibres, precio;
	private String origen, destino, codAero;
	private Time horaSalida, horaLlegada;
	private Date fechaSalida, fechaLlegada;
	
	public Time getHoraLlegada() {
		return horaLlegada;
	}
	
	public Time getHoraSalida() {
		return horaSalida;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public int getPlazasTotales() {
		return plazasTotales;
	}
	
	public int getPlazasLibres() {
		return plazasLibres;
	}
	
	public int getPrecio() {
		return precio;
	}
	
	public String getOrigen() {
		return origen;
	}
	
	public String gesDestino() {
		return destino;
	}
	
	public String getCodAero() {
		return codAero;
	}
	
	public Date getFechaSalida() {
		return fechaSalida;
	}
	
	public Date getFechaLlegada() {
		return fechaLlegada;
	}
	
	public void setCodigo(int cod) {
		codigo = cod;
	}
	
	public void setPlazasTotales(int tot) {
		plazasTotales = tot;
	}
	
	public void setPlazasLibres(int libres) {
		plazasLibres = libres;
	}
	
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	
	public void setDestino(String dest) {
		destino = dest;
	}
	
	public void setCodAero(String cod) {
		codAero = cod;
	}

	public void setFechaSalida(Date date) {
		fechaSalida = date;
	}
	
	public void setFechaLlegada(Date date) {
		fechaLlegada = date;
	}
	
	public void setHoraLlegada(Time time) {
		horaLlegada = time;
	}
	
	public void setHoraSalida(Time time) {
		horaSalida = time;
	}

}
