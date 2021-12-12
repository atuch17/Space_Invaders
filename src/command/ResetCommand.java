package tp.p1.command;

import tp.p1.Command;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class ResetCommand extends Command{
	protected final static String name="RESET";
	protected final static String shortCut="R";
	private final static String details="[R]ESET";
	private final static String help="Starts a new game.";
	
	public ResetCommand() {
		super(name, shortCut, details, help);		
	}

	@Override
	public boolean execute(Game game) {		
		game.reset();
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