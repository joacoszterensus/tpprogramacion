package queue;

import java.util.List;

public  class WithoutElement extends Type{
	
	public Object take() {
        throw new Error("Queue is empty");
    }
    public Object head() {
        throw new Error("Queue is empty");
    }
		
	public int size() {
		return 0;
	}
	public boolean isEmpty() {
		return true;
	}
	public void setElement(List<Object> lista) {

}
}

