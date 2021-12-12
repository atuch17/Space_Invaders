package tp.p1.Exceptions;

public class CommandExecuteException extends Throwable{
	private String Message;

	public CommandExecuteException(String message) {		
		Message = message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
}
