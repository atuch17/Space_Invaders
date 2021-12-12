package tp.p1.command;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import tp.p1.Command;
import tp.p1.Exceptions.CommandExecuteException;
import tp.p1.Exceptions.CommandParseException;
import tp.p1.logic.Game;

public class SaveCommand extends Command{
	protected final static String name="GUARDAR";
	protected final static String shortCut="G";
	private final static String details="[G]UARDAR";
	private final static String help="Guardar la partida en un fichero.";
	private String fileName;
	
	public SaveCommand() {
		super(name, shortCut, details, help);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		 try {
	            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".dat"));
	            
	           
	            writer.write("---- SPACE INVADERS V2.0 ----");
	            writer.newLine();
	            writer.newLine();
	            
	            String line = "Cycle: " + game.ciclos;
	            writer.write(line);
	            writer.newLine();
	            
	            line = "Level: " + game.mostrarNivel();
	            writer.write(line);
	            writer.newLine();
	            

	            line = "List: ";
	            writer.write(line);
	            writer.newLine();
	            
	            line = game.board.stringifier();
	            writer.write(line);
	            writer.newLine();
	            	        
	            writer.close();
	            
	    		System.out.println("Game successfully saved in file " + fileName + ".dat.");
	     } catch (IOException e) {
	            System.err.println("Algo fue mal al leer o cerrar el fichero. Lo sentimos!");
	     }
		 return false;
	}

	@Override
	public Command parse(String[] commandWords) throws CommandParseException {
		Command c= new SaveCommand();
		if(matchCommandName(commandWords[0]))
			if (commandWords.length < 3 && commandWords.length>1){
				fileName=commandWords[1];
				return c;
			}else {
				throw new CommandParseException("Pruebe con 2 parametros solo.");
			}		 
		return null;
	}
}