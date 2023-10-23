package nemo;

public class Submerged extends Depth {
	public int depth;
	public Depth previo;
	
	public Submerged(Depth previo) {
		this.previo=previo;
	}
	public int getDepth() {
		return previo.getDepth()-1;
	}
	public Depth descend() {
		return new Submerged(this);
	}
	public Depth ascend() {
		return previo;
	}
	public void launchCapsule() {
		throw new RuntimeException("Nemo exploded");
	}

}
