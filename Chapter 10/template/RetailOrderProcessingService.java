package edu.bpb.oops.pattern.ch10.template;

import edu.bpb.oops.pattern.ch10.template.model.Order;
import edu.bpb.oops.pattern.ch10.template.model.User;

/**
 * Template implementation that allows single order processing and provides definition to
 * the abstract methods of the base template 
 * 
 * @author Lalit Mehra
 *
 */
public class RetailOrderProcessingService extends OrderProcessingService {

	public void prepareInvoice(User user, Order order) {
		System.out.println("preparing invoice for the user");
	}

	public void sendNotification(User user, Order order) {
		System.out.println("notifying user via sms");
	}
	
	public void confirmOrder(Order order) {
		System.out.println("verifying payment status");
		super.confirmOrder(order);
	}

}
