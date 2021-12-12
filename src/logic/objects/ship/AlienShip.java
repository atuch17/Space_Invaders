package tp.p1.logic.objects.ship;


import tp.p1.logic.*;
import tp.p1.logic.objects.Move;

public abstract class AlienShip extends EnemyShip{
	
	protected static int REMAINING_ALIENS = 0;
	private static boolean IS_IN_FINAL_ROW;
	private static int SHIPS_ON_BORDER;
	protected int cyclesToMove=game.getLevel().getNumCyclesToMoveOneCell();
	
	public AlienShip(Game game,int x, int y, int live) {
		super(game, x, y, live);	
		REMAINING_ALIENS += 1; 
		SHIPS_ON_BORDER = 0;				
	}

	public void moves() {
		if(move == Move.LEFT) y--;
		else if(move == Move.RIGHT) y++;
		
	}
	 public void onDelete() {
		 REMAINING_ALIENS--;
	}
			
	public boolean receiveShockWaveAttack(int damage) {
		getDamage(1);
		return true;
	}
	public static boolean haveLanded() {
		return IS_IN_FINAL_ROW;
	}
	
	public static boolean allDead() {
		return REMAINING_ALIENS==0;
	}
		
	public static boolean isIS_IN_FINAL_ROW() {
		return IS_IN_FINAL_ROW;
	}
	
	public static void setIS_IN_FINAL_ROW(boolean iS_IN_FINAL_ROW) {
		IS_IN_FINAL_ROW = iS_IN_FINAL_ROW;
	}
	
	public static int getSHIPS_ON_BORDER() {
		return SHIPS_ON_BORDER;
	}

	public static void setSHIPS_ON_BORDER(int sHIPS_ON_BORDER) {
		SHIPS_ON_BORDER = sHIPS_ON_BORDER;
	}
	
	public static int getREMAINING_ALIENS() {
		return REMAINING_ALIENS;
	}

	public static void setREMAINING_ALIENS(int rEMAINING_ALIENS) {
		REMAINING_ALIENS = rEMAINING_ALIENS;
	}

	@Override
	public void move() {
		if (cyclesToMove == 0) {
			cyclesToMove=game.getLevel().getNumCyclesToMoveOneCell();					
			moves();				
			
			if(x == Game.DIM_X-1) IS_IN_FINAL_ROW=true;
			
			if(y == 0 || y == Game.DIM_Y-1)
				setSHIPS_ON_BORDER(REMAINING_ALIENS);
				
		}
		else if(SHIPS_ON_BORDER > 0 &&  !IS_IN_FINAL_ROW) {
			x++;
			move = move.flip();				
			SHIPS_ON_BORDER -= 1;
			setSHIPS_ON_BORDER(SHIPS_ON_BORDER);			
		}
		else cyclesToMove--;			
	}

}

