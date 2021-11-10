package edu.bpb.oops.pattern.ch5.objectpool.exception;

/**
 * Thrown when an invalid activity takes place, something which is not
 * allowed<br>
 * An example of the invalid activity is to send out a request to release an
 * already released object, back to the pool<br>
 * 
 * @author Lalit Mehra
 *
 */
public class InvalidActivityException extends RuntimeException {

	private static final long serialVersionUID = -2295181122279983044L;

	public InvalidActivityException() {
		super();
	}

	public InvalidActivityException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidActivityException(String message) {
		super(message);
	}

}
