package tp.p1.logic.objects.ship;


import tp.p1.logic.Game;
import tp.p1.logic.IExecuteRandomActions;
import tp.p1.logic.objects.Move;

public class Ovni extends EnemyShip{

	private static final int PUNTOS=25;
	public boolean ovniActivo;
	Move move;	
	
	public Ovni(Game game, boolean ovniActivo) {
		super(game,0, 9, 1);
		move = Move.LEFT;
		this.ovniActivo= ovniActivo;
	}
	
	public boolean isOvniActivo() {
		return ovniActivo;
	}

	public void setOvniActivo(boolean ovniActivo) {
		this.ovniActivo = ovniActivo;
	}

	public String toString() {
		String algo="";
		 algo= "O[" + getLive() + "]"; 
		return algo;
	}
	
	public String stringifier() {
		return "O: "+ x+", " +y+", " +live; 
	}
	public int getPuntos() {
		return PUNTOS;
	}

	@Override
	public void computerAction() { 
		if(!isOvniActivo() && IExecuteRandomActions.canGenerateRandomOvni(game)) {	
			setX(0); 	setY(9);
			setOvniActivo(true);
		}
	}

	@Override
	public void onDelete() {
		game.receivePoints(PUNTOS);
		setOvniActivo(false);
		game.shipG.setHasShockWave(true);
	}

	@Override
	public void move() {
		if(ovniActivo) {
			y--;
			if(y<0) { 
				ovniActivo=false;
			}
		}
	}
} 