package Homework10_Polymorphism;

public class PasswordNotStrongException extends Exception {

	private static final long serialVersionUID = -4149998183043425232L;

	public PasswordNotStrongException() {
		super();
	}

	public PasswordNotStrongException(String message, Throwable cause) {
		super(message, cause);
	}

	public PasswordNotStrongException(String message) {
		super(message);
	}

	public PasswordNotStrongException(Throwable cause) {
		super(cause);
	}
	
	

}
