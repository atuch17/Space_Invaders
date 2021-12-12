package tp.p1.logic.objects.weapon;

import tp.p1.logic.Game;
import tp.p1.logic.objects.*;
public abstract class Weapon extends GameObject{

	Move move;
	
	public Weapon(Game game,int x, int y,int live) {
		super(game, x, y, 1);
	}

	@Override
	public void move() {		
		if(move==Move.UP) {
			x--;
			if(x<0) {
				this.getDamage(1);
				game.shipG.setCanShoot(true);			
			} 
		}
		else if(move==Move.DOWN) {
			x++;
			if(x>Game.DIM_X-1) {
				onDelete(); 				
			}}
		else if(move==Move.NONE) {}
	}
	
	public abstract boolean attacking(GameObject other);
	
	public boolean performAttack(GameObject object) {
		
		if((object.getX() == this.getX())&& object.getY() ==this.getY()) {
			if(attacking(object)) {
				this.live=0;
				this.y=-1;
				return true;
			}
		}			
		return false;	
	}
}
