/**
 * @author Mabel Reed
 * @author Peter Wetherell
 * Date: 2/4/2024
 * Collaborators: None
 * Sources: None
 * Purpose: Hits the player when there is nothing between them
 */
package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class ArcherEnemy extends GamePiece {

	public ArcherEnemy(int location) {
		super('A', "Archer: Shoots you. Can be blocked by anything.", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		// Checks for obstacles in the direction of the player
		int direction = (int) Math.signum(playerLocation - getLocation());
		for (int i = getLocation() + direction; i != playerLocation; i += direction ) {
			if (gameBoard[i] != null) {
				return InteractionResult.NONE;
			}
		}
		return InteractionResult.HIT;
	}
}
