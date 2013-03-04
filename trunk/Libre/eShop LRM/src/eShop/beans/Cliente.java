package eShop.beans;

public class Cliente {
  private String nombreEntrega = "";
  private String direccionEntrega = "";
  private String nombreTarjeta = "";
  private String numeroTarjeta = "";
  private String caducidadTarjeta = "";

  public String getNombreEntrega() {
    return nombreEntrega;
    }
  public void setNombreEntrega(String nombreEntrega) {
    this.nombreEntrega = nombreEntrega;
    }

  public String getDireccionEntrega() {
    return direccionEntrega;
    }
  public void setDireccionEntrega(String direccionEntrega) {
    this.direccionEntrega = direccionEntrega;
    }

  public String getNombreTarjeta() {
    return nombreTarjeta;
    }
  public void setNombreTarjeta(String nombreTarjeta) {
    this.nombreTarjeta = nombreTarjeta;
    }

  public String getNumeroTarjeta() {
    return numeroTarjeta;
    }
  public void setNumeroTarjeta(String numeroTarjeta) {
    this.numeroTarjeta = numeroTarjeta;
    }

  public String getCaducidadTarjeta() {
    return caducidadTarjeta;
    }
  public void setCaducidadTarjeta(String caducidadTarjeta) {
    this.caducidadTarjeta = caducidadTarjeta;
    }
  }
