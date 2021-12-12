package tp.p1.command;

import tp.p1.Command;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class BuySuperMisil extends Command {	
	protected final static String 	name	="BUY";
	protected final static String 	shortCut="B";
	private final static String 	details	="[B]UY_SUPER_MISIL[W]AVE";
	private final static String 	help	="Use 20 points to get a better misil.";
	
	public BuySuperMisil() {
		super(name, shortCut, details, help);
		
	}
	
	@Override
	public boolean execute(Game game) {
		
			if(game.punts>=20) {
				game.shipG.setNumOfMisiles(game.shipG.getNumOfMisiles()+1);
				
				game.receivePoints(-20);
			}
			else {
				System.out.println("No dispones de puntos suficientes! \n");
				return false;	
			}
			return true;			
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException{
		Command c= new BuySuperMisil();
		if(matchCommandName(commandWords[0]))
			if (commandWords.length < 2){
				return c;
		}else {
			throw new CommandParseException("Demasiados parametros.");
		}		 
	return null;
}
}