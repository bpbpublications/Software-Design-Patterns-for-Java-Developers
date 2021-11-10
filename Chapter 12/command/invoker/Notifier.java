package edu.bpb.oops.pattern.ch12.command.invoker;

import edu.bpb.oops.pattern.ch12.command.Command;

/**
 * Command Invoker
 * 
 * @author Lalit Mehra
 *
 */
public class Notifier {
	
	private Command command;
	
	public void setCommand(Command command) {
		this.command = command;
	}

	public void invoke() {
		command.execute();
	}
}
