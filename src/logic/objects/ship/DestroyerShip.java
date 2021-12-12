package tp.p1.logic.objects.ship;


import tp.p1.logic.Game;
import tp.p1.logic.IExecuteRandomActions;
import tp.p1.logic.objects.Move;
import tp.p1.logic.objects.weapon.Bomb;

public class DestroyerShip extends AlienShip{
	
	public static final int PUNTOS=10;
	public boolean canShootBomb=true;
	
	public DestroyerShip(Game game,int x, int y, int resistencia) {
		super(game,x, y, resistencia);
		move = Move.LEFT;
	}
	
	public String toString() { 
		String algo= "D[" + getLive() + "]"; 
		return algo;
	}
	
	public int getPuntos() { 
		return PUNTOS;
	}
	
	@Override
	public void onDelete() {
		super.onDelete();
		game.receivePoints(PUNTOS);
	}
	
	@Override
	public void computerAction() { 
		if(this.canShootBomb && IExecuteRandomActions.canGenerateRandomBomb(game)) {
			game.addObject(new Bomb(game,x,y,this));
			canShootBomb = false;
		}
	}
	
	public String stringifier() {
		return "D: "+ x+", " +y+", " +live+", " +game.getLevel().getNumCyclesToMoveOneCell()+", "+ dir(); 
	}
	
	public String dir() {
		if(move == Move.LEFT) return "LEFT";
		else if(move== Move.DOWN) return "DOWN";
		else return "RIGHT";
	}
}