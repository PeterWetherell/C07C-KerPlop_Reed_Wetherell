package levelPieces;

import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class MovingChest extends GamePiece implements Moveable {
	private Random r;
	
	public MovingChest(char symbol, String label, int location) {
		super(symbol, label, location);
		r = new Random(System.nanoTime());
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		int newLocation = getLocation() + r.nextInt() % 3 - 1;
		if (newLocation > 0 && newLocation < gameBoard.length - 1 && gameBoard[newLocation] == null) {
			gameBoard[newLocation] = this;
			gameBoard[getLocation()] = null;
			setLocation(newLocation);
		}
	}
}
