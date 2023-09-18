package queue;

import java.util.List;

public abstract class Type  {
	
	public abstract int size();
	public abstract Object take();
	public abstract Object head();
	public abstract boolean isEmpty();
	public abstract void setElement(List<Object> lista);

}
