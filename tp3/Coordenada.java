package nemo;

public class Coordenada {
    public int x;
    public int y;

    public Coordenada(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordenada forwardY() {
        return new Coordenada(x,y+1);
    }

    public Coordenada backwardY() {
    	return new Coordenada(x,y-1);
    }

    public Coordenada forwardX() {
    	return new Coordenada(x+1,y);
    }

    public Coordenada backwardX() {
    	return new Coordenada(x-1,y);
    }
}