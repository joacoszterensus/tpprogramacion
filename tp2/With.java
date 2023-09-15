package queue;

import java.util.List;

public class With extends Baulera{
	
	public With(List<Baulera> objects) {
        super(objects);
    }
	
	public Object take() {
		return objects.remove(0);
	}

	@Override
	public Object head() {
		return objects.get(0);
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int size() {
		int tamaño = (objects.size())-1;
		return tamaño;
	}

	//@Override
	//public Queue add(Baulera cargo) {
		//return objects.add(cargo);
		
	//}

}
