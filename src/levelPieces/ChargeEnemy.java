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
