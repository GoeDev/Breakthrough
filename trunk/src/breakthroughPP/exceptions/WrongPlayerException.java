package breakthroughPP.exceptions;

import breakthroughPP.preset.Setting;

public class WrongPlayerException extends Exception{

	public WrongPlayerException(String msg) {
		super(msg);
	}

	public WrongPlayerException(Integer color) {
			this("Player "+(color == Setting.RED ? "red" : "blue" ) + " is not"+
			" the active Player at the moment");
	}

}
