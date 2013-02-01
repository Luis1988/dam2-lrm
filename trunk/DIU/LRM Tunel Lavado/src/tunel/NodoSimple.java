package tunel;

public class NodoSimple {

	private Object objeto;
	private NodoSimple sig;
	
	public NodoSimple()
	{
		this.objeto=null;
		this.sig=null;
	}
	
	public NodoSimple(Object objeto)
	{
		this.objeto=objeto;
		this.sig=null;
	}

	public Object getObjeto() {
		return objeto;
	}


	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}


	public NodoSimple getSig() {
		return sig;
	}


	public void setSig(NodoSimple sig) {
		this.sig = sig;
	}
	
}
