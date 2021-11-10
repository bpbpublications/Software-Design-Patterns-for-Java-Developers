package edu.bpb.oops.pattern.ch2.singleton.impl;

import java.io.Serializable;

/**
 * A Serialized singleton implemetation
 * 
 * @author Lalit Mehra
 *
 */
public class SerializedSingleton implements Serializable {

	private static final long serialVersionUID = -7889143059742888814L;
	
	private static SerializedSingleton instance = new SerializedSingleton();
	
	private SerializedSingleton() {}
	
	protected Object readResolve() {
		return get();
	}
	
	public static SerializedSingleton get() {
		return instance;
	}

}
