package tp.p1.logic.objects;


public class GameObjectBoard {
	
	private GameObject[] objects;
	private int currentObjects;
	
	
	public GameObjectBoard (int width, int height) {	//w->x		h->y
		this.currentObjects = 0;
		objects= new GameObject[width*height];
	}
	
	public void add(GameObject object) {
		objects[currentObjects] = object;
		this.currentObjects++;	
	}	
	
	private void remove(GameObject object) {
		for( int h=getIndex(object.getX(),object.getY()); h<currentObjects; h++) {
			objects[h]=objects[h+1];
		}
		this.currentObjects--;
		removeDead();
	}
	
	public void update() {
		
		for( int h=0; h<currentObjects; h++) { 
			objects[h].move();
			checkAttacks(objects[h]);
		}
		
		removeDead();		
	}
	
	private boolean checkAttacks(GameObject object) {
		boolean attaack=false;
		
		for(int i =0;i<currentObjects;i++)
			if(	 object != objects[i]	) 
				if(object.performAttack(objects[i]))  
					attaack = true;				
			
		return attaack;
	}
	
	public void computerAction() {
		for( int h=0; h<currentObjects; h++) {
			objects[h].computerAction();				
		}
	}
	
	public void removeDead() {		
		for(int i =0;i<currentObjects;i++){	
			if(!objects[i].isAlive()) {
				objects[i].onDelete(); 
				remove(objects[i]);
				i--;
			}			
		}
	}
		
	public String toString(int x, int y) {		
		if(getObjectInPosition(x,y)==null || getObjectInPosition(x,y).live==0)
			return "";
		return getObjectInPosition(x,y).toString();
	}
	
	public GameObject getObjectInPosition (int x, int y) {
		if (getIndex(x,y)==-1){
			return null;
		}
		return objects[getIndex(x,y)];
	}
	
	private int getIndex(int x, int y) {
		int pos=-1;
		for( int h=0; h<currentObjects; h++) {
			if(objects[h].getX()==x && objects[h].getY()==y)
				pos=h;
		}		
		return pos;
	}
	
	public String stringifier() {
		String texto="";
		for( int h=0; h<currentObjects; h++) {
			texto += objects[h].stringifier()+";\n";
		}
		return texto;
	}
}