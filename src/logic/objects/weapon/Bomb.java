package tp.p1.logic.objects.weapon;

import tp.p1.logic.Game;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.Move;
import tp.p1.logic.objects.ship.DestroyerShip;

public class Bomb extends Weapon{
	
	DestroyerShip destroyer;
	
	public Bomb(Game game, int x, int y, DestroyerShip destroyer) {
		super(game, x, y, 1);		
		move = Move.DOWN;
		this.destroyer=destroyer;
	}
	
	@Override
	public String toString() {
		return ":";
	}

	@Override
	public void computerAction() {		
		//VACIO
	}

	@Override
	public void onDelete() {
		destroyer.canShootBomb=true;
		this.getDamage (1);
	}
	
	public boolean receiveMissileAttack(int damage) {
		if(game.shipG.getX() == this.getX())
			return true;		
		return false;
	}

	@Override
	public boolean attacking(GameObject other) {		
		return other.receiveBombAttack(1);
	}
	public String stringifier() {
		return "B: "+ x+", " +y;
	}
}
