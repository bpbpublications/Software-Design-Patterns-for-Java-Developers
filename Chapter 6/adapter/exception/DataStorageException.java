package edu.bpb.oops.pattern.ch6.adapter.exception;

/** 
 * 
 * @author Lalit Mehra
 *
 */
public class DataStorageException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataStorageException() {
		super();
	}

	public DataStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataStorageException(String message) {
		super(message);
	}

	public DataStorageException(Throwable cause) {
		super(cause);
	}
}
