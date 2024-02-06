package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import levelPieces.ChargeEnemy;
import levelPieces.Ghost;
import levelPieces.Mouse;
import levelPieces.MovingChest;

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
	
	@Test
	public void testMovingChest() throws Exception {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[5] = new Mouse();
		
		// expect moving chest to get stuck on the left side of the board
		// and move left, right, or not at all at about the same frequency
		MovingChest c = new MovingChest(2);
		gameBoard[2] = c;
		
		int[] moveDirections = new int[3];

		for (int i = 0; i < 500; i ++) { //loop 500 times and move the chest
			int loc = c.getLocation();
			c.move(gameBoard, 10);
			
			assert(c.getLocation() >= 0 && c.getLocation() < 5);
			
			moveDirections[1 - (int) (Math.signum(c.getLocation() - loc))]++;
		}
		
		// check the movement is good
		assert(moveDirections[0] > 100);
		assert(moveDirections[1] > 100);
		assert(moveDirections[2] > 100);
		
		// Check that the moving chest doesn't move off the right side of the board
		gameBoard[19] = new Mouse();
		MovingChest c2 = new MovingChest(20);
		gameBoard[20] = c2;
		
		for (int i = 0; i < 100; i++) {
			c2.move(gameBoard, 0);
			assert(c2.getLocation() == 20);
		}
		
		// Check that the moving chest gets stuck between 2 mice
		gameBoard[15] = new Mouse();
		MovingChest c3 = new MovingChest(16);
		gameBoard[16] = c3;
		gameBoard[17] = new Mouse();
		
		for (int i = 0; i < 100; i++) {
			c3.move(gameBoard, 0);
			assert(c3.getLocation() == 16);
		}
	}
	
	@Test
	public void testChargeEnemy() throws Exception {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[10] = new Mouse();
		ChargeEnemy c = new ChargeEnemy(0);
		gameBoard[0] = c;
		//see if the ChargeEnemy moves towards player
		for (int i = 0; i < 9; i ++) {
			int loc = c.getLocation();
			c.move(gameBoard, 11); //player on other side of mouse
			assert(c.getLocation() == loc+1); //check it is moving towards them
		}
		for (int i = 0; i < 10; i ++) {
			c.move(gameBoard, 11); 
			assert(c.getLocation() == 9); //check it respects the mouse
		}

		ChargeEnemy c2 = new ChargeEnemy(GameEngine.BOARD_SIZE-1);
		gameBoard[GameEngine.BOARD_SIZE-1] = c2;
		gameBoard[17] = new Mouse();
		//see if the ChargeEnemy moves towards player
		for (int i = 0; i < 2; i ++) {
			int loc = c2.getLocation();
			c2.move(gameBoard, 11); //player on other side of mouse
			assert(c2.getLocation() == loc-1); //check it is moving towards them
		}
		for (int i = 0; i < 10; i ++) {
			c2.move(gameBoard, 11); 
			assert(c2.getLocation() == 18); //check it respects the mouse
		}
		
		//check enemy doesn't move into player
		ChargeEnemy c3 = new ChargeEnemy(16);
		gameBoard[16] = c3;
		c3.move(gameBoard, 15);
		assert(c3.getLocation()==16);
	}
	
}
