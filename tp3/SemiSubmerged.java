package nemo;

public class SemiSubmerged extends Depth{
	public int depth=-1;
	
	public int getDepth() {
		return depth;
	}
	public Depth descend() {
		return new Submerged(this);
	}
	public Depth ascend() {
		return new Surface();
	}
	public void launchCapsule() {
		return;
	}

}