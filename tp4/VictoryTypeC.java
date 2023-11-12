package linea;



public class VictoryTypeC extends Endings{

	private char Gamemode;

	public VictoryTypeC(char Gamemode) {
		this.Gamemode=Gamemode;
	}
	
	public boolean execute() {
		return   Linea.horizontal(Linea.getUltimaFila(), Linea.getUltimaColumna(),'X')
			   ||Linea.vertical(Linea.getUltimaFila(), Linea.getUltimaColumna(),'X')
			   ||Linea.diagonal(Linea.getUltimaFila(), Linea.getUltimaColumna(),'X')
			   ||Linea.horizontal(Linea.getUltimaFila(), Linea.getUltimaColumna(),'O')
		       ||Linea.vertical(Linea.getUltimaFila(), Linea.getUltimaColumna(),'O')
		       ||Linea.diagonal(Linea.getUltimaFila(), Linea.getUltimaColumna(),'O');


				
	}

	public char getCaracter() {
		return Gamemode;
	}
}
