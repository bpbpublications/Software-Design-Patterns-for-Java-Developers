package edu.bpb.oops.pattern.ch10.template;

import edu.bpb.oops.pattern.ch10.template.model.Order;
import edu.bpb.oops.pattern.ch10.template.model.User;

/**
 * Template implementation that allows bulk order processing and provides definition to
 * the abstract methods of the base template 
 * 
 * @author Lalit Mehra
 *
 */
public class BulkOrderProcessingService extends OrderProcessingService {

	public void prepareInvoice(User user, Order order) {
		System.out.println("preparing invoice for bulk order");
	}

	public void sendNotification(User user, Order order) {
		System.out.println("sending email to merchants");
		System.out.println("sending email to user");
	}

}