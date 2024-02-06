package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.BearTrap;
import levelPieces.Ghost;
import levelPieces.MovingChest;

public class TestInteractions {
	@Test
	public void testMovingChest() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		MovingChest m = new MovingChest(5);
		gameBoard[5] = m;
		for (int i = 0; i < GameEngine.BOARD_SIZE; i ++) {
			InteractionResult ir = m.interact(gameBoard, i);
			if (i == 5) {
				assert(ir == InteractionResult.GET_POINT);
			}
			else {
				assert(ir == InteractionResult.NONE);
			}
		}
	}
	@Test
	public void testGhost() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Ghost g = new Ghost(5);
		gameBoard[5] = g;
		for (int i = 0; i < GameEngine.BOARD_SIZE; i ++) {
			InteractionResult ir = g.interact(gameBoard, i);
			if (i == 5) {
				assert(ir == InteractionResult.ADVANCE);
			}
			else {
				assert(ir == InteractionResult.NONE);
			}
		}
	}
	@Test
	public void testBearTrap() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		BearTrap b = new BearTrap(5);
		gameBoard[5] = b;
		for (int i = 0; i < GameEngine.BOARD_SIZE; i ++) {
			InteractionResult ir = b.interact(gameBoard, i);
			if (i == 5) {
				assert(ir == InteractionResult.KILL);
			}
			else {
				assert(ir == InteractionResult.NONE);
			}
		}
	}
}
