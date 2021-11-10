package edu.bpb.oops.pattern.ch11.observer.observers.impl;

import edu.bpb.oops.pattern.ch11.observer.observers.Seller;

/**
 * Observer of Auction Event
 * 
 * @author Lalit Mehra
 * @since May 10, 2021
 */
public class Auctioneer implements Seller {

	@Override
	public void update(Object article) {
		System.out.println(article);
	}

}
