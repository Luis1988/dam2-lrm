package tunel;

import utiles.Iterator;
import utiles.Queue;

public class ColaCoches implements Queue {

	private boolean ref;
	private int numElem = 0;
	private NodoSimple primero, ultimo;
	
	public ColaCoches(){
		ref = true;
	}
	
	public ColaCoches(boolean ref){
		this.ref = ref;
	}
	
	@Override
	public Iterator createIterator(String itor) {
		return null;
	}

	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return numElem;
	}

	@Override
	public boolean isEmpty() {
		return numElem == 0;
	}

	@Override
	public void removeAll() {
		numElem = 0;
		primero = new NodoSimple();
		ultimo = new NodoSimple();
	}

	@Override
	public boolean getRef() {
		return ref;
	}

	@Override
	public void add(Object x) {
		if(primero == null) {
			NodoSimple nodo = new NodoSimple(x);
			primero = nodo;
			ultimo = nodo;
			numElem++;
		}
		else {
			NodoSimple nodo = new NodoSimple(x);
			ultimo.setSig(nodo);
			ultimo = nodo;
			numElem++;
		}
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object get() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ColaCoches clone(){
		ColaCoches copia = null;
		try{
			copia = (ColaCoches) super.clone();
		} catch(CloneNotSupportedException cnse){
			cnse.printStackTrace();
		}
		return copia;
	}

}
