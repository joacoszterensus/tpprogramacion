package queue;

import java.util.List;
import java.util.ArrayList;

public class Queue {
	
	public List<Baulera> objects = new ArrayList<>();
	
	public Queue() {
		Baulera bauleraVacia = new WithOut(objects);
		objects.add(bauleraVacia);	
	}
	public boolean isEmpty() {
		return objects.isEmpty();
	}

	public Queue add( Baulera cargo ) {
		objects.add(cargo);
		return this;
	}

	public Object take() {
		Baulera.take();
	}

	public Object head() {
		if (isEmpty()) {
			throw new Error("Queue is empty");
		} else {
			return objects.get(0);
		}
	}

	public int size() {
		return objects.size();
	}

}



