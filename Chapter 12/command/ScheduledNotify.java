package edu.bpb.oops.pattern.ch12.command;

import edu.bpb.oops.pattern.ch12.command.receiver.Notification;

/**
 * Schedules notifications
 * 
 * @author Lalit Mehra
 *
 */
public class ScheduledNotify implements Command {

	private Notification nService;
	
	public ScheduledNotify(Notification nService) {
		this.nService = nService;
	}
	
	@Override
	public void execute() {
		nService.scheduledSend();
	}

}
