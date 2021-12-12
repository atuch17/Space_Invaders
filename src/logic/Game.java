package tp.p1.logic;

import java.util.Random;

import tp.p1.logic.Level;
import tp.p1.logic.objects.BoardInitializer;
import tp.p1.logic.objects.GameObject;
import tp.p1.logic.objects.GameObjectBoard;
import tp.p1.logic.objects.Move;
import tp.p1.logic.objects.ship.AlienShip;
import tp.p1.logic.objects.ship.UCMShip;
import tp.p1.logic.objects.weapon.ShockWave;
import tp.p1.logic.objects.weapon.SuperMisil;
import tp.p1.logic.objects.weapon.UCMShipLaser;

public class Game implements IPlayerController{ 	

	public 	int 		ciclos=-1;
	public 	int 		punts=0;
	private	boolean 	doExit=false;
	
	public 	final static int DIM_Y = 9;
	public 	final static int DIM_X = 8; 	
	
	Level 						levelG;
	public 	Random 				randNum;	
	public 	UCMShip 			shipG;	
	public	GameObjectBoard		board;	
	private BoardInitializer 	initializer;
	
	
	
	public Game(Level level, Random rand) {
		this.levelG = level;
		this.randNum = rand;
		initializer = new BoardInitializer();
		initGame();
	}		
		
	public Random getRandNum() {
		return randNum;
	}

	public void setRandNum(Random randNum) {
		this.randNum = randNum;
	}

	public void initGame() {
		ciclos = 0;
		board = initializer.initialize (this, levelG);		
		shipG = new UCMShip(this, DIM_X-1, DIM_Y/2); 
		board.add(shipG);
	}
	
	public String stringify() {
		System.out.println("---- SPACE INVADERS V2.0 ----\n" + "G: " + ciclos + "\n"+ "L: " + mostrarNivel());	
		System.out.println(board.stringifier());
		System.out.println("\n\n\n\n");
		return "";
	}
	
	public boolean aliensWin() {
		return (shipG.getLive()==1) || AlienShip.haveLanded();
	}
	
	public boolean playerWin () {
		return AlienShip.allDead();
	}
	
	public boolean isFinished() {
		return playerWin() || aliensWin() || doExit;
	}
	
	public void update() {
		board.computerAction();
		shipG.move = Move.NONE;
		board.update();		
		
		contarCiclos();
	}
	
	public Level getLevel() {
		return levelG;
	}

	public void reset() {
		punts=0;							
		initGame();		
	}
	
	public void doDamage(int x, int y) {	
		if(	board.getObjectInPosition(x, y) != null)
			board.getObjectInPosition(x, y).getDamage(1);
	}
	
	public void addObject(GameObject object) {
		board.add(object);
	}
	
	public String positionToString(int x, int y) {
		return board.toString(x, y);
	}
								
	public String toStringObjectAt(int xx, int yy){		
		return board.toString(xx,yy);				
	}
		
	public boolean isOnBoard(int x, int y) {
		return x >= 0 && y >= 0 && x < DIM_X && y < DIM_Y; 
	}

	public void exit() {
		doExit = true;
	}
	
	public int contarCiclos() {
		if(ciclos==-1)
			return ciclos=0;
		 ciclos++;
		return ciclos;
	}	
	
	public String mostrarNivel() {
		if(levelG == Level.EASY) {
			return "EASY";}
		else if(levelG == Level.HARD) {
			return "HARD";}
		else {
			return "INSANE";}		
	}
	
	public int getCiclos() {
		return ciclos;
	}
	
	public String infoToString() {
		return "Cycles: " + ciclos + "\n" +
				shipG.stateToString() +
		"Remaining aliens: " + AlienShip.getREMAINING_ALIENS() + "\n";
	}
	
	public String getWinnerMessage () {
		if (playerWin()) return "			Player win!";
		else if (aliensWin()) return "			Aliens win!";
		else if (doExit) return "			Player exits the game";
		else return "			This should not happen";
	}	

	@Override
	public boolean move(int numCells){
		
		for(int i=0; i< numCells; i++)
			shipG.move();
			
		
		if(!isOnBoard(shipG.getX(),shipG.getY())) { 
			if(shipG.move ==Move.LEFT) shipG.setY(0);
			else if(shipG.move ==Move.RIGHT) shipG.setY(DIM_Y-1);			
			return false;
		}
		return true;
	}

	@Override
	public boolean shootMissile() {
		if(shipG.isCanShoot()) {
			enableMissile();
			shipG.setCanShoot(false);
			return true;		
		}
		
		return false;
	}

	@Override
	public boolean shockWave() {
		if(shipG.isHasShockWave()) {
			enableShockWave();
			return true;
		}else	
			return false;
	}

	@Override
	public void receivePoints(int points) {
		punts +=points;		
	}

	@Override
	public void enableShockWave() {
		board.add(new ShockWave(this, -1,-1));		
	}

	@Override
	public void enableMissile() {
		if(shipG.canShootSuperMisil) {
			shipG.canShootSuperMisil=false;
			board.add(new SuperMisil(this, shipG.getX(), shipG.getY()));	
			shipG.setNumOfMisiles(shipG.getNumOfMisiles()-1);
			if(shipG.getNumOfMisiles()<=0)
				shipG.setNumOfMisiles(0);
		}	
		else
			board.add(new UCMShipLaser(this, shipG.getX(), shipG.getY()));		
	}	
};
