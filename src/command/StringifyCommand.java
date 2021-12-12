package tp.p1.command;

import tp.p1.Command;
import tp.p1.Exceptions.CommandExecuteException;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;
import tp.p1.view.GamePrinter;
import tp.p1.view.PrinterTypes;

public class StringifyCommand extends Command{
	protected final static String name="PRINT";
	protected final static String shortCut="P";
	private final static String details="[P]RINT";
	private final static String help="Change the way to print.";
	GamePrinter printer;
	public StringifyCommand() {
		super(name, shortCut, details, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		
		printer = PrinterTypes.STRINGIFIER.getObject();		
		System.out.println(game.infoToString()+ printer.toString(game) + "\n");		
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command c= new StringifyCommand();
		if(matchCommandName(commandWords[0]))
			if (commandWords.length < 2){
					return c;
			}else {
				throw new CommandParseException("Demasiados parametros.");
			}		 
		return null;
	}
}