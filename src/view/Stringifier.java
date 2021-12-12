package tp.p1.view;

import tp.p1.logic.Game;

public class Stringifier extends GamePrinter{ 	
	
	public Stringifier() {
		super();		
	}	
	
	public String toString(Game game) {		
		game.stringify();
		return "";		
	}
	
}
