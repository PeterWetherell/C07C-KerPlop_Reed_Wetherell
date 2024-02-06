package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.Ghost;
import levelPieces.Mouse;

public class TestMovingPieces {
	@Test
	public void testGhost() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[1] = new Mouse();
		gameBoard[5] = new Mouse();
		gameBoard[6] = new Mouse();
		gameBoard[10] = new Mouse();
		gameBoard[19] = new Mouse();
		//expect ghost to visit 0,2,3,4,7,8,9,11,12,13,14,15,16,17,18,20
		int[] visited = new int[GameEngine.BOARD_SIZE];
		int[] expectedLocations = {0,2,3,4,7,8,9,11,12,13,14,15,16,17,18,20};
		
		Ghost g = new Ghost(0);
		gameBoard[0] = g;
		for (int i = 0; i < 500; i ++) { //loop 500 times and teleport ghost
			g.move(gameBoard, 0);
			visited[g.getLocation()] ++;
		}
		
		//check the movement is good
		int expectedLocationsIndex = 0;
		for (int i = 0; i < GameEngine.BOARD_SIZE; i ++) {
			if(expectedLocations[expectedLocationsIndex] == i) {
				assert(visited[i] > 10);
				expectedLocationsIndex ++;
			}
			else if (visited[i] != 0) {
				fail("Invalid movement detected");
			}
		}
	}
	/*
	@Test
	public void testMovingChest() throws Exception {
		
	}
	@Test
	public void testChargeEnemy() throws Exception {
		
	}
	*/
}
