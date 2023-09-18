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
		return WhichElement.get(size()).isEmpty();
	}

	public Queue add( Object elementToAdd ) {
		Type Element = new WithElement();
		queue.add(elementToAdd);
		Element.setElement(queue);
		WhichElement.add(Element);
		return this;
	}

	public Object take() {
		return 	WhichElement.get(size()).take();
	}
	
	public Object head() {
		return 	WhichElement.get(size()).head();

	}

	public int size() {
        	return WhichElement.get(WhichElement.size()-1).size();
	}
	}
