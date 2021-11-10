package edu.bpb.oops.pattern.ch2.singleton.impl;

/**
 * A lazily initialized singleton implementation creates the singleton instance 
 * when it is required for the first time, and not before that 
 * 
 * @author Lalit Mehra
 *
 */
public class LazySingleton {

	private static LazySingleton instance;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		
		// constructing the instance on first call to getInstance
		if(null == instance) {
			instance = new LazySingleton();
		}
		
		return instance;
		
	}
	
	public void execute() {
		// execute some operation
	}
	
}
