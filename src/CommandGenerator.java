package tp.p1;


import tp.p1.Exceptions.CommandParseException;
import tp.p1.command.*;

public class CommandGenerator {
	

	private static Command[] availableCommands = {
			
			new ListCommand(),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),			
			new UpdateCommand(),//NONE
			new ShootCommand(),
			new MoveCommand(),			
			new ShockwaveCommand(),
			new BuySuperMisil(),
			new StringifyCommand(),
			new SaveCommand(),
			new ListPrintersCommand()
	}; 

	public static Command parseCommand (String[] commandWords) throws CommandParseException{
			for(Command c: availableCommands) {
				if(c.parse(commandWords)!= null) 
					return c;				
			}
			return null;
	}
	
	public static String commandHelp(){
		String command= "";
		for(Command c: availableCommands) {
			command += c.helpText();
		}		
		 return command;
	}
}
