package levelPieces;

import java.util.ArrayList;
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.InteractionResult;
import gameEngine.Moveable;

public class Ghost extends GamePiece implements Moveable {
	private Random r;
	
	public Ghost(int location) {
		super('G', "Ghost: Teleports (If you touch -> advance)", location);
		r = new Random(System.nanoTime());
	}
	
	@Override
	public InteractionResult interact(Drawable [] gameBoard, int playerLocation) {
		if (playerLocation == getLocation()) {
			return InteractionResult.ADVANCE;
		}
		return InteractionResult.NONE;
	}

	@Override
	public void move(Drawable[] gameBoard, int playerLocation) {
		// TODO Auto-generated method stub
		ArrayList<Integer> emptyIndex = new ArrayList<>();
		emptyIndex.add(getLocation());
		for (int i = 0; i < gameBoard.length; i ++) {
			if (gameBoard[i] == null) {
				emptyIndex.add(i);
			}
		}
		int newLocation = emptyIndex.get(Math.abs(r.nextInt()) % emptyIndex.size());
		gameBoard[getLocation()] = null;
		gameBoard[newLocation] = this;
		setLocation(newLocation);
	}
}
