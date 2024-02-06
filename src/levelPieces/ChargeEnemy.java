/**
 * @author Mabel Reed
 * @author Peter Wetherell
 * Date: 2/4/2024
 * Collaborators: None
 * Sources: None
 * Purpose: Moves towards the player and attacks when in proximity
 */
package levelPieces;
import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class ChargeEnemy extends GamePiece implements Moveable {

	public ChargeEnemy(int location) {
		super('E', "Charge Enemy (Moves towards the player)", location);
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// Move in the direction of the player if the square is empty
		int newLocation = getLocation() + (int) Math.signum(playerLocation - getLocation());
		if (newLocation != playerLocation && newLocation >= 0 && newLocation < gameBoard.length && gameBoard[newLocation] == null) {
			gameBoard[getLocation()] = null;
			gameBoard[newLocation] = this;
			setLocation(newLocation);
		}
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(getLocation() - playerLocation) <= 1) {
			return InteractionResult.HIT;
		}
		return InteractionResult.NONE;
	}

}
