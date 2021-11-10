package edu.bpb.oops.pattern.ch2.singleton.impl;

/**
 * A double check or dual check singleton eliminates the need to access
 * the synchronized block and acquire a lock by placing an additional 
 * check before the synchonized block that verifies the locking criteria.
 * 
 * @author Lalit Mehra
 *
 */
public class DoubleCheckSingleton {

	private static DoubleCheckSingleton instance;

	private DoubleCheckSingleton() {}

	public static DoubleCheckSingleton getInstance() {

		if (null == instance) 
			synchronized (DoubleCheckSingleton.class) {
				if (null == instance)
					instance = new DoubleCheckSingleton();
			}

		return instance;
	}

}
