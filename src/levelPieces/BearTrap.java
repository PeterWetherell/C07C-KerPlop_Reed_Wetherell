package levelPieces;

import gameEngine.Drawable;
import gameEngine.InteractionResult;

public class BearTrap extends GamePiece {

	public BearTrap(int location) {
		super('^', "BearTrap: If you step on it you die.", location);
	}

	@Override
	public InteractionResult interact(Drawable[] gameBoard, int playerLocation) {
		if (getLocation() == playerLocation) {
			return InteractionResult.KILL;
		}
		return InteractionResult.NONE;
	}
}
