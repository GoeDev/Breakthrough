package breakthroughPP.demo;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.net.*;

import breakthroughPP.preset.*;

public class NetPlayer extends UnicastRemoteObject implements Player {
    public NetPlayer(Player player) throws RemoteException {
	this.player = player;
    }
	
    public Move request() throws Exception, RemoteException {
	return player.request();
    }
	
    public void update(Move opponentMove, Status boardStatus)
	throws Exception, RemoteException {
	player.update(opponentMove, boardStatus);
    }
	
    public void confirm(Status boardStatus)
	throws Exception, RemoteException {
	player.confirm(boardStatus);
    }		
	
    public void init(int dimX, int dimY, int color)
	throws Exception, RemoteException {
	player.init(dimX, dimY, color);	
    } 
	
    // ---------------------------------------------
    private Player player;
}
