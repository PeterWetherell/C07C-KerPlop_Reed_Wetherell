/**
 * @author Mabel Reed
 * @author Peter Wetherell
 * Date: 2/4/2024
 * Collaborators: None
 * Sources: None
 * Purpose: Piece that is drawable
 */
package levelPieces;

import gameEngine.Drawable;

public class Mouse implements Drawable {
	@Override
	public void draw() {
		System.out.print('M');
	}

}
