
package linea;

import static org.junit.jupiter.api.Assertions.assertEquals;   
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;


public class CuatroEnLineaTest {
	
	@Test  void testNewGame() {
		Linea linea= new Linea(7,8,'C');

		assertEquals(8,linea.getFilas());
	    assertEquals(7,linea.getColumnas());
		assertEquals('C',linea.getGameMode());
		assertFalse(linea.finished());
	    }	
	@Test  void testTurn() {
		Linea linea= new Linea(7,8,'C');

		assertTrue(linea.turnoRed());
	    assertFalse(linea.turnoBlue());
	    }
	@Test  void testWrongGamemode() {
		Linea linea= new Linea(7,8,'F');

		assertThrowsLike("Gamemode Not Found",()->linea.finished());
	    }
	
	@Test  void testRedStarts() {
		Linea linea= new Linea(7,8,'B');

		linea.playRedAt(1);
		
		assertFalse(linea.finished());
		}
	
	@Test  void testRedPlayTwiceShouldFail() {
		Linea linea= new Linea(7,8,'C');

		linea.playRedAt(1);
		
		assertThrowsLike("Not Your Turn",()->linea.playRedAt(1));
	    }
	
	@Test  void testBlueCanPlayAfterRed() {
		Linea linea= new Linea(7,8,'B');

		linea.playRedAt(1);
		linea.playBlueAt(1);
		
		assertFalse(linea.finished());
		}	
	
	@Test  void testBlueCanPlayAfterRedTwiceSHouldFail() {
		Linea linea= new Linea(7,8,'B');
		
		linea.playRedAt(1);
		linea.playBlueAt(1);
		
		
		assertFalse(linea.finished());
		assertThrowsLike("Not Your Turn",()->linea.playBlueAt(1));
		}
	
	@Test  void testColumnOutOfBounds() {
		Linea linea= new Linea(7,8,'C');

		assertThrowsLike("Columna fuera de rango.",()->linea.playRedAt(-1));
		assertThrowsLike("Columna fuera de rango.",()->linea.playRedAt(9));
		}
	
	@Test  void testColumnIsFull() {
		Linea linea= new Linea(7,8,'C');

		linea.playRedAt(1);linea.playBlueAt(1);linea.playRedAt(1);linea.playBlueAt(1);
		linea.playRedAt(1);linea.playBlueAt(1);linea.playRedAt(1);linea.playBlueAt(1);
		
		assertThrowsLike("Columna Completa.",()->linea.playRedAt(1));
		}
			
	@Test  void testNotVictory() {
		Linea linea= new Linea(7,10,'A');

		linea.playRedAt(4);linea.playBlueAt(1);linea.playRedAt(5);
		linea.playBlueAt(1);linea.playRedAt(6);linea.playBlueAt(1);
		
		
		assertFalse(linea.finished());
		}
	
	@Test  void testVictoryRedByHorizontalLineInGamemodeA() {
		Linea linea= new Linea(7,10,'A');

		linea.playRedAt(4);linea.playBlueAt(1);linea.playRedAt(5);linea.playBlueAt(1);
		linea.playRedAt(6);linea.playBlueAt(1);linea.playRedAt(7);
		
		
		assertTrue(linea.finished());
		}
	
	@Test  void testVictoryBlueByHorizontalLineInGamemodeA() {
		Linea linea= new Linea(7,10,'A');

		
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(2);linea.playBlueAt(3);
		linea.playRedAt(3);linea.playBlueAt(4);linea.playRedAt(4);linea.playBlueAt(5);
		
		
		assertTrue(linea.finished());
		}
	
	
	@Test  void testVictoryRedByVerticallLineInGamemodeA() {
		Linea linea= new Linea(7,10,'A');
	
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(1);linea.playBlueAt(2);
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(1);
		
		
		assertTrue(linea.finished());
		}
	@Test  void testVictoryBlueByVerticallLineInGamemodeA() {
		Linea linea= new Linea(7,10,'A');
		
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(3);linea.playBlueAt(2);
		linea.playRedAt(3);linea.playBlueAt(2);linea.playRedAt(4);linea.playBlueAt(2);
		
		assertTrue(linea.finished());
		}

	@Test  void testNotVictoryByDIagonalLineInGamemodeA() {
		Linea linea= new Linea(7,10,'A');
	
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(2);linea.playBlueAt(3);
		linea.playRedAt(3);linea.playBlueAt(4);linea.playRedAt(3);linea.playBlueAt(4);
		linea.playRedAt(4);linea.playBlueAt(6);linea.playRedAt(4);
		
		
		assertFalse(linea.finished());
		}


