package breakthroughPP;

import javax.swing.*;
import java.awt.*;

/** This class extends JPanel and provides a field for the game board on which
	the stone of a player can be painted and where the player can click to
	perform his moves. 
	@link javax.swing.JPanel
*/
public class DrawPanel extends JPanel {

//private variables-------------------------------------------------------------
	private int i, j;
	private boolean free, red, selected;

	/** Constructor for a DrawPanel.
		@param i Horizontal position of this DrawPanel
		@param j Vertical position of this DrawPanel
	*/
	public DrawPanel(int i, int j) {
   		this.i = i;
   		this.j = j;
   		free = true;
   		red = false;
   		selected = false;
   	}
   	 	
   	 	
//Getter------------------------------------------------------------------------
	/** Getter method for I.
		@return Horizontal position of this DrawPanel
	*/
   	public int getI() {
   		return i;
   	}
   	
   	/** Getter method for J.
   		@return Vertical position of this DrawPanel
   	*/
   	public int getJ() {
   		return j;
   	}
   	
   	/** Getter method for red.
   		@return True if the stone on the panel is red and false if it is blue.
   	*/
   	public boolean isRed() {
   		return red;
   	}
   	
   	/** Getter method for free.
   		@return True if there is no stone on this panel else false.
   	*/
   	public boolean isFree() {
   		return free;
   	}
   	
//Setter------------------------------------------------------------------------
   	/** Setter method for selected.
   		@param b Defines if this panel is selected or not.
   		@see breakthroughPP.DrawPanel#paintComponent(Graphics g)
   	*/
   	public void setSelected(boolean b) {
   		selected = b;
   	}
   	
   	/** Setter for red.
   		Also sets free = false.
   	*/
   	public void setRed() {
   		red = true;
   		free = false;
   	}
   	
   	/** Setter for blue (which is the same as not red).
   		Also sets free = false. 
   	*/
   	public void setBlue() {
   		red = false;
   		free = false;
   	}
   	
   	/** Setter for free.
   		Sets free = true
   	*/
   	public void free() {
   		free = true;
   	}
   	
   	
 	/** Overwritten method of JPanel. Draws a border around the panel, a blue or
 		a red stone if it is not free.
		@link java.awt.Graphics
 		@link javax.swing.JPanel
 	*/
   	protected void paintComponent(Graphics g) {
   		super.paintComponent(g);
   		//Border around panel
   		setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
   		
   		//if free paint nothing more
   		if (free) {
   			return;
   		}
   		
   		//paint green border around panel if it is selected
   		if (selected)
   			setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
   		
   		//else paint stone as circle in red or blue in the middle of the panel
   		g.setColor(red ? Color.RED : Color.BLUE);
   		int rad = Math.min(getWidth(), getHeight()) / 2;
   		int x = getWidth() / 2;
   		int y = getHeight() / 2;
   		g.fillOval(x-rad, y-rad, x+rad, y+rad);		
   	}

}
