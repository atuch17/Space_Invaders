package tp.p1.command;

import tp.p1.Command;
import tp.p1.Exceptions.CommandExecuteException;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class ShootCommand extends Command{
	protected final static String name="SHOOT";
	protected final static String shortCut="S";
	private final static String details="[S]HOOT";
	private final static String help="UCM-Ship launches a missile.";
	protected String superM="";

	
	public ShootCommand() {
		super(name, shortCut, details, help);		
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{	
		if(superM.equals("SUPER") && game.shipG.getNumOfMisiles()>0) {
			game.shipG.canShootSuperMisil=true;
			if(game.shootMissile()) {				
				game.update();
				game.shipG.setCanShoot(false);
				superM="";
				return	true;
			}
		}
		else if(superM.equals("SUPER") && game.shipG.getNumOfMisiles()==0) {
				throw new CommandExecuteException("No has comprado ningun misil todavia!\n");			
		}

		if(game.shootMissile()) {
			game.update();
			return	true;
		}
		else {
			throw new CommandExecuteException("Ya disparaste!\n");
		}
					
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException{
		Command c= new ListCommand();
		if(matchCommandName(commandWords[0])) {
			if (commandWords.length < 3){
				if(commandWords.length == 2) {
					if(commandWords[1].equals("SUPER"))
						superM= commandWords[1];
					else 
						throw new CommandParseException("Parametros incorrectos.");
					}
					return c;
				}
				else 
					throw new CommandParseException("Demasiados parametros.");
			}		 
		return null;
	}
}
