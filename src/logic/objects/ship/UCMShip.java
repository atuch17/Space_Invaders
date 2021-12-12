package tp.p1.logic.objects.ship;

import tp.p1.logic.Game;
import tp.p1.logic.objects.Move;

public class UCMShip extends Ship{
				
	private boolean hasShockWave;
	private boolean canShootLaser;
	public boolean canShootSuperMisil;
	private int numOfMisiles;
	
	public Move move;
	
	public UCMShip(Game game,int x, int y) {
		super(game, x, y, 4);
		this.hasShockWave = false;
		this.canShootLaser = true;
		this.canShootSuperMisil = false;
		this.numOfMisiles=0;
		move = Move.NONE;
	}
	
	@Override
	public String toString() {
		if(live==1)
			return "^xx^";
		String algo= "^__^"; 
		return algo;
	}
	
	@Override
	public void computerAction() {
		// VACIO		
	}

	@Override
	public void onDelete() {
	}

	@Override
	public void move() {
		if(move == Move.LEFT) y--;
		else if(move == Move.RIGHT) y++;
		
	}
	public boolean isHasShockWave() {
		return hasShockWave;
	}

	public void setHasShockWave(boolean hasShockWave) {
		this.hasShockWave = hasShockWave;
	}
	public boolean isCanShoot() {
		return canShootLaser;
	}
	
	public void setCanShoot(boolean canShootLaser) {
		this.canShootLaser = canShootLaser;
	}
	
	public void pierdeVida() {
		live--;
	}
	public boolean receiveBombAttack(int damage) {
		getDamage(damage);		
		return true;
	}
	public String shockWaveDisponible() {
		 if(!isHasShockWave())
			 return "NO";
		 else
			 return "SI";
	}
	public String stateToString() {
		
		return "Vida: "+ (getLive()-1) + "\n" +
		"Points: " + game.punts + "\n" +
				"Shockave: " + shockWaveDisponible() + "\n" +
		"SuperMisiles: " +numOfMisiles + "\n";
	}

	public int getNumOfMisiles() {
		return numOfMisiles;
	}

	public void setNumOfMisiles(int numOfMisiles) {
		this.numOfMisiles = numOfMisiles;
	}

	
	
	public String stringifier() {
		return "P: "+ x+", " +y+", " +(live-1)+", " +game.punts+", " +hasShockWave+", " +numOfMisiles;
	}
	
}