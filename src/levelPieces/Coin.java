/**
 * @author Mabel Reed
 * @author Peter Wetherell
 * Date: 2/4/2024
 * Collaborators: None
 * Sources: None
 * Purpose: Awards the player with a point when in proximity
 */
package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class Coin extends GamePiece {
	
	private boolean isCollected;
	
	public Coin(int location) {
		super('*', "Coin (gives a point when collected then disappears)", location);
		isCollected = false;
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// Coins may only be collected once
		if (isCollected) {
			return InteractionResult.NONE;
		}
		
		// If the player is within one tile, award a point and disappear from the game board
		if (Math.abs(playerLocation - getLocation()) <= 1) {
			isCollected = true;
			gameBoard[getLocation()] = null;
			return InteractionResult.GET_POINT;
		}
		
		return InteractionResult.NONE;
	}
}
