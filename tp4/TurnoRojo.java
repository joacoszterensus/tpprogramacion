package linea;


public class TurnoRojo extends GameStatus {

	 void playRed(int columna) {
		Linea.play(columna,'X');

	}

	 void playBlue(int columna) {
		throw new Error("Not Your Turn");
		
	}

	  GameStatus change() {
		return new TurnoAzul();
	}

	

	
	String finished() {
		return ("El Equipo Rojo Gano!!!");
	}

}