	@Test  void testVictoryRedByPositiveDIagonalLineInGamemodeB() {
		Linea linea= new Linea(7,10,'B');
	
		
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(2);linea.playBlueAt(3);
		linea.playRedAt(3);linea.playBlueAt(4);linea.playRedAt(3);linea.playBlueAt(4);
		linea.playRedAt(4);linea.playBlueAt(6);linea.playRedAt(4);
		
		
		assertTrue(linea.finished());
	
	
	}
	
	@Test  void testVictoryBlueByPositiveDIagonalLineInGamemodeB() {
		Linea linea= new Linea(7,10,'B');
	
		
		linea.playRedAt(2);linea.playBlueAt(1);linea.playRedAt(3);linea.playBlueAt(2);
		linea.playRedAt(3);linea.playBlueAt(3);linea.playRedAt(4);linea.playBlueAt(4);
		linea.playRedAt(4);linea.playBlueAt(4);
		
		
		assertTrue(linea.finished());
	
		}
	@Test  void testVictoryBlueByNegativeDIagonalLineInGamemodeB() {
		Linea linea= new Linea(7,10,'B');
	
		
		linea.playRedAt(1);linea.playBlueAt(1);linea.playRedAt(1);linea.playBlueAt(1);
		linea.playRedAt(2);linea.playBlueAt(2);linea.playRedAt(3);linea.playBlueAt(2);
		linea.playRedAt(5);linea.playBlueAt(3);linea.playRedAt(5);linea.playBlueAt(4);
		
		
		assertTrue(linea.finished());
	
		}
	@Test  void testNotVictoryByVerticallLineInGamemodeB() {
		Linea linea= new Linea(7,10,'B');
	
		
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(3);linea.playBlueAt(2);
		linea.playRedAt(3);linea.playBlueAt(2);linea.playRedAt(4);linea.playBlueAt(2);
		
		
		assertFalse(linea.finished());
	}
	@Test  void testNotVictoryByHorizontalLineInGamemodeB() {
		Linea linea= new Linea(7,10,'B');
	
		
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(2);linea.playBlueAt(3);
		linea.playRedAt(3);linea.playBlueAt(4);linea.playRedAt(4);linea.playBlueAt(5);
		
		
		assertFalse(linea.finished());
	}
	@Test  void testVictoryByHorizontalLineInGamemodeC() {
		Linea linea= new Linea(7,10,'C');
	
		
		linea.playRedAt(4);linea.playBlueAt(1);linea.playRedAt(5);linea.playBlueAt(1);
		linea.playRedAt(6);linea.playBlueAt(1);linea.playRedAt(7);
		
		
		assertTrue(linea.finished());
	
		
	}	
	@Test  void testVictoryByVerticallLineInGamemodeC() {
		Linea linea= new Linea(7,10,'C');
	
		
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(1);linea.playBlueAt(2);
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(1);
		
		
		assertTrue(linea.finished());
	
	}
	@Test  void testVictoryByPositiveDIagonalLineInGamemodeC() {
		Linea linea= new Linea(7,10,'C');
	
		
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(2);linea.playBlueAt(3);
		linea.playRedAt(3);linea.playBlueAt(4);linea.playRedAt(3);linea.playBlueAt(4);
		linea.playRedAt(4);linea.playBlueAt(6);linea.playRedAt(4);
		
		
		assertTrue(linea.finished());
	
	}
	@Test  void testVictoryBlueByNegativeDIagonalLineInGamemodeC() {
		Linea linea= new Linea(7,10,'C');
	
		
		linea.playRedAt(1);linea.playBlueAt(1);linea.playRedAt(1);linea.playBlueAt(1);
		linea.playRedAt(2);linea.playBlueAt(2);linea.playRedAt(3);linea.playBlueAt(2);
		linea.playRedAt(5);linea.playBlueAt(3);linea.playRedAt(5);linea.playBlueAt(4);
		
		
		assertTrue(linea.finished());
	
		}
	
	@Test  void testCantKeepPlayingAfterVictory() {
		Linea linea= new Linea(7,10,'C');
	
		
		linea.playRedAt(1);linea.playBlueAt(2);linea.playRedAt(2);linea.playBlueAt(3);
		linea.playRedAt(3);linea.playBlueAt(4);linea.playRedAt(3);linea.playBlueAt(4);
		linea.playRedAt(4);linea.playBlueAt(6);linea.playRedAt(4);
	
		assertTrue(Linea.finished());
		assertThrowsLike("Juego Terminado",()->linea.playBlueAt(1));

	}
	@Test  void testDraw() {
		Linea linea= new Linea(1,1,'A');
	
		linea.playRedAt(1);
		assertTrue(Linea.finished());

	}
	
		private void assertThrowsLike(String message, Executable executable) {
			assertEquals(message, assertThrows(Error.class,executable).getMessage());
		}
	}
	
	
			
