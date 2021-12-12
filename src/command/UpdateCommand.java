package tp.p1.command;
import tp.p1.Command;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.*;

public class UpdateCommand extends Command{
	protected final static String name="N";
	protected final static String shortCut="";
	private final static String details="[N]ONE";
	private final static String help="Saltar un ciclo.";
	
	public UpdateCommand() {
		super(name, shortCut, details, help);			
	}
	
	@Override
	public boolean execute(Game game) {
		game.update();		
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