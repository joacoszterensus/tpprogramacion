package queue;

import java.util.List;

public abstract class Type  {
	public abstract Object take();
	public abstract Object head();
	protected abstract void setElement(List<Object> lista);
}

