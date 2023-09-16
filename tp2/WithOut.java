package queue;


public class WithOut extends Baulera{
	

	@Override
	public Object take() {
		throw new Error("Queue is empty");
	}

	@Override
	public Object head() {
		throw new Error("Queue is empty");
	}

}


