package edu.bpb.oops.pattern.ch12.command;

import edu.bpb.oops.pattern.ch12.command.receiver.Notification;

/**
 * Allows on the fly delivery of notifications 
 * 
 * @author Lalit Mehra
 *
 */
public class QuickNotify implements Command {

	private Notification nService;
	
	public QuickNotify(Notification nService) {
		this.nService = nService;
	}
	
	@Override
	public void execute() {
		nService.send();
	}
	
}
