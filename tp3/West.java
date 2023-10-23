package nemo;

class West extends Direction{
	public String West = "West";


	public String getDirection() {
		return West;
	}

	public Direction turnLeft() {
		return new South();
	}

	public Direction turnRight() {
		return new North();
	}
	public Coordenada forward(Coordenada coordenada) {
        return coordenada.backwardX();
    }
	}