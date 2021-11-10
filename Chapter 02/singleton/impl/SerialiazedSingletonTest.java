package edu.bpb.oops.pattern.ch2.singleton.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Example class to demonstrate the effect of Serialization on Singleton <br>
 * A user defined singleton class must implement {@link Serializable} and override readResolve method in order for it to achieve correct state after deserialization 
 * 
 * @author Lalit Mehra
 *
 */
public class SerialiazedSingletonTest {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		final String filename = "/tmp/serialize.file";
		SerializedSingleton first = SerializedSingleton.get();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));

		oos.writeObject(first);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		SerializedSingleton second = (SerializedSingleton) ois.readObject();
		ois.close();

		// return true when SerialiazedSingleton has a readResolve method otherwise return false
		System.out.println(first == second);
	}

}
