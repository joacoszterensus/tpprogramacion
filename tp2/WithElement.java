package queue;

import java.util.List;

public class WithElement extends Type{
	List<Object> lista;
  
  
	
	public void setElement(List<Object> lista) {
		this.lista = lista;
	}
	public Object take() {
        return lista.remove(0);

    }
    public Object head() {
        return lista.get(0);
    }
	public int size() {
		return lista.size();
	}
	public boolean isEmpty() {
		return false;
	}
}

