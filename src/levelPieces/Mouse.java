package levelPieces;

import java.util.ArrayList;
import java.util.Random;

import gameEngine.Drawable;
import gameEngine.Moveable;

public class Mouse implements Drawable {
	private Random r;
	private int location;
	public Mouse(int location) {
		r = new Random(System.currentTimeMillis());
		this.location = location;
	}

	@Override
	public void draw() {
		System.out.print('M');
	}

}
