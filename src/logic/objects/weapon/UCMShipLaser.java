package tp.p1.logic.objects.weapon;

import tp.p1.logic.Game;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.Move;

public class UCMShipLaser extends Weapon{	
	
	public UCMShipLaser(Game game, int x, int y) {
		super(game, x, y, 1);
		move = Move.UP;
	}
	
	@Override
	public String toString() {
		String algo="oo"; 
		return algo;
	}
		
	@Override
	public boolean attacking(GameObject other) {
			return other.receiveMissileAttack(1);
	}
	@Override
	public void computerAction() {
		// VACIO		
	}
	
	@Override
	public void onDelete() {		
		game.shipG.setCanShoot(true);
	}
	
	public boolean receiveBombAttack(int damage) {
		getDamage(1);		
		return true;
	}
	
	public String stringifier() {
		return "M: "+ x+", " +y;
	}
}
