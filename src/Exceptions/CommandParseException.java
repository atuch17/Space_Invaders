package tp.p1.Exceptions;

public class CommandParseException extends Throwable{
	
	private String Message;

	public CommandParseException(String message) {
		Message=message;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
		
}
