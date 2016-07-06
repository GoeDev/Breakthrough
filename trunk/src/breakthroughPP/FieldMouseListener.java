package breakthroughPP;

import breakthroughPP.DrawPanel;
import java.awt.event.*;


/** This class provides a MouseListener for the DrawPanel fields of the game 
	board. Only mouse click events are supported.
	@link java.awt.event.MouseListener
	@link breakthroughPP.DrawPanel
*/
public class FieldMouseListener implements MouseListener {
	
//private variables-------------------------------------------------------------
	private DrawPanel selected;
	
//Consructors-------------------------------------------------------------------
	/** Constructor, which initalises the DrawPanel.*/
	public FieldMouseListener() {
		selected = null;
	}
	
	
//Interface methods-------------------------------------------------------------
	/** Implements method mouseClicked(MouseEvent e) from the interface 
		MouseListener.
		@link java.awt.event.MouseEvent
		@link java.awt.event.MouseListener
	*/
	public void mouseClicked(MouseEvent e) {
		DrawPanel d = (DrawPanel) e.getSource();
 		int i = d.getI(); int j = d.getJ();
 		if (selected == null) {
 			//select the clicked field & mark it as selected
 			selected = d; 
 			d.setSelected(true);
 			d.repaint();

 		} else {
 			
 			//if clicked was selected then undo selection
 			if (selected.getI() == i && selected.getJ() == j) {
 				selected = null;
				d.setSelected(false);
				d.repaint();	
			} else {
 				
 				//if checkMove(redActive) valid !redActive and OK
				 			
				
				//else hint player no valid move
				selected.setSelected(false);
				selected.repaint();
				selected = null;			
 			}
 			
 		}
 	}
 	
 	/** Implements method mousePressed(MouseEvent e) from the interface
 		MouseListener.
 		@link java.awt.event.MouseEvent
		@link java.awt.event.MouseListener
 	*/	
 	public void mousePressed(MouseEvent e) {}
 	/** Implements method mouseReleased(MouseEvent e) from the interface
 		MouseListener.
 		@link java.awt.event.MouseEvent
		@link java.awt.event.MouseListener
 	*/
 	public void mouseReleased(MouseEvent e) {}
 	/** Implements method mouseExited(MouseEvent e) from the interface
 		MouseListener.
 		@link java.awt.event.MouseEvent
		@link java.awt.event.MouseListener
 	*/
 	public void mouseExited(MouseEvent e) {}
 	/** Implements method mouseEntered(MouseEvent e) from the interface
 		MouseListener.
 		@link java.awt.event.MouseEvent
		@link java.awt.event.MouseListener
 	*/
 	public void mouseEntered(MouseEvent e) {}
}
