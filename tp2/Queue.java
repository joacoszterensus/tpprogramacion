package queue;


import java.util.ArrayList;
import java.util.List;

public class Queue {

	public  List<Object> queue = new ArrayList<Object>(); 
	private List<Type> WhichElement=new ArrayList<Type>();

	public Queue() {
		Type ElementNull=new WithoutElement();

		WhichElement.add(ElementNull);
	}


	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public Queue add( Object x ) {
		Type Element=new WithElement();
		queue.add(x);
		Element.setElement(queue);

		WhichElement.add(Element);
		return this;
	}

	public Object take() {
		
		return 	WhichElement.get(queue.size()).take();

	}

	public Object head() {
		return WhichElement.get(queue.size()).head();

	}

	public int size() {
        return queue.size();
	}

}
