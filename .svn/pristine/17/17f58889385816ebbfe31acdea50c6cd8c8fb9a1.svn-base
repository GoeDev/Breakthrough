package breakthroughPP.game.ui;

import breakthroughPP.game.*;
import breakthroughPP.preset.*;

/** This class implements the interface Viewer and provides information about 
	the GameBoard to visualize it.
	@link breakthroughPP.game.GameBoard
*/
public class BoardViewer implements Viewer {

	private GameBoard b;
	private int x, y;

	public BoardViewer(GameBoard b) {
		this.b = b;
		x = b.getX();
		y = b.getY();
	}

	public int turn() {
		return b.getActive();
	}
	
	public int getDimX() {
		return x;
	}
	
	public int getDimY() {
		return y;
	}
	
	public int getColor(int letter, int number) {
		try {
			Position p = new Position(letter, number);
			return b.getColor(p);
		} catch (PresetException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public Status getStatus() {
		return b.getGameStatus();
	}

}
