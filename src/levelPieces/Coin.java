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
		if (isCollected) {
			return InteractionResult.NONE;
		}
		
		if (Math.abs(playerLocation - getLocation()) <= 1) {
			isCollected = true;
			gameBoard[getLocation()] = null;
			return InteractionResult.GET_POINT;
		}
		
		return InteractionResult.NONE;
	}
}
