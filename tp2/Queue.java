package queue;

import java.util.List;
import java.util.ArrayList;

public class Queue {
	
	public List<Baulera> objects = new ArrayList<>();
	
	public Queue() {
		Baulera bauleraVacia = new WithOut();
		objects.add(bauleraVacia);	
	}
	public boolean isEmpty() {
		return objects.size()==1;
	}

	public Queue add(Object a) {
        objects.add(new With(a));
        return this;
	}
	
	public Object take() {
        return objects.get(0).take();
    }

    public Object head() {
        return objects.get(0).head();
    }

    public int size() {
        return objects.size()-1;
    }
}







