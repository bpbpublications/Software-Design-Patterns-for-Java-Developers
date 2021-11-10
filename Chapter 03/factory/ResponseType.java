package edu.bpb.oops.pattern.ch3.factory;

/**
 * Supported response types 
 * 
 * @author Lalit Mehra
 *
 */
public enum ResponseType {

	SUCCESS("Success!"), FAILURE("Failure!"), TIMEOUT("Time Out!"), IN_PROGRESS("In Progress!");

	ResponseType(String msg) {
		this.msg = msg;
	}

	String msg;

	String getMsg() {
		return msg;
	}

}