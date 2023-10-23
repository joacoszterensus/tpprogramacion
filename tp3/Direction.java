package nemo;

public abstract class Direction {
	public abstract String getDirection();
	public abstract Direction turnRight();
	public abstract Direction turnLeft();
	public abstract Coordenada forward(Coordenada coordenada);

	
}