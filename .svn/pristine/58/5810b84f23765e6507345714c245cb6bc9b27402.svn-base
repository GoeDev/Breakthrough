package breakthroughPP.game.Player;

import breakthroughPP.preset.*;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Testgame{
	
	public static void main(String args[]) throws Exception{
		
	
	
		
		Status whatever = new Status(0);
		RandomPlayer test = new RandomPlayer();
		RandomPlayer test2 = new RandomPlayer();
		test.init(4,4,Setting.BLUE);
		test2.init(4,4,Setting.RED);
		test.TestOutput();
		test2.TestOutput();
		
		while(test.getPossibleMovesCount() != 0){
			
			Move mv = test.request();
			test.confirm(whatever);
			test2.update(mv,whatever);
			test.TestOutput();
			mv = test2.request();
			test2.confirm(whatever);
			test.update(mv,whatever);
			test2.TestOutput();
			
		
		}
	}	
	
}