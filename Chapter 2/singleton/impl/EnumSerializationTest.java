package edu.bpb.oops.pattern.ch2.singleton.impl;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Example class to demonstrate the effect of Serialization on Enum <br>
 * An Enum implements Serializable interface and hence it has no effect of Serialization <br>
 * 
 * @author Lalit Mehra
 *
 */
public class EnumSerializationTest {

	@SuppressWarnings("static-access")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		final String filename = "/tmp/serialize.file";

		// Enum as Singleton
		Singleton first = Singleton.INSTANCE;
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));

		oos.writeObject(first);
		oos.close();

		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		Singleton second = (Singleton) ois.readObject();
		ois.close();

		// This always returns true 
		System.out.println(first.INSTANCE == second.INSTANCE);
	}

}
