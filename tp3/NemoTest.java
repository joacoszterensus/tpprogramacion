package nemo;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NemoTest{
	
	
	@Test public void test01InitialPosition(){
		ensureAllNemoFeaturesCorrect(NorthNemo(), 0, "North", 0, 0);
	}

	@Test public void test02StayInSamePlaceIfNoCommandsGiven() {
		Nemo nemo = NorthNemo();
		nemo.instructions("");
		ensureAllNemoFeaturesCorrect(nemo, 0, "North", 0, 0);
	}

	@Test public void test03ensureDescend() {
		Nemo nemo = NorthNemo();
		assertDepthAfterVerticalMovement(nemo, ()-> nemo.instructions("d"), -1);
	}
	@Test public void test04ensureAscend() {
		Nemo nemo = NorthNemo();
		assertDepthAfterVerticalMovement(nemo, ()->nemo.instructions("du"), 0);
	}
	@Test public void test05ensureCorrectDepth() {
		Nemo nemo = EastNemo();
		assertDepthAfterVerticalMovement(nemo, ()-> nemo.instructions("dddd"), -4);
	}
	
	@Test public void test06ensureForwardMovementFacingNorth() {
		Nemo nemo = NorthNemo();
		ensureForwardMovement(nemo, ()-> nemo.instructions("f"), 0, 1);
	}
	
	@Test public void test07ensureForwardMovementFacingWest() {
		Nemo nemo = WestNemo();
		ensureForwardMovement(nemo, ()-> nemo.instructions("f"), -1, 0);
	}

	@Test public void test08ensureForwardMovementFacingSouth() {
		Nemo nemo = SouthNemo();
		ensureForwardMovement(nemo, ()-> nemo.instructions("f"), 0, -1);
	}
	
	@Test public void test09ensureForwardMovementFacingEast() {
		Nemo nemo = EastNemo();
		ensureForwardMovement(nemo, ()-> nemo.instructions("f"), 1, 0);
	}
	
	@Test public void test10ensureLeftRotationFacingNorth() {
		Nemo nemo = NorthNemo();
		assertDirectionAfterRotation(nemo, () -> nemo.instructions("l"), "West");
		
	}
	
	@Test public void test11ensureLeftRotationFacingWest() {
		Nemo nemo = WestNemo();
		assertDirectionAfterRotation(nemo, () -> nemo.instructions("l"), "South");
		
	}
	
	@Test public void test12ensureLeftRotationFacingSouth() {
		Nemo nemo = SouthNemo();
		assertDirectionAfterRotation(nemo, () -> nemo.instructions("l"), "East");
		
	}
	
	@Test public void test13ensureLeftRotationFacingEast() {
		Nemo nemo = EastNemo();
		assertDirectionAfterRotation(nemo, () -> nemo.instructions("l"), "North");
		
	}
	@Test public void test14ensureRightRotationFacingNorth() {
		Nemo nemo = NorthNemo();
		assertDirectionAfterRotation(nemo, () -> nemo.instructions("r"), "East");
		
	}
	
	@Test public void test15ensureRightRotationFacingWest() {
		Nemo nemo = WestNemo();
		assertDirectionAfterRotation(nemo, () -> nemo.instructions("r"), "North");
		
	}
	
	@Test public void test16ensureRightRotationFacingSouth() {
		Nemo nemo = SouthNemo();
		assertDirectionAfterRotation(nemo, () -> nemo.instructions("r"), "West");
		
	}
	
	@Test public void test17ensureRightRotationFacingEast() {
		Nemo nemo = EastNemo();
		assertDirectionAfterRotation(nemo, () -> nemo.instructions("r"), "South");
		
	}

	@Test public void test18ensureNemoExplodesIfSubmerged() {
		Nemo nemo = NorthNemo();
		nemo.instructions("dd");		
		assertThrowsLike(nemo, "Nemo exploded");	
		
	}

	@Test public void test19ensureNemoDoesNotExplodesInSurface() {
		Nemo nemo = NorthNemo();		
		assertNoExceptionWhenLaunchingAtCorrectDepth(nemo);
	}

	@Test public void test20ensureNemoDoesNotExplodesSemiSubmerged() {
		Nemo nemo = NorthNemo();
		nemo.instructions("d");
		assertNoExceptionWhenLaunchingAtCorrectDepth(nemo);
	}
	

	private Nemo NorthNemo() {
		Coordenada cor = new Coordenada(0,0);
		Direction north = new North();
		Nemo nemo = new Nemo(north, cor);
		return nemo;
	}	
	private Nemo SouthNemo() {
		Coordenada cor = new Coordenada(0,0);
		Direction south = new South();
		Nemo nemo = new Nemo(south, cor);
		return nemo;
	}
	private Nemo WestNemo() {
		Coordenada cor = new Coordenada(0,0);
		Direction west = new West();
		Nemo nemo = new Nemo(west, cor);
		return nemo;
	}
	private Nemo EastNemo() {
		Coordenada cor = new Coordenada(0,0);
		Direction east = new East();
		Nemo nemo = new Nemo(east, cor);
		return nemo;
	}
	
	private void ensureForwardMovement(Nemo nemo, Runnable run, int x, int y) {
		run.run();
		assertEquals( x, nemo.getPoint().getX()); 
		assertEquals( y, nemo.getPoint().getY());
	}
	private void ensureAllNemoFeaturesCorrect(Nemo nemo, int depth, String direction, int x, int y) {
		assertEquals( x, nemo.getPoint().getX()); 
		assertEquals( y, nemo.getPoint().getY());
		assertEquals( depth, nemo.getDepth());
		assertEquals( direction, nemo.getDirection());
	}
	private void assertDepthAfterVerticalMovement(Nemo nemo, Runnable run, int depth) {
		run.run();
		assertEquals( depth , nemo.getDepth());
	}
	private void assertDirectionAfterRotation(Nemo nemo, Runnable run, String direction) {
		run.run();		
		assertEquals(direction , nemo.getDirection());
	}
	private void assertThrowsLike(Nemo nemo, String message) {
		assertEquals(message,
				assertThrows(Exception.class, ()-> nemo.instructions("m")).getMessage());
	}
	private void assertNoExceptionWhenLaunchingAtCorrectDepth(Nemo nemo) {
		assertDoesNotThrow(() -> {
	        nemo.instructions("m");
	    });
	}
}

