package edu.bpb.oops.pattern.ch5.objectpool;

import java.sql.Connection;

/**
 * The Object Pool interface contains the methods that should be implemented by
 * the concrete implementations of an Object Pool. <br>
 * 
 * It has four methods <br>
 * 1. init - to initialise the object pool <br>
 * 2. destroy - to destroy the object pool <br>
 * 3. acquire - to acquire an object from the object pool <br>
 * 4. release - to release an object after use, back to the object pool <br>
 * 
 * @author Lalit Mehra
 *
 * @param <T>
 */
public interface ObjectPool<T extends Connection> {

	/**
	 * Initialise an object pool
	 * 
	 * @throws Exception
	 */
	public void init() throws Exception;

	/**
	 * Destroy an initialised pool
	 * 
	 * @throws Exception
	 */
	public void destroy() throws Exception;

	/**
	 * Acquire an object from the object pool
	 * 
	 * @return object type defined by the implementation
	 * @throws Exception
	 */
	public T acquire() throws Exception;

	/**
	 * Release an object after use, back to the object pool
	 * 
	 * @param obj - obj that is to be released
	 * @throws Exception
	 */
	public void release(T obj) throws Exception;

}
