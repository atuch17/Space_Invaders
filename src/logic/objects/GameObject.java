package tp.p1.logic.objects;

import tp.p1.logic.Game;
import tp.p1.logic.IAttack;


public abstract class GameObject implements IAttack {
		protected int x;
		protected int y;
		protected int live;
		protected Game game;
		
	
	public GameObject( Game game, int x, int y, int live) {
		this.x = x;
		this.y = y;
		this.game = game;
		this.live = live;
	}
	public int getY() {		
		return y;
	}
	public int getX() {
		return x;
	}
	public boolean isAlive() {
		return this.live > 0;
	}
	public int getLive() {
		return this.live;
	}
	
	public boolean isOnPosition(int x, int y) {
		return this.x == x && this.y == y;
	}
	
	public void getDamage (int damage) {
		this.live = damage >= this.live ? 0 : this.live - damage;
	}
	
	public boolean isOut() {
		return !game.isOnBoard(x, y); 
	}
	public abstract void computerAction();
	public abstract void onDelete();
	public abstract void move();
	public abstract String toString();

		
	public void setLive(int resistencia) {
		this.live = resistencia;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}	
	
	public boolean receiveShockWaveAttack(int damage) {
		getDamage(damage);
		return true;		
	}
	
	public String stringifier() {
		return "";
	}
}
