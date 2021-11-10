package edu.bpb.oops.pattern.ch12.command.test;

import edu.bpb.oops.pattern.ch12.command.Command;
import edu.bpb.oops.pattern.ch12.command.QuickNotify;
import edu.bpb.oops.pattern.ch12.command.ScheduledNotify;
import edu.bpb.oops.pattern.ch12.command.invoker.Notifier;
import edu.bpb.oops.pattern.ch12.command.model.Email;
import edu.bpb.oops.pattern.ch12.command.model.ShortMessage;
import edu.bpb.oops.pattern.ch12.command.receiver.EmailNotification;
import edu.bpb.oops.pattern.ch12.command.receiver.SmsNotification;


/**
 * Functional test that verifies the working of command design pattern
 * 
 * @author Lalit Mehra
 *
 */
public class TestCommand {

	public static void main(String[] args) {
		String emailTo = "office@creativehumans.com";
		String emailSubject = "Order Confirmation";
		String emailContent = "We are delighted to inform you that your order has been confirmed. Thank you for shopping with us.";
		Email email = new Email(emailTo, emailSubject, emailContent);

		String smsTo = "9000090000";
		String smsContent = "Your order has been confirmed. Thank you for shopping with us.";
		ShortMessage shortMessage = new ShortMessage(smsTo, smsContent);
		
		EmailNotification emailService = new EmailNotification(email);
		SmsNotification smsService = new SmsNotification(shortMessage);
		
		Command quickNotify = new QuickNotify(smsService);
		Command scheduledNotify1 = new ScheduledNotify(emailService);
		Command scheduledNotify2 = new ScheduledNotify(smsService);
		
		Notifier notifier1 = new Notifier();
		notifier1.setCommand(quickNotify);
		Notifier notifier2 = new Notifier();
		notifier2.setCommand(scheduledNotify1);
		Notifier notifier3 = new Notifier();
		notifier3.setCommand(scheduledNotify2);
		
		notifier1.invoke();
		System.out.println();
		notifier2.invoke();
		System.out.println();
		notifier3.invoke();
	}
	
}
