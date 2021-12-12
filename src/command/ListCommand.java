package tp.p1.command;

import tp.p1.Command;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class ListCommand extends Command{
	protected final static String name="List";
	protected final static String shortCut="L";
	private final static String details="[L]IST";
	private final static String help="Prints the list of available ships.";
	
		public ListCommand() {
			super(name, shortCut, details, help);			
		}		

		@Override
		public boolean execute(Game game) {
			int resta3= 3-game.shipG.getLive();
	  		System.out.println(
				"\nCommand > list\r\n" + 
				"[R]egular ship:	"+"	-Points: "+ 5 + "	-Harm: "+ 0 +  "	-Shield: " + 2 + "\r\n" +
				"[D]estroyer ship:"+"	-Points: "+ 10 +"	-Harm: "+ 1 + "	-Shield: "+ 1 +"\r\n" + 
				"[O]vni:		"+ "	-Points: "+ 25 + "	-Harm: "+ 0 + "	-Shield: " + 1 +"\r\n" + 
				"^__^:			"+"		-Harm: "+ resta3 +"	-Shield: "+ 3 +"\r\n");
			return true;
		}

		@Override
		public Command parse(String[] commandWords) throws CommandParseException{
			
			Command c= new ListCommand();
			if(matchCommandName(commandWords[0]))
				if (commandWords.length < 2){
						return c;
				}else {
					throw new CommandParseException("Demasiados parametros.");
				}		 
			return null;
		}
}