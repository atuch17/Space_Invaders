package tp.p1.command;

import tp.p1.Command;
import tp.p1.CommandGenerator;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class HelpCommand extends Command{
	protected final static String name = "HELP";
	protected final static String shortCut = "H";
	private final static String details = "[H]ELP";	
	private final static String help = "shows this help.";
	
	public HelpCommand() {
		super(name, shortCut, details, help);
	}

	@Override
	public boolean execute(Game game) {		
		System.out.println(CommandGenerator.commandHelp()); 
		return false;
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
