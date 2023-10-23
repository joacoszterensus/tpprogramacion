package nemo;

public class Nemo {
    //public DepthNavigator depth;
	public Depth depth;
    public Direction direccion;
    public Coordenada point;
    

    public Nemo(Direction direccion, Coordenada point) {
        this.depth = new Surface();
        this.direccion = direccion;
        this.point = point;
    }

    public Coordenada getPoint() {
        return point;
    }

    public String getDirection() {
        return direccion.getDirection();
    }

    public int getDepth() {
        return depth.getDepth();
    }

    public Nemo instructions(String commands) {
    	commands.chars().forEach(c -> 
    		move((char) (c)));
		return this; 
		}        
            
	public Nemo move(char comando) {
		Command.CommandFor(comando).execute(this);
		return this;
		
	}
	public Nemo descend() {
		depth = depth.descend();
		return this;
	}
	public Nemo ascend() {
		depth = depth.ascend();
		return this;
	}
	public void launchCapsule() {
		depth.launchCapsule();
	}
	public Nemo left() {
		direccion = direccion.turnLeft();
		return this;
	}
	public Nemo right() {
		direccion = direccion.turnRight();
		return this;
	}
	public Nemo forward() {
		point = direccion.forward(point);
		return this;
	}
	
}

    
    