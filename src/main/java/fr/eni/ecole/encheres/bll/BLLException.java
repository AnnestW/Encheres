package fr.eni.ecole.encheres.bll;

public class BLLException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BLLException (String message, Throwable cause) {
		super(message, cause);
	}
	
	public BLLException(String message) {
		super(message);
	}
		
	public BLLException (Throwable cause) {
		super(cause);
	}
	
	
	
	
}
