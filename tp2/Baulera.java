package queue;

import java.util.List;

public abstract class Baulera {
	
	protected List<Baulera> objects;

    public Baulera(List<Baulera> objects) {
        this.objects = objects;
    }
	
	public abstract Object take();
	public abstract Object head();
	public abstract boolean isEmpty();
	public abstract int size();
	public abstract Queue add(Baulera cargo);
}
