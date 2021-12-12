package tp.p1.logic.objects.ship;

import tp.p1.logic.Game;
import tp.p1.logic.objects.Move;

public class RegularShip extends AlienShip{
	
	private static final int PUNTOS=5;
	private boolean explosive=false;

	public RegularShip(Game game,int x, int y, int resistencia) {
		super(game,x, y, resistencia);
		move = Move.LEFT;		
	}

	@Override
	public String toString() {
		String algo= "C[" + getLive() + "]";
		if(explosive)
			return "E[" + getLive() + "]";
		return algo;
	}
	
	public int getPuntos() { 
		return PUNTOS;
	}
	
	
	@Override
	public void onDelete() {		
		super.onDelete();
		if( explosive) {
			for(int i=-1; i<2;i++){
				for(int j=-1; j<2;j++){
					game.doDamage(x+i,y+j);
				}
			}
		}
		game.receivePoints(PUNTOS);
	}
	
	@Override
	public void computerAction() {
		if(!explosive && game.getRandNum().nextDouble()<0.05) {
			explosive=true;
			}
	}	
	
	public String stringifier() {
		if(explosive)
			return "E: "+ x+", " +y+", " +live+", " +game.getLevel().getNumCyclesToMoveOneCell()+", "+ dir(); 
		return "R: "+ x+", " +y+", " +live+", " +game.getLevel().getNumCyclesToMoveOneCell()+", "+ dir(); 
	}
	
	public String dir() {
		if(move == Move.LEFT) return "LEFT";
		else if(move== Move.DOWN) return "DOWN";
		else return "RIGHT";
	}
}