package nemo;

class East extends Direction{
	public String East = "East";


	public String getDirection() {
		return East;
	}

	public Direction turnLeft() {
		return new North();
	}

	public Direction turnRight() {
		return new South();
	}
	public Coordenada forward(Coordenada coordenada) {
        return coordenada.forwardX();
    }

	}