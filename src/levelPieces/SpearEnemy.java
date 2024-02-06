/**
 * @author Mabel Reed
 * @author Peter Wetherell
 * Date: 2/4/2024
 * Collaborators: None
 * Sources: None
 * Purpose: Piece that attacks the player when 2 tiles away
 */
package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class SpearEnemy extends GamePiece {

	public SpearEnemy(int location) {
		super('S', "Spear Enemy (Attacks player when 2 tiles away)", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (Math.abs(playerLocation - getLocation()) == 2) {
			return InteractionResult.HIT;
		}
		
		return InteractionResult.NONE;
	}

}