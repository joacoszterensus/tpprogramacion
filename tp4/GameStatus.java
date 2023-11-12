package linea;

public abstract class GameStatus {
	 abstract void playRed(int columna);
	 abstract void playBlue(int columna);
	 abstract GameStatus change();
	 abstract String finished() ;
	
		

}
