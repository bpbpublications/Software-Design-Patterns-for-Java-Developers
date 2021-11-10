package edu.bpb.oops.pattern.ch2.singleton.impl;

/**
 * A Thread safe singleton is synchronized by default, allowing only one thread to hold the lock
 * 
 * @author Lalit Mehra
 *
 */
public class ThreadSafeSingleton {

	private static ThreadSafeSingleton instance;

	private ThreadSafeSingleton() {
	}

	public static synchronized ThreadSafeSingleton getInstance() {

		if (null == instance) {
			instance = new ThreadSafeSingleton();
		}

		return instance;
	}

}
