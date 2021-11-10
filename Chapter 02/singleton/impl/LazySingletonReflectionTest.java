package edu.bpb.oops.pattern.ch2.singleton.impl;
import java.lang.reflect.Constructor;

/**
 * This example demonstrates how reflection breaks a eagerly initialized singleton 
 * 
 * @author Lalit Mehra
 *
 */
public class LazySingletonReflectionTest {

    @SuppressWarnings("rawtypes")
	public static void main(String[] args) {
    	LazySingleton instanceOne = LazySingleton.getInstance();
    	LazySingleton instanceTwo = null;
        try {
            Constructor[] constructors = LazySingleton.class.getDeclaredConstructors();
            for (Constructor constructor : constructors) {
                //Below code will destroy the singleton pattern
                constructor.setAccessible(true);
                instanceTwo = (LazySingleton) constructor.newInstance();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(instanceOne.hashCode());
        System.out.println(instanceTwo.hashCode());
    }

}