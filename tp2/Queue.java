package queue;


import java.util.ArrayList;
import java.util.List;

public class Queue {

	public  List<Object> queue = new ArrayList<Object>(); 
	private List<Type> WhichElement = new ArrayList<Type>();

	public Queue() {
		WhichElement.add(new WithoutElement());
	}
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public Queue add( Object elementToAdd ) {
		Type Element = new WithElement();
		queue.add(elementToAdd);
		Element.setElement(queue);
		WhichElement.add(Element);
		return this;
	}

	public Object take() {
		return lastElementOfWhichElement().take();
	}
	
	public Object head() {
		return lastElementOfWhichElement().head();

	}

	public int size() {
        return queue.size();
	}
	private Type lastElementOfWhichElement() {
		return WhichElement.get(size());
	}


}
