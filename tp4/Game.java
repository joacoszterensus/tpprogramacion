package linea;

import java.util.Scanner;

public class Game {

	  public static void main( String[] args) throws Exception {

	    System.out.println( "Dimensiones?");

	    Linea game = new Linea( promptAsInt( "Base? " ), 

	                            promptAsInt( "Altura? " ), 

	                            promptAsChar( "Estartegia de Juego: A, B o C? " ) );

	    

	    System.out.println( game.show() );

	    

	    while ( !game.finished() ) {

	      game.playRedAt( promptAsInt( "Rojas? " ) );

	      System.out.println( game.show() );

	      

	      if ( !game.finished() ) {

	        game.playBlueAt( promptAsInt( "Azul? " ) );

	        System.out.println( game.show() );

	      }

	    }



	  }



	

	  

	  private static char promptAsChar(String message) {
		    System.out.print(message);

		    Scanner scanner = new Scanner(System.in);
		    String input = scanner.nextLine();

		    
		        return input.charAt(0);
		    
		}

	
		  private static int promptAsInt(String message) {
			    System.out.print(message);

			    Scanner scanner = new Scanner(System.in);
			    return scanner.nextInt();
			}


		}

