package tp.p1.command;

import tp.p1.Command;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;
import tp.p1.view.PrinterTypes;

public class ListPrintersCommand extends Command{
	protected final static String name="LISTPRINTERS";
	protected final static String shortCut="I";
	private final static String details="L[I]STPRINTERS";
	private final static String help="Prints the list of available ships.";
	
		public ListPrintersCommand() {
			super(name, shortCut, details, help);			
		}		

		@Override
		public boolean execute(Game game) {			
			System.out.println(PrinterTypes.printerHelp(game));
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