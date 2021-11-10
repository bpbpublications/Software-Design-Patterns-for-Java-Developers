package edu.bpb.oops.pattern.ch12.command;

/**
 * The command interface
 * 
 * @author Lalit Mehra
 *
 */
public interface Command {
	
	public void execute();
	
	public default void undo() {
		// do nothing
	}

}
