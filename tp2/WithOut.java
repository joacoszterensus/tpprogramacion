package queue;

import java.util.List;

public class WithOut extends Baulera{
	
	public WithOut(List<Baulera> objects) {
        super(objects);
    }

	@Override
	public Object take() {
		throw new Error("Queue is empty");
	}

	@Override
	public Object head() {
		throw new Error("Queue is empty");
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public int size() {
		return 0;
	}

	
	}

}
