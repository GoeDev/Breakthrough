package breakthroughPP;

import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;


/** This class provides the frame on which all fields of the game are displayed
	and where the player can do his moves via mouse clicks.
	@link java.awt.event.ActionListener
*/
public class Board implements ActionListener {

//private finals----------------------------------------------------------------
	private final int WIDTH = 500;
	private final int HEIGHT = 540;
 	
//private variables-----------------------------------------------------
	private JFrame frame;
	private JPanel panel, head, bottom, fields;
	private JPanel f[][];
	private JButton exit;
	private FieldMouseListener fml;

	
//Consructors-------------------------------------------------------------------
	/** Constructor for the game board which initialises the GUI and the board.
		@param row Number of rows of fields. 
		@param col Number of columns of fields.*/
	public Board(int row, int col) {
		//JFrame
		frame = new JFrame("Board");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
	
		//JPanels
		panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.add(panel);
		
		head = new JPanel();
		//head.setLayout(new BoxLayout(head, BoxLayout.X_AXIS));
		head.setPreferredSize(new Dimension(WIDTH,20));
		panel.add(head, BorderLayout.NORTH);
		
		bottom = new JPanel();
		bottom.setLayout(new BorderLayout());
		bottom.setPreferredSize(new Dimension(WIDTH,20));
		panel.add(bottom, BorderLayout.SOUTH);
		
		//fields = new GamePanel(this);
		fields = new JPanel();
		fields.setLayout(new GridLayout(row, col));
		panel.setPreferredSize(new Dimension(WIDTH,WIDTH));
		fields.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
		
		f = new DrawPanel[row][col];
		fml = new FieldMouseListener();
		for (int i = 0; i < f.length; i++)
			for (int j = 0; j < f[0].length; j++) {
				f[i][j] = new DrawPanel(i,j);
				if (i >= 0 && i < 2) {
					((DrawPanel) f[i][j]).setBlue();
				}
				if (i >= f.length - 2) {
					((DrawPanel) f[i][j]).setRed();
				}
				f[i][j].addMouseListener(fml); 
				f[i][j].setPreferredSize(new Dimension(WIDTH/col,HEIGHT/row));
				fields.add(f[i][j]);
			}

		panel.add(fields, BorderLayout.CENTER);
		
		//JButtons
		exit = new JButton("Exit");
		exit.setToolTipText("Click this to exit the Game.");
		exit.addActionListener(this);
		bottom.add(exit, BorderLayout.EAST);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	
	/** Implements the abstract method actionPerformed(ActionEvent e) from the
		interface ActionListener.
	 	@param e The ActionEvent object which is evoked from an action performed
	 	on one component which adds this ActionListener
	 	@link java.awt.event.ActionEvent
	 	@link java.awt.event.ActionListener
	 	*/
	public void actionPerformed(ActionEvent e) {
    	if (e.getSource() == exit) {
    		frame.dispatchEvent(
    				new WindowEvent(frame,WindowEvent.WINDOW_CLOSING));
			System.exit(0);
       	}
    }

	public static void main(String args[]) {
		Board b = new Board(8,8);
	}
}


