package edu.bpb.oops.pattern.ch9.facade.payment;

import edu.bpb.oops.pattern.ch9.facade.user.User;

/**
 * @author Lalit Mehra
 *
 */
public interface PaymentService {
	
	public PaymentOrder prepareOrder(PaymentMode payMode, double amount, User user);
	
	public PaymentResponse pay(PaymentOrder details);

}
