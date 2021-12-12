//	ADRIAN TURIEL CHARRO
//	ALVARO LOPEZ OLMOS

package tp.p1;
import tp.p1.logic.*;
import java.util.*;	

public class Main {
	
	public static void main(String[] args) {
				
		long 		seed;
		Game 		gameM;
		Controller 	controller;
		Scanner 	scanner;			
		String 		levelStr;
		Level 		level=null;
							
		levelStr = args[0].toLowerCase();
		
		if(args.length == 1) {
			seed = new Random().nextInt(101);			
		} else {
			try {
				seed = Long.valueOf((args[1])); 
			}
			catch(NumberFormatException n) {
				seed = new Random().nextInt(101);
				System.err.println("The seed must be a number!\n");
			}
		} 
		
		Random rand= new Random(seed); 
				
		// Assign the level to the enum		
		if(levelStr.equals("easy"))
			level =Level.EASY;
		else if (levelStr.equals("hard"))
			level =Level.HARD;
		else if (levelStr.equals("insane"))
			level = Level.INSANE;
		else {
			System.err.println("Level must be one of:\r\n" + 
					"EASY, HARD, INSANE!");
			level =Level.EASY; //by defect
		}
		

		// Create the game object
		gameM = new Game (level, rand);
		
		//Create the scanner(read user commands)
		scanner = new Scanner (System.in);
		
		//Create the controller
		controller = new Controller (gameM, scanner); 
				
		//Run the game			
		controller.run();		
		
	}	
	
}	

