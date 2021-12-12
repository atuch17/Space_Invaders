package tp.p1.command;

import tp.p1.Command;
import tp.p1.Exceptions.CommandExecuteException;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;
import tp.p1.logic.objects.Move;

public class MoveCommand extends Command{
	protected final static String name="MOVE";
	protected final static String shortCut="M";
	private final static String details="[M]OVE";
	private final static String help="Moves UCM-Ship to the indicated direction.";
	protected String numYdir;
	
	Move move; 
	
	public MoveCommand() { 
		super(name, shortCut, details, help);		
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		if(numYdir.equals("1LEFT") || numYdir.equals("2LEFT") || numYdir.equals("1RIGHT") || numYdir.equals("2RIGHT")) 
			numYdir= numYdir.substring(0,2);			
		
		
	 switch(numYdir){
			 
	  case "1L": 	game.shipG.move=Move.LEFT;
	  				if(game.move(1)) {
	  					game.update();
	  					return true;
	  				}
	  				else {
	  					throw new CommandExecuteException("No te puedes seguir desplazando hacia ese lado!\n");
			 		}
	  				
	  case "2L": 	game.shipG.move=Move.LEFT;
	  				if(game.move(2)) {
	  					game.update();
	  					return true;
	  				}
					
	  				else {
	  					throw new CommandExecuteException("No te puedes seguir desplazando hacia ese lado!\n");
			 		}
	  				
	  case "1R": 	game.shipG.move = Move.RIGHT;
	  				if(game.move(1)){
	  					game.update();
	  					return true;
	  				}
	  				
	  				else {
	  					throw new CommandExecuteException("No te puedes seguir desplazando hacia ese lado!\n");
			 		}
	  				
	  case "2R": 	game.shipG.move = Move.RIGHT;
	  				if(game.move(2)){
	  					game.update();
	  					return true;
	  				}
	  				
	  				else {
	  					throw new CommandExecuteException("No te puedes seguir desplazando hacia ese lado!\n");
			 		}
	  					 
	  default: 		
		  throw new CommandExecuteException("Escriba correctamente, gracias.\n");	
			}	 
	}

	@Override
	public Command parse(String[] commandWords)  throws CommandParseException{
		Command c= new ListCommand();
		if(matchCommandName(commandWords[0]))
			if (commandWords.length < 3){
				if(commandWords.length == 2 ) 
					numYdir= commandWords[1];
				return c;
			}else 
				throw new CommandParseException("Demasiados parametros.");
				 
		return null;
	}
}