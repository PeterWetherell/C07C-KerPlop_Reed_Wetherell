package levelPieces;

import java.util.ArrayList;

import gameEngine.Drawable;
import gameEngine.GameEngine;
import gameEngine.Moveable;

public class LevelSetup {
	
	private ArrayList<Moveable> movingPieces = new ArrayList<>();
	private ArrayList<GamePiece> interactingPieces = new ArrayList<>();
	private Drawable[] board;
	private int startLoc;

	public void createLevel(int levelNum) {
		board = new Drawable[GameEngine.BOARD_SIZE];
		movingPieces.clear();
		interactingPieces.clear();
		
		GamePiece p;
		switch (levelNum) {
		case 1:
			board[3] = new Mouse();
			p = new MovingChest(1);
			board[1] = p;
			interactingPieces.add(p);
			movingPieces.add((Moveable) p);
			p = new ChargeEnemy(5);
			board[5] = p;
			interactingPieces.add(p);
			movingPieces.add((Moveable) p);
			startLoc = 10;
			p = new Coin(19);
			board[19] = p;
			interactingPieces.add(p);
			p = new Coin(20);
			board[20] = p;
			interactingPieces.add(p);
			break;
		case 2:
			p = new Ghost(5);
			board[5] = p;
			interactingPieces.add(p);
			movingPieces.add((Moveable) p);
			p = new ArcherEnemy(8);
			board[8] = p;
			interactingPieces.add(p);
			p = new BearTrap(15);
			board[15] = p;
			interactingPieces.add(p);
			p = new SpearEnemy(10);
			board[10] = p;
			interactingPieces.add(p);
			startLoc = 17;
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
