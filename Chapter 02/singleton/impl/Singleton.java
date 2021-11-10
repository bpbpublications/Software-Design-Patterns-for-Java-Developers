package edu.bpb.oops.pattern.ch2.singleton.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Demonstrates an enum as Singleton 
 * 
 * @author Lalit Mehra
 *
 */
public enum Singleton {

	INSTANCE;
	
	private AtomicLong count;
	
	Singleton() {
		count = new AtomicLong();
	}
	
	public void incrementCount() {
		count.incrementAndGet();
	}
	
	public long getCount() {
		return count.get();
	}
	
}
