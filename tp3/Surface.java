package nemo;


public class Surface extends Depth{
	public int depth=0;
	
	public int getDepth() {
		return depth;
	}
	public Depth descend() {
		return new SemiSubmerged();
	}
	
	public Depth ascend() {
		return this;
	}
	public void launchCapsule() {
		return;
	}


}