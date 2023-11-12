package linea;

public class gameOver extends GameStatus {

	void playRed(int columna) {
		throw new Error("Juego Terminado");
	}

	
	void playBlue(int columna) {
		throw new Error("Juego Terminado");

	}

	GameStatus change() {
		return	new gameOver();	
		}

	String finished() {
		throw new Error("Juego Terminado");

	}

}
