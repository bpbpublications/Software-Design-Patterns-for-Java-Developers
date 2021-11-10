package edu.bpb.oops.pattern.ch2.singleton.impl;

/**
 * A static block singleton implementation works much like its eager singleton counterpart, 
 * i.e., the instance is created by the JVM when the class is loaded. The difference is that
 * with a static block some logic can be applied to the construction process. 
 * 
 * It allows to catch exceptions, can be used to decide on the singleton implementation to return, etc.
 * 
 * @author Lalit Mehra
 *
 */
public class StaticBlockSingleton {

	private static StaticBlockSingleton instance;
	
	private StaticBlockSingleton() {
		throw new RuntimeException();
	}
	
	static {
		try {
			instance = new StaticBlockSingleton();
		} catch(Exception e) {
			instance = null;
		}
	}
	
	public static StaticBlockSingleton getInstance() {
		return instance;
	}
	
}
