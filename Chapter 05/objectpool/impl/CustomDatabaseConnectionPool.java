package edu.bpb.oops.pattern.ch5.objectpool.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;

import edu.bpb.oops.pattern.ch5.objectpool.ObjectPool;
import edu.bpb.oops.pattern.ch5.objectpool.exception.InvalidActivityException;

/**
 * Custom Database Connection Pool
 * 
 * @author Lalit Mehra
 *
 */
public class CustomDatabaseConnectionPool implements ObjectPool<Connection> {

	private static CustomDatabaseConnectionPool _instance;

	private static final String ILLEGAL_STATE = "The state of the database connection pool is inconsistent";
	private static final String INVALID_RELEASE_CONNECTION = "Request received to release invalid connection object";
	private static final String INVALID_OWNER = "Release request received from an invalid owner";

	/**
	 * Value of the configured variable defines whether the poll is properly
	 * configured/initialised and is not yet destroyed
	 */
	private boolean configured = false;

	/**
	 * Size of the pool
	 */
	private int size = 10;

	/**
	 * Queue that stores the available objects of the pool. Whenever an object is
	 * acquired it is shifted to the 'acquired' queue and subsequently shifted back
	 * to this queue when it is released.
	 */
	private final ArrayBlockingQueue<Connection> available;

	/**
	 * Queue that stores the acquired objects of the pool. Whenever an object is
	 * acquired it is shifted this queue and subsequently shifted back to the
	 * 'available' queue when it is released.
	 */
	private final ArrayBlockingQueue<Connection> acquired;

	/**
	 * Contains information of the current owner of an acquired object. The map is
	 * consulted to ensure that only the correct owner of an object can release an
	 * object
	 * 
	 */
	private final Map<Connection, String> ownerMap;

	private static final String url = "localhost:3306";

	public static CustomDatabaseConnectionPool getInstance() {
		synchronized (CustomDatabaseConnectionPool.class) {
			if (null == _instance) {
				synchronized (CustomDatabaseConnectionPool.class) {
					_instance = new CustomDatabaseConnectionPool();
				}
			}
		}

		return _instance;
	}

	private CustomDatabaseConnectionPool() {
		this.ownerMap = new HashMap<>(size);
		this.available = new ArrayBlockingQueue<>(size);
		this.acquired = new ArrayBlockingQueue<>(size);
	}

	@Override
	public void init() throws SQLException {
		if (!configured) {
			synchronized (CustomDatabaseConnectionPool.class) {
				if (!configured) {
					for (int index = 0; index < size; index++) {
						Connection con = DriverManager.getConnection(url);
						available.offer(con);
					}
					configured = true;
				}
			}
		}
	}

	@Override
	public void destroy() throws SQLException {
		if (!configured) {
			throw new IllegalStateException(ILLEGAL_STATE);
		} else {
			synchronized (CustomDatabaseConnectionPool.class) {
				if (configured) {
					for (Connection con : available) {
						if (!con.isClosed()) {
							con.close();
						}
					}

					for (Connection con : acquired) {
						if (!con.isClosed()) {
							con.close();
						}
					}
					available.clear();
					acquired.clear();
					configured = false;
				}
			}
		}
	}

	@Override
	public Connection acquire() {
		verifyPoolState();
		Connection con = null;
		synchronized (CustomDatabaseConnectionPool.class) {
			if (!available.isEmpty()) {
				con = available.poll();
				String currentThread = Thread.currentThread().getName();
				ownerMap.put(con, currentThread);

				available.remove(con);
				acquired.offer(con);
			}
		}
		return con;
	}

	/**
	 * Used to release an object back to the pool. If the object is not released by
	 * the current owner of it, an {@link InvalidActivityException} is thrown
	 */
	@Override
	public void release(Connection obj) {
		verifyPoolState();
		if (null == obj)
			throw new IllegalArgumentException(INVALID_RELEASE_CONNECTION);

		synchronized (CustomDatabaseConnectionPool.class) {
			if (acquired.isEmpty() || !acquired.contains(obj))
				throw new IllegalArgumentException(INVALID_RELEASE_CONNECTION);

			String currentThread = Thread.currentThread().getName();
			if (ownerMap.get(obj).equals(currentThread)) {
				acquired.remove(obj);
				available.offer(obj);
				ownerMap.put(obj, null);
			} else {
				throw new InvalidActivityException(INVALID_OWNER);
			}

		}
	}

	private void verifyPoolState() {
		synchronized (CustomDatabaseConnectionPool.class) {
			if (!configured)
				throw new IllegalStateException(ILLEGAL_STATE);
		}
	}

}
