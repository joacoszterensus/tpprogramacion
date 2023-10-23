package nemo;

class North extends Direction{
		
	public String North = "North";


	public String getDirection() {
		return North;
	}

	public Direction turnLeft() {
		return new West();
	}

	public Direction turnRight() {
		return new East();
	}
	public Coordenada forward(Coordenada coordenada) {
        return coordenada.forwardY();
    }


	
	}