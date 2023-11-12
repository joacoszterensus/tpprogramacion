package linea;



public class VictoryTypeB extends Endings {

	private char Gamemode;

	public VictoryTypeB(char Gamemode) {
		this.Gamemode=Gamemode;
	}
	
	public boolean execute() {
		return Linea.diagonal(Linea.getUltimaFila(), Linea.getUltimaColumna(),'X')
				||Linea.diagonal(Linea.getUltimaFila(), Linea.getUltimaColumna(),'O');

		
	}

	public char getCaracter() {
		return Gamemode;
	}
}