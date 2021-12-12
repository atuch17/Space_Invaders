package tp.p1;

import tp.p1.Exceptions.CommandExecuteException;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.*;
import tp.p1.view.GamePrinter;
import tp.p1.view.PrinterTypes;

import java.util.*;	

public class Controller {
	
	private Scanner in;
	Level 		level;
	Random 		rand;
	Game 		g;
	GamePrinter printer;
	String 		prompt="Commands >>";
	
	public Controller(Game game, Scanner scanner) { 
		super();		
		this.g= game;
		this.in=scanner;
	}
		
	
	public void run() {
		printGame();			
			
		while(!g.isFinished()) {
			System.out.println(prompt);

			String[] words = in.nextLine().toUpperCase().trim().split("\\s+"); 
			try {
				Command command = CommandGenerator.parseCommand(words);
				
				if (command != null) {
					if (command.execute(g)) 
						printGame();
				}
				else {
					System.err.println("Escribe un comando correctamente!!");
				}
			} catch (CommandParseException | CommandExecuteException ex) {
				System.err.format(ex.getMessage() + " %n %n");
			}												
		} 
		System.out.println(g.getWinnerMessage());	
	}
	
	
	private void printGame() {
		printer= PrinterTypes.BOARDPRINTER.getObject();
		System.out.println(g.infoToString() + printer.toString(g));
	}
};