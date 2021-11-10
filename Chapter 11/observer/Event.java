package edu.bpb.oops.pattern.ch11.observer;

/**
 * Provides the necessary methods for arranging an online auction event 
 * 
 * @author Lalit Mehra
 *
 */
public interface Event {
	
	
	/**
	 * Commence an event
	 */
	public void start();
	
	/**
	 * Terminates an event
	 */
	public default void end() {};
	
	/**
	 * Move to the next phase of the event
	 */
	public void next();

}
