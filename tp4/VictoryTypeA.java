package linea;



public class VictoryTypeA extends Endings {

	private char Gamemode;

	public VictoryTypeA(char Gamemode) {
		this.Gamemode=Gamemode;
	}
	
	public boolean execute() {
		return Linea.horizontal(Linea.getUltimaFila(), Linea.getUltimaColumna(),'X')
		      ||Linea.horizontal(Linea.getUltimaFila(), Linea.getUltimaColumna(),'O')
			  ||Linea.vertical(Linea.getUltimaFila(), Linea.getUltimaColumna(),'X')
			  ||Linea.vertical(Linea.getUltimaFila(), Linea.getUltimaColumna(),'O');
		
	}

	public char getCaracter() {
		return Gamemode;
	}

}
