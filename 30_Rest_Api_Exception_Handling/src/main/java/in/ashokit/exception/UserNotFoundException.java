package in.ashokit.exception;

public class UserNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 362273056063786321L;

	public UserNotFoundException() {
	}
	
	public UserNotFoundException(String msg) {
		super(msg);
	}
	
}
