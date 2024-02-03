package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class LevelSetup {
	
	private ArrayList<Moveable> movingPieces = new ArrayList<>();
	private ArrayList<GamePiece> interactingPieces = new ArrayList<>();
	private Drawable[] board;
	private int startLoc;

	public void createLevel(int levelNum) {
		switch (levelNum) {
		case 1:
			board = new Drawable[10];
			break;
		case 2:
			board = new Drawable[15];
			break;
		}
	}

	public Drawable[] getBoard() {
		// TODO Auto-generated method stub
		return board;
	}

	public ArrayList<Moveable> getMovingPieces() {
		// TODO Auto-generated method stub
		return movingPieces;
	}

	public ArrayList<GamePiece> getInteractingPieces() {
		// TODO Auto-generated method stub
		return interactingPieces;
	}

	public int getPlayerStartLoc() {
		// TODO Auto-generated method stub
		return startLoc;
	}

}
