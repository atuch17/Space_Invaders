package tp.p1.logic.objects.weapon;

import tp.p1.logic.Game;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.Move;
import tp.p1.logic.objects.ship.AlienShip;

public class ShockWave extends Weapon{
	
	public int danio;
	private  int cont= AlienShip.getREMAINING_ALIENS();
	public ShockWave(Game game, int x, int y) {
		super(game, x, y, 1);
		move = Move.NONE;
		this.danio=1;
		
	}

	@Override
	public void computerAction() {
		// VACIO		
	}

	@Override
	public void onDelete() {		
		// VACIO
	}

	@Override
	public String toString() {		
		return "";
	}
	
	public boolean performAttack(GameObject object) {
		if(cont==0)
			return false;
		else {
			if(attacking(object)) {
				cont--;
				return true;
			}
			return false;
		}			
		
	}

	@Override
	public boolean attacking(GameObject other) {
		other.receiveShockWaveAttack(danio);
		return true;
	}
}
