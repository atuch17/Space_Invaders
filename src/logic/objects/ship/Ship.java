package tp.p1.logic.objects.ship;

import tp.p1.logic.Game;
import tp.p1.logic.objects.*;
public abstract class Ship extends GameObject{
	
	public int resistencia;
	UCMShip ship;
			
	public Ship(Game game,int x, int y,int live) {
		super(game, x, y, live);
	}	
}
