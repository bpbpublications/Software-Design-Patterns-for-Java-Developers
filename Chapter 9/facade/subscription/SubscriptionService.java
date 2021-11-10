package edu.bpb.oops.pattern.ch9.facade.subscription;

import edu.bpb.oops.pattern.ch9.facade.user.User;

/**
 * @author Lalit Mehra
 *
 */
public interface SubscriptionService {

	public double getSubscriptionCharge();
	
	public void subscribe(User user);
	
	public void unsubscribe(User user);
	
}
