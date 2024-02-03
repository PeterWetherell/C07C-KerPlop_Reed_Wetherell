package levelPieces;

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
		int newLocation = getLocation() + r.nextInt() % 3 - 1;
		if (newLocation > 0 && newLocation < gameBoard.length - 1 && gameBoard[newLocation] == null) {
			gameBoard[newLocation] = this;
			gameBoard[getLocation()] = null;
			setLocation(newLocation);
		}
	}
}
