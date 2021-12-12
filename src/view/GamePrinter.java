package tp.p1.view;

import tp.p1.logic.Game;

public abstract class GamePrinter {		
		Game game;

		public void setGame(Game g){
			this.game = g;
		} 
		
		public String toString(Game game) {
			return "";		
		}
}
