package linea;
 
import java.util.ArrayList;     
import java.util.List;



public class Linea {

    private static  List<List<Character>> tablero;
	
    private static GameStatus turno;
	private static char gameMode;
	private static int Filas;
	private static int Columnas;
	
	private static int ultimaColumnaJugada;
	private static int ultimaFilaJugada;

	private static  int timesPlayed;
	 static GameStatus lastTurn;
    
	public Linea(int columnas, int filas ,char gameMode) {
    	this.turno=new TurnoRojo();
    	this.Filas=filas;
    	this.Columnas=columnas;
    	this.gameMode=gameMode;
    	timesPlayed=0;

    	tablero = new ArrayList<>();

    	for (int fila=0;fila<filas;fila++) {
    		List<Character> columnasTablero = new ArrayList<>();
    		tablero.add(columnasTablero);
    		}
    	}


    public String show() {
    	String miTablero= generarTablero(tablero,Columnas,Filas);
    	if (draw()) {
    		miTablero+="\n"+("Empate!!");
    		return miTablero;
    	}
    	
    	if (finished()) {
    		miTablero+="\n"+lastTurn.finished();
    		return miTablero;

    	}
    	return miTablero;

    	
    }

    
    public void playRedAt(int columna) {
    	turno.playRed(columna);
    	setTurn(turno.change());
    }
    
	public void playBlueAt(int columna) {
    	turno.playBlue(columna);
    	setTurn(turno.change());	
    }
	
    static void play(int columna,char playerToken) {
    	if (columna < 1 || columna > Columnas) {
            throw new Error ("Columna fuera de rango.");
        }
    	if (tablero.get(columna-1).size()==Filas) {
            throw new Error ("Columna Completa.");
    	}
    	
    	tablero.get(columna-1).add(playerToken);

    	timesPlayed++;
    	ultimaFilaJugada=tablero.get(columna-1).size();
    	ultimaColumnaJugada= columna;
    	
    	
	
    }
    
    public static boolean finished() {
    	return Endings.EndingFor((char)gameMode);
	}
    
    

    static boolean horizontal(int fila, int columna,char token) {
        int consecutivasHorizontal = 0;
	
        for (int c = columna - 4; c <= columna + 4; c++) {
        if (c >= 0 && c < tablero.size() && fila>0) {
                if (fila  <= tablero.get(c).size()) {
                	if (tablero.get(c).get(fila - 1) == token) {
                        consecutivasHorizontal++;
                        if (consecutivasHorizontal >= 4) {
    	                    lastTurn=turno.change();
                        	setTurn(new gameOver());
                            return true;
                        }
                    } else {
                        consecutivasHorizontal = 0;
                    }
                }
            }
        }
        return false;
    }



    static boolean vertical(int fila, int columna,char token) {
        int consecutivasVertical = 0;

        for (int f = fila-4; f <= fila+4; f++) {
            if (columna>0 && f >= 0 && f < tablero.get(columna-1).size() ) {
                if (tablero.get(columna-1).get(f) == token) {
                    consecutivasVertical++;
                    if (consecutivasVertical >= 4) {
	                    lastTurn=turno.change();
                    	setTurn(new gameOver());
	                    return true;
                    }
                } else {
                    consecutivasVertical=0; 
                }
            } 
        }
        return false;
    }

	static boolean diagonal(int fila, int columna,char token) {
	    int consecutivasDiagonal1 = 0;
	    
	    for (int f = fila-4, c = columna-4; f < fila+2  && c < columna+3 ; f++, c++) {
	        if ( c>=0 && c<tablero.size() && f>=0 && f <tablero.get(c).size()) {
	            if (tablero.get(c).get(f) == token) {
	                consecutivasDiagonal1++;
	                if (consecutivasDiagonal1 >= 4) {
	                    lastTurn=turno.change();
	                	setTurn(new gameOver());
	                    return true;
	                }
	            } else {
	                consecutivasDiagonal1 = 0;
	            }
	        }
	    }
	    int consecutivasDiagonal2 = 0;
	    
	    for (int f = fila+2, c = columna-4; f >= fila-4  && c < columna+3 ; f--, c++) {
	        if ( c>=0 && c<tablero.size() && f>=0 && f <tablero.get(c).size()) {
	        	if (tablero.get(c).get(f) == token) {
	                consecutivasDiagonal2++;
	                if (consecutivasDiagonal2 >= 4) {
	                    lastTurn=turno.change();
	                	setTurn(new gameOver());
	                    return true;
	                }
	            } else {
	                consecutivasDiagonal2 = 0;
	            }
	        }
	    }
		return false;
	}
   

	String generarTablero(List<List<Character>> tablero, int columnas, int filas) {
	    StringBuilder tableroString = new StringBuilder();

	    tableroString.append("|");
	    for (int i = 1; i <= columnas; i++) {
	        tableroString.append(" " + i + " |");
	    }
	    tableroString.append('\n');

	    for (int fila = filas - 1; fila >= 0; fila--) {
	        tableroString.append("|");
	        for (int columna = 0; columna < columnas; columna++) {
	            if (columna < tablero.size() && fila < tablero.get(columna).size()) {
	                tableroString.append(" " + tablero.get(columna).get(fila) + " |");
	            } else {
	                tableroString.append("   |"); 
	            }
	        }
	        tableroString.append('\n');
	    }

	    return tableroString.toString();
	}

 
	static  boolean draw() {
		return timesPlayed==Columnas*Filas;
	}

	public boolean turnoRed() {
		return turno instanceof TurnoRojo;
	}
    
	public boolean turnoBlue() {
		return turno instanceof TurnoAzul ;
	}
	
	public char getGameMode() {
		return gameMode;
	}
	
	public int getFilas() {
		return Filas;
	}
	
	public int getColumnas() {
		return Columnas;
    }
	
	 static void setTurn(GameStatus turn) {
		turno=turn;
	}
	
	
	

	 static int getUltimaFila() {
		return ultimaFilaJugada;
	}

	 static int getUltimaColumna() {
		return ultimaColumnaJugada;
	}	
	
}