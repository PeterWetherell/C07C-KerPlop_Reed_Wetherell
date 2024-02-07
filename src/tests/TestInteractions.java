package tests;
import static org.junit.Assert.*;
import org.junit.Test;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.InteractionResult;
import levelPieces.ArcherEnemy;
import levelPieces.BearTrap;
import levelPieces.ChargeEnemy;
import levelPieces.Coin;
import levelPieces.Ghost;
import levelPieces.Mouse;
import levelPieces.MovingChest;
import levelPieces.SpearEnemy;

public class TestInteractions {
	@Test
	public void testMovingChest() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		MovingChest m = new MovingChest(5);
		gameBoard[5] = m;
		
		// Player should get point when touching the moving chest
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
		
		// Player should advance when touching the ghost
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
		
		// Player should die when touching the bear trap
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
	
	@Test
	public void testArcherEnemy() {
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		gameBoard[10] = new Mouse();
		ArcherEnemy a = new ArcherEnemy(15);
		gameBoard[15] = a;
		
		// Player should get hit when there is not an obstacle between it and the archer enemy
		for (int i = 0; i < GameEngine.BOARD_SIZE; i++) {
			InteractionResult ir = a.interact(gameBoard, i);
			if (i < 10) {
				assert(ir == InteractionResult.NONE);
			} else {
				assert(ir == InteractionResult.HIT);
			}
		}
	}
	
	@Test
	public void testChargeEnemy() {		
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		ChargeEnemy c = new ChargeEnemy(5);
		gameBoard[5] = c;
		
		// Player should get hit when within one tile of the charge enemy
		for (int i = 0; i < GameEngine.BOARD_SIZE; i ++) {
			InteractionResult ir = c.interact(gameBoard, i);
			if (i >= 4 && i <= 6) {
				assert(ir == InteractionResult.HIT);
			} else {
				assert(ir == InteractionResult.NONE);
			}
		}
	}
	
	@Test
	public void testCoin() {		
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		Coin c = new Coin(5);
		gameBoard[5] = c;
		
		// Player should get a point when within one tile of the coin; additionally, the coin should only
		// be able to be collected once, and the board at the coin should be set to null
		for (int i = 0; i < GameEngine.BOARD_SIZE; i ++) {
			InteractionResult ir = c.interact(gameBoard, i);
			if (i == 4) {
				assert(ir == InteractionResult.GET_POINT);
				assert(gameBoard[5] == null);
			} else {
				assert(ir == InteractionResult.NONE);
			}
		}
	}
	
	@Test
	public void testSpearEnemy() {		
		Drawable[] gameBoard = new Drawable[GameEngine.BOARD_SIZE];
		SpearEnemy s = new SpearEnemy(5);
		gameBoard[5] = s;
		
		// Player should get hit when exactly 2 tiles away from the spear enemy
		for (int i = 0; i < GameEngine.BOARD_SIZE; i ++) {
			InteractionResult ir = s.interact(gameBoard, i);
			if (i == 3 || i == 7) {
				assert(ir == InteractionResult.HIT);
			} else {
				assert(ir == InteractionResult.NONE);
			}
		}
	}
}
