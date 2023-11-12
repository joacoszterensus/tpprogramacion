package linea;


public class TurnoAzul extends GameStatus{

	void playRed(int columna) {
		throw new Error("Not Your Turn");
	}
	void playBlue(int columna) {
		Linea.play(columna,'O');
	}
	public GameStatus change() {
		return new TurnoRojo();
	}
	
	
	String finished() {
		return ("El Equipo Azul Gano!!!");
	}
}
