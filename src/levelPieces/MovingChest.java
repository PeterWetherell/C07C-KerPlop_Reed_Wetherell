package levelPieces;
/**
 * @author Mabel Reed
 * @author Peter Wetherell
 * Date: 2/4/2024
 * Collaborators: None
 * Sources: None
 * Purpose: Piece that awards points when the player catches it
 */
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class MovingChest extends GamePiece implements Moveable {
	private Random r;
	
	public MovingChest(int location) {
		super('C', "Moving Chest (Moves randomly)", location);
		r = new Random(System.nanoTime());
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == getLocation()) {
			return InteractionResult.GET_POINT;
		}
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {	
		// Moves one square to the left or right randomly, or doesn't move at all
		int newLocation = getLocation() + Math.abs(r.nextInt()) % 3 - 1;
		if (newLocation >= 0 && newLocation < gameBoard.length && gameBoard[newLocation] == null) {
			gameBoard[newLocation] = this;
			gameBoard[getLocation()] = null;
			setLocation(newLocation);
		}
	}
}
