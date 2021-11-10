package edu.bpb.oops.pattern.ch9.facade.user;

/**
 * @author Lalit Mehra
 *
 */
public class User {

	private boolean premiumMember;
	
	public void setPremiumMember(boolean premiumMember) {
		this.premiumMember = premiumMember;
	}
	
	public boolean isPremiumMember() {
		return premiumMember;
	}
	
}
