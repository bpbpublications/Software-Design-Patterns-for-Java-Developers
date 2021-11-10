package edu.bpb.oops.pattern.ch13.state;

/**
 * Implies that the implementing object/entity may have one or more state(s) <br> 
 * Provides basic methods to set and get current state
 * 
 * @author Lalit Mehra
 * @since Dec 10, 2019
 *
 */
public interface Stateful {
	
	/**
	 * Set the current state of the object
	 * @param state
	 */
	public void setState(State state);
	
	/**
	 * @return {@link State}: The current state of the object
	 */
	public State getState();
	
}
