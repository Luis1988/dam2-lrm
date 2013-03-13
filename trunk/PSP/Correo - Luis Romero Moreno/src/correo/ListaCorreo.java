package correo;

import java.util.ArrayList;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ListaCorreo<E> implements ListModel<E> {
	
	private ArrayList<E> lista;
	
	public ListaCorreo(ArrayList<E> lista) {
		this.lista = lista;
	}

	@Override
	public void addListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E getElementAt(int index) {
		return lista.get(index);
	}

	@Override
	public int getSize() {
		return lista.size();
	}

	@Override
	public void removeListDataListener(ListDataListener arg0) {
		// TODO Auto-generated method stub
		
	}

}
