package edu.bpb.oops.pattern.ch10.template;

import edu.bpb.oops.pattern.ch10.template.model.Order;
import edu.bpb.oops.pattern.ch10.template.model.User;

/**
 * The template implementation that provides the skeleton for processing orders
 * 
 * @author Lalit Mehra
 *
 */
public abstract class OrderProcessingService {
	
	public final void process(Order order, User user) {
		
		confirmOrder(order);
		updateInventory(order);
		prepareInvoice(user, order);
		sendNotification(user, order);
		
	}
	
	public final void updateInventory(Order order) {
		System.out.println("updating inventory as per order details");
	}
	
	public void confirmOrder(Order order) {
		System.out.println("confirming order");
	}
	
	public abstract void prepareInvoice(User user, Order order);
	
	public abstract void sendNotification(User user, Order order);

}
