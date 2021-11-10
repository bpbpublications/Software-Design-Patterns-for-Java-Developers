package edu.bpb.oops.pattern.ch12.command.receiver;

/**
 * Command Receiver
 * 
 * @author Lalit Mehra
 *
 */
public interface Notification {
	
	public void send();
	
	public void scheduledSend();

}
