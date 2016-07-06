package breakthroughPP.game.Player;

import breakthroughPP.preset.*;
import java.util.Random;

public class KIPlayer extends RandomPlayer implements Player{
	
	Status ok = new Status(Setting.OK);
	int[] moveRating = new int[24*18];
	Move[] myMoves;
	Move[] enemyMoves;
	int enemyPossibleMovesCount;
	
	public Move request() throws Exception{
		
		int[][] bufferBoard = BoardStatus;
		myMoves = findMoves();
		RandomPlayer enemy = new RandomPlayer();
		enemy.init(dimX,dimY,1-MYCOLOR);
		int bestMoveRating = 0;
		int bestMoveNr = 0;
		
		for(int i = 0; i < possibleMovesCount; i++){
			BoardStatus = bufferBoard;
			lastChosenMove = myMoves[i];
			confirm(ok);
			int[][] beforeEnemyBoard = BoardStatus;
			enemy.setBoard(BoardStatus);
			enemyMoves = enemy.findMoves();
			enemyPossibleMovesCount = enemy.getPossibleMovesCount();
			int min = 100;
			for(int j = 0; j < enemyPossibleMovesCount; j++){
				update(enemyMoves[j],ok);
				if(rate(BoardStatus) < min){
					min = rate(BoardStatus);
				}
				BoardStatus = beforeEnemyBoard;
			}
			if(min > bestMoveRating){
					bestMoveRating = min;
					bestMoveNr = i;
					
				}
		}
		BoardStatus = bufferBoard;
		return myMoves[bestMoveNr];
	}
	
	private int rate(int[][] boardStatus){
		int closestBlue = 24;
		int closestRed = 24;
		int blueLines = 0;
		int redLines = 0;
		boolean isRed = true;
		boolean isBlue = true;
		int redStones = 0;
		int blueStones = 0;
		for(int i = 0; i < dimX; i++){
			isBlue = true;
			isRed = true;
			for(int j = 0; j < dimY; j++){
				if(boardStatus[j][i] == Setting.RED){
					if(dimX - j - 1 < closestRed){
						closestRed = dimX - j -1;
					}
					isBlue = false;
					redStones += 1;
				}
				if(boardStatus[j][i] == Setting.BLUE){
					if(j > closestBlue){
						closestBlue = j;
					}
					isRed = false;
					blueStones += 1;
				}
				if(isRed){
					redLines += 1;
				}
				if(isBlue){
					blueLines += 1;
				}
			}
		}
		int redRating = (closestBlue - closestRed) + 2 * (redStones - blueStones) + 5 *(redLines - blueLines);
		if(MYCOLOR == Setting.RED){
			return redRating;
		}
		else{
			return (-1) * redRating;
		}	
	}
	
}