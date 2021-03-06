package breakthroughPP.game.Player;

import breakthroughPP.preset.*;
import java.util.Random;

/**
 * Die KI Klasse die zufälig gültige Züge benutzt
 * @author Jonas Koopmann
 */

public class RandomPlayer implements Player{

	//settings.color ergänzen

	int MYCOLOR;
	int ISEMPTY = 5;
	int ENEMYCOLOR;

	int dimX = 0;
	int dimY = 0;
	int[][] BoardStatus;
	Move[] possibleMoves = new Move[24*18];
	int possibleMovesCount = 1;
	Move lastChosenMove;

	/**
	 *Verlangt einen Zug vom Spieler
	 *Ist kein gültiger mehr Zug mehr ausführbar wird der letzte ausgeführte Zug erneut zurückgegeben
	 *@param
	 *@return Ein zufällig ausgewählter gültiger Zug wird zurückgegeben
	 */
	public Move request() throws Exception {

		possibleMovesCount = 0;
		findMoves();
		if(possibleMovesCount > 0){
			Random RNG = new Random();
			int chosenMove = RNG.nextInt(possibleMovesCount);
			lastChosenMove = possibleMoves[chosenMove];
			return possibleMoves[chosenMove];
		}
		else{
			return lastChosenMove;
		}
	}

	/**
	 *Bestätigt dem Spieler die Gültigkeit seines letzten Zuges, und enthält Informationen zum Ende des Spiels
	 *@param boardStatus Siehe boardStatus.isOk() für die Gültigkeit des letztes Zuges und .isRedWin() für Siegabfrage
	 *@return */
	public void confirm(Status boardStatus) throws Exception {

		Position fromPosition = lastChosenMove.getStart();
		Position toPosition = lastChosenMove.getEnd();
		BoardStatus[fromPosition.getLetter()][fromPosition.getNumber()] = ISEMPTY;
		BoardStatus[toPosition.getLetter()][toPosition.getNumber()] = MYCOLOR;

		return;
	}

	/**
	 * Der Spieler wird ueber eine Aenderung des Spielbretts informiert
	 * @param opponentMove Der Zug des Gegners der auf dem Spielbrett vermerkt werden muss
	 * @param boardStatus Siegabfrage und Gültigkeit des Spielbretts
	 * @return
	 */
	public void update(Move opponentMove, Status boardStatus) throws Exception {
		Position fromPosition = opponentMove.getStart();
		Position toPosition = opponentMove.getEnd();
		BoardStatus[fromPosition.getLetter()][fromPosition.getNumber()] = ISEMPTY;
		BoardStatus[toPosition.getLetter()][toPosition.getNumber()] = ENEMYCOLOR;
		return;
	}

	/**
	 * Initialisierung des dem Spieler eigenen Spielbretts. Grundlage der Zugberechnungen
	 * Init prüft nicht die Gültigkeit der Dimensionen, man achte also auf korrekte Initialisierung
	 * @param dimX Vertikale Groeße des Spielfelds
	 * @param dimY Horizontale Groeße des Spielfelds
	 * @param color Initialisiert den Spieler mit der übergebenen Farbe
	 * @return
	 */
	public void init(int dimX, int dimY, int color) throws Exception {
		this.dimY = dimY;
		this.dimX = dimX;
		MYCOLOR = color;
		ENEMYCOLOR = 1 - color;
		lastChosenMove = new Move(new Position(0,0), new Position(0,0));
		BoardStatus = new int[dimX][dimY];
		int StartRowCount = (int) ((dimX + 3) / 4);
		for(int i = 0; i < dimX; i++){
			for(int j = 0; j < dimY; j++){
					BoardStatus[i][j] = ISEMPTY;
				if(i < StartRowCount){
					if(MYCOLOR == Setting.BLUE){
						BoardStatus[i][j] = ENEMYCOLOR;
					}
					else{
						BoardStatus[i][j] = MYCOLOR;
					}
				}
				if(i + StartRowCount >= dimX){
					if(MYCOLOR == Setting.BLUE){
						BoardStatus[i][j] = MYCOLOR;
					}
					else{
						BoardStatus[i][j] = ENEMYCOLOR;
					}
				}
			}
		}
		return;
	}

	public Move[] findMoves() throws Exception{
		possibleMovesCount = 0;
		for(int i = 0; i < dimX; i++){
			for(int j = 0; j < dimY; j++){
				if(BoardStatus[i][j] == MYCOLOR){
					//vorne
					if(i < dimX - 1){
						if(BoardStatus[i+1][j] == ISEMPTY && MYCOLOR == Setting.RED){
						possibleMoves[possibleMovesCount] = new Move(new Position(i,j), new Position(i+1,j));
						possibleMovesCount += 1;
					}
					}
					//unten
					if(i > 0){
						if(BoardStatus[i-1][j] == ISEMPTY && MYCOLOR == Setting.BLUE){
						possibleMoves[possibleMovesCount] = new Move(new Position(i,j), new Position(i-1,j));
						possibleMovesCount += 1;
					}
					}
					//vorne rechts
					if(j + 1 < dimY && i < dimX -1){
						if(BoardStatus[i+1][j+1] != MYCOLOR && MYCOLOR == Setting.RED){
							possibleMoves[possibleMovesCount] = new Move(new Position(i,j), new Position(i+1,j+1));
							possibleMovesCount += 1;
						}
					}
					//unten rechts
					if(j + 1 < dimY && i > 0){
						if(BoardStatus[i-1][j+1] != MYCOLOR && MYCOLOR == Setting.BLUE){
							possibleMoves[possibleMovesCount] = new Move(new Position(i,j), new Position(i-1,j+1));
							possibleMovesCount += 1;
						}
					}
					//vorne links
					if(j > 0 && i < dimX -1){
						if(BoardStatus[i+1][j-1] != MYCOLOR && MYCOLOR == Setting.RED){
							possibleMoves[possibleMovesCount] = new Move(new Position(i,j), new Position(i+1,j-1));
							possibleMovesCount += 1;
						}
					}
					//unten links
					if(j > 0 && i > 0){
						if(BoardStatus[i-1][j-1] != MYCOLOR && MYCOLOR == Setting.BLUE){
							possibleMoves[possibleMovesCount] = new Move(new Position(i,j), new Position(i-1,j-1));
							possibleMovesCount += 1;
						}
					}

				}
			}
		}
		return possibleMoves;
	}

//**********************************************
/** Test Functions
 * Gibt das Spielfeld des Players sowie seinen letzten zug aus
 * Für Debug Zwecke
 */
	public void TestOutput(){

		for(int i = dimX -1; i >= 0; i--){
			System.out.println("\n");
			for(int j = 0; j < dimY; j++){
				System.out.print(Integer.toString(BoardStatus[i][j]));
			}
		}
		System.out.println("");
		System.out.println(lastChosenMove.toString());
		for(int i = -1; i < possibleMovesCount; i++){
			//System.out.println(possibleMoves[i].toString());
		}
	}

	int getPossibleMovesCount(){
		return possibleMovesCount;
	}
	public void setBoard(int[][] board){
		BoardStatus = board;
	}


}
