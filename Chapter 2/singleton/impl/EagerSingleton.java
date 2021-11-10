package edu.bpb.oops.pattern.ch2.singleton.impl;

import java.util.concurrent.atomic.AtomicLong;

/**
 * An eager singleton implementatation uses a statically initialized 
 * instance of itself that is initialized by the JVM   
 * 
 * @author Lalit Mehra
 *
 */
public class EagerSingleton {
	
	private static EagerSingleton instance = new EagerSingleton();
	private AtomicLong count;
	
	private EagerSingleton() {
		count = new AtomicLong();
	}
	
	public static EagerSingleton getInstance() {
		return instance;
	}
	
	public void incrementCount() {
		count.incrementAndGet();
	}
	
	public long getCount() {
		return count.get();
	}

}
