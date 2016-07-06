package breakthroughPP.game;

import breakthroughPP.preset.*;
import breakthroughPP.exceptions.*;
import java.util.ArrayList;

/** This class controls the game and exports a method which takes the players
	moves. 
	@link breakthroughPP.preset.Move
	@link breakthroughPP.preset.Setting
	@link breakthroughPP.exceptions
	*/
public class GameBoard implements Setting{


//private static final----------------------------------------------------------
	private static final int MIN_M = 6,MAX_M = 26, MIN_N = 2, MAX_N = 26; 


//private fields----------------------------------------------------------------
	private int fields[][];
	private Status stat;
	private int active;

//Constructors------------------------------------------------------------------
	/** Constructor for the game board with size mxn.
		Throws an IndexOutOfBoundsException if the size is out of the minimum 
		and maximum range of rows and columns (see private finals).
		@param m Number of rows
		@param n Number of columns
		@throws java.lang.IndexOutOfBoundsException
	*/
	public GameBoard(int m, int n) throws IndexOutOfBoundsException {
		if (m < MIN_M || m > MAX_M || n < MIN_N || n > MAX_N)
			throw new IndexOutOfBoundsException("The parameters m and n must "+
			"be in range of "+MIN_M+"x"+MIN_N+" and "+MAX_M+"x"+"MAX_N");
		
		//init fields with stones
		fields = new int[m][n];
		int k = (m+3)/4; 	//k rows with stones at beginning of the game
		for (int i = 0; i < m; i++) 	
			for (int j = 0; j < n; j++) {
				if (i < k)
					fields[i][j] = RED;
				else if (i > m-k)
					fields[i][j] = BLUE;
				else
					fields[i][j] = NONE;
			}
		
		//Red player begins
		active = RED;
				
				
	}

	
	/** This method takes the moves of the players and evaluates them.
		@param m Move which a player wants to make
		@param color Color of the player
		@throws java.lang.IllegalArgumentException
		@throws breakthroughPP.exceptions.WrongPlayerException
	*/
	public void makeMove(Move m, int color) throws WrongPlayerException {
		if (color != RED && color != BLUE) { //color is no legal argument
			stat.setStatus(ILLEGAL);
			throw new IllegalArgumentException("The argument color has not the "
			+"value of Setting.RED or Setting.BLUE");
		}
		if (active != color) {	//wrong player wants to make a move
			stat.setStatus(ILLEGAL);
			throw new WrongPlayerException(color);	
		}
		
		//null means that one player surrendered
		if (m == null) {
			if (color == RED)
				stat.setStatus(BLUE_WIN);
			else
				stat.setStatus(RED_WIN);
			return;
		}
		
		//check if the move is valid
		Position s = m.getStart();
		Position e = m.getEnd();
		int r = e.getNumber();
		int c = e.getLetter();
		if (Math.abs(s.getLetter() - c) > 1) {
			stat.setStatus(ILLEGAL);	//Move over two or more columns
			return;
		}
		if (color == RED) {
		//Red player
			if (r - s.getNumber() != 1) {
				stat.setStatus(ILLEGAL);	//Move is not one row upwards 
				return;
			}
			
			if (fields[r][c] == RED) {
				stat.setStatus(ILLEGAL);	//On destination field is red stone
				return;
			}
			
			if (fields[r][c] == BLUE && c - s.getLetter() == 0) {
				stat.setStatus(ILLEGAL);	//Can only beat diagonally
				return;						//not forward
			}
				
			if (r == fields.length - 1)
				stat.setStatus(RED_WIN);	//BREAKTHROUGH!
			else
				stat.setStatus(OK);	
				
			//change active player to blue
			active = BLUE;
		}
		else {
		//Blue player
			if (s.getNumber() - r != 1) {
				stat.setStatus(ILLEGAL);	//Move is not one row downwards
				return;
			}
			
			if (fields[r][c] == BLUE) {
				stat.setStatus(ILLEGAL);	//On destination field is blue stone
				return;
			}
			if (fields[r][c] == RED && c - s.getNumber() == 0) {
				stat.setStatus(ILLEGAL);	//Can only beat diagonally
				return;
			}
			
			if (r == 0)
				stat.setStatus(BLUE_WIN);	//BREAKTHROUGH!
			else
				stat.setStatus(OK);
			
			//change active player to red
			active = RED;
		}
		
		//free start position
		fields[r][c] = color;
		fields[s.getNumber()][s.getLetter()] = NONE;
	}
	
	
	/** Getter method for the actual status of the GameBoard.
		@return Actual Status of the GameBoard
		@link breakthroughPP.preset.Status
	*/
	public Status getGameStatus() {
		return stat;
	}
	
	
	
	/** This method will give a player all the possible and valid moves he could
		do at this moment.
		@param color The color of the Player (Setting.RED/BLUE)
		@return Array of possible and valid moves the player with the color in
		color can make now.
		@throws java.lang.IllegalArgumentException
		@link breakthroughPP.preset.Setting
	*/
	public Move[] getPossibleMoves(int color) {
		Move[] moves = null;
		if (color != RED && color != BLUE)		//color is no legal argument
			throw new IllegalArgumentException("The argument color has not the "
			+"value of Setting.RED or Setting.BLUE");	
		
		Position[] stonepos = getStonePositions(color);
		
		for (int k = 0; k < stonepos.length; k++) {
			Position pos = stonepos[k];
			if (color == RED) {
			//Red player possible moves
				
			
			}
			else {
			//Blue player possible moves
		
		
			}
		}
		
		return moves;
	}
	

	/** This method returns all Positions on the GameBoard where a Stone with 
		the matching color sit
		@param color The color of the stones which shall be in the Position[]
		@return Array of all positions where stones with matching color sit
		@see java.util.ArrayList
	*/
	private Position[] getStonePositions(int color) {
		Position pos[] = null, p;
		ArrayList<Position> list = new ArrayList<Position>();
		
		if (color != RED && color != BLUE)		//color is no legal argument
			throw new IllegalArgumentException("The argument color has not the "
			+"value of Setting.RED or Setting.BLUE");
		
		try {
			for (int i = 0; i < fields.length; i++)
				for (int j = 0; j < fields[0].length; j++)
					if (fields[i][j] == color)	//color matches so add to list
						list.add(new Position(i, j));
					
		} catch (PresetException e) {
			e.printStackTrace();
			return null;
		}
	
		//make sure that the lists capacity is only as big as its size and then
		//convert it to an array and return the array
		list.trimToSize();	
		pos = list.toArray(pos);					
		return pos;
	}
	
	/** Getter for */
	public int getActive() {
		return active;
	}
	
	/** Getter*/
	public int getX() {
		return fields[0].length;
	}
	
	public int getY() {
		return fields.length;
	}
	
	public int getColor(Position p) {
		return fields[p.getNumber()][p.getLetter()];
	}
}
