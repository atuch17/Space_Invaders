package tp.p1.command;

import tp.p1.Command;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class ExitCommand extends Command{
	protected final static String name ="EXIT";
	protected final static String shortCut ="E";
	private final static String details ="[E]XIT";
	private final static String help ="Terminates the program.";
	
	public ExitCommand() {
		super(name, shortCut, details, help);
	}

	@Override
	public boolean execute(Game game) {
		game.exit();
		System.out.println("		Game Over!!");
		return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command c= new ListCommand();
		if (commandWords.length < 2) {}
		if(matchCommandName(commandWords[0]))
			if (commandWords.length < 2) 
				return c;
			else {
				throw new CommandParseException("Demasiados parametros.");
			}
			 
		return null;
	}
}
