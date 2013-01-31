package pruebaBeans;

public class Producto {
	
	private String idProducto;
	private int numProductos;
	private double codigoDescuento;
	private static final double costeProducto = -9999.0;
	private double costeTotal;

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public int getNumProductos() {
		return numProductos;
	}

	public void setNumProductos(int numProductos) {
		this.numProductos = numProductos;
	}

	public double getCodigoDescuento() {
		return codigoDescuento;
	}

	public void setCodigoDescuento(double codigoDescuento) {
		this.codigoDescuento = codigoDescuento;
	}
	
	public double getCosteProducto(){
		return costeProducto;
	}
	
	public double getCosteTotal(){
		costeTotal = getNumProductos()*getCosteProducto();
		return costeTotal;
	}

}
