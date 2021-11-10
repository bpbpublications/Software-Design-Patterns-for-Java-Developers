package edu.bpb.oops.pattern.ch2.singleton.impl;

import java.lang.reflect.Constructor;

/**
 * This example demonstrates how reflection breaks a eagerly initialized singleton 
 * 
 * @author Lalit Mehra
 *
 */
public class EagerSingletonReflectionTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// access an eagerly initilized singleton
		EagerSingleton instanceOne = EagerSingleton.getInstance();
		EagerSingleton instanceTwo = null;

		// use reflection to access constructors of the singleton implementation
		Constructor[] constructors = EagerSingleton.class.getDeclaredConstructors();
		constructors[0].setAccessible(true);
		try {
			instanceTwo = (EagerSingleton) constructors[0].newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		instanceOne.incrementCount();
		instanceOne.incrementCount();
		instanceTwo.incrementCount();

		System.out.println(instanceOne.getCount());
		System.out.println(instanceTwo.getCount());
	}

}