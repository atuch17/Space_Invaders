package tp.p1.Exceptions;

public class FileContentsException extends Throwable{
	
	private String messages="Hay un parse exception";
	
	public FileContentsException(String string) {	
		messages=string;
		}
	public String getMessage() {
		return messages;
	}
	
	public void setMessage(String message) {
		messages = message;
	}
	
}
