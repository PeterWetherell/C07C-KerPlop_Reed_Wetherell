package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class ArcherEnemy extends GamePiece {

	public ArcherEnemy(int location) {
		super('A', "Archer: Shoots you. Can be blocked by anything.", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		int direction = (int) Math.signum(playerLocation - getLocation());
		for (int i = getLocation() + direction; i != playerLocation; i += direction ) {
			if (gameBoard[i] != null) {
				return InteractionResult.NONE;
			}
		}
		return InteractionResult.HIT;
	}
}
