package queue;


public class With extends Baulera{
	public Object ob;
	
	public With(Object ele) {
		ob = ele;
    }
	
	public Object take() {
        Object temp = ob;
        ob = null; 
        return temp;
	}

	@Override
	public Object head() {
		return ob;
	}

}
