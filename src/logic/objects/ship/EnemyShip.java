package tp.p1.logic.objects.ship;

import tp.p1.logic.Game;
import tp.p1.logic.objects.Move;

public abstract class EnemyShip extends Ship{
	
	Move move;	
	
	public EnemyShip(Game game,int x, int y, int live) {
		super(game, x, y, live);		
	}
	
	public boolean receiveMissileAttack(int damage) {
		
		this.getDamage(damage);
		return true;		
	}
	
	public boolean receiveShockWaveAttack(int damage) {
		if(game.shipG.isHasShockWave()) {			
			this.getDamage(damage);
			return true;
		}
		
		
		return false;
	}
	
	
}
