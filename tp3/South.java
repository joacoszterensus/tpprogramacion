package nemo;

class South extends Direction{
	public String South = "South";


	public String getDirection() {
		return South;
	}

	public Direction turnLeft() {
		return new East();
	}

	public Direction turnRight() {
		return new West();
	}
	public Coordenada forward(Coordenada coordenada) {
        return coordenada.backwardY();
    }
	

}
