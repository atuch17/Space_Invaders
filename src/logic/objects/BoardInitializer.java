package tp.p1.logic.objects;

import tp.p1.logic.*;
import tp.p1.logic.objects.ship.DestroyerShip;
import tp.p1.logic.objects.ship.Ovni;
import tp.p1.logic.objects.ship.RegularShip;
public class BoardInitializer {
	
	private Level level ;
	private GameObjectBoard board;
	private Game game;
	
	public GameObjectBoard initialize(Game game, Level level) {
		this.level = level;
		this.game = game;
		board = new GameObjectBoard(Game.DIM_X, Game.DIM_Y);
		initializeOvni () ;
		initializeRegularAliens () ;
		initializeDestroyerAliens () ;
		return board;
	}
	private void initializeOvni () { 
		board.add(new Ovni(game,false));
	}
	
	private void initializeRegularAliens () {
		
		int j=0;
		for(int i=0; i< level.getNumRegularAliens(); i++) {
			if(i<=3) {
				board.add(new RegularShip(game,1,3+i,2));
			}
			else {
				board.add(new RegularShip(game,2,3+j,2));
				j++;
			}
		}	
	} 
	
private void initializeDestroyerAliens () {
		if(level == Level.EASY) {
			for(int i=0; i< level.getNumDestroyerAliens(); i++) {
				board.add(new DestroyerShip(game,2,4+i,1));
			}
		}else if(level == Level.HARD){
			for(int i=0; i< level.getNumDestroyerAliens(); i++) {
				board.add(new DestroyerShip(game,3,4+i,1));
			}
		}
		else if(level == Level.INSANE){
			for(int i=0; i< level.getNumDestroyerAliens(); i++) {
				board.add(new DestroyerShip(game,3,3+i,1));
			}
		}
	}
}
