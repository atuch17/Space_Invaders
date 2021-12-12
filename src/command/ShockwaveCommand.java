package tp.p1.command;

import tp.p1.Command;
import tp.p1.Exceptions.CommandExecuteException;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class ShockwaveCommand extends Command{
	protected final static String name		="SHOCKWAVE";
	protected final static String shortCut	="W";
	private final static String details		="SHOCK[W]AVE";
	private final static String help		="UCM-Ship releases a shock wave.";
	
	public ShockwaveCommand() {
		super(name, shortCut, details, help);
		
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		if(game.shockWave()) {
			
			game.update();
			game.shipG.setHasShockWave(false);
			game.shipG.setHasShockWave(false);
		}else{
				throw new CommandExecuteException("Shockwave NO ha sido activada todavia!\n");
		}				
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