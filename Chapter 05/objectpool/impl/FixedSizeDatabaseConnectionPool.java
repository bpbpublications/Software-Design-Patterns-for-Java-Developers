package edu.bpb.oops.pattern.ch5.objectpool.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

import edu.bpb.oops.pattern.ch5.objectpool.ObjectPool;

/**
 * Fixed Size Database Connection Pool
 * 
 * @author Lalit Mehra
 *
 */
public class FixedSizeDatabaseConnectionPool implements ObjectPool<Connection> {

	private static FixedSizeDatabaseConnectionPool _instance;
	
	private static final String ILLEGAL_STATE = "The state of the database connection pool is inconsistent";
	private static final String INVALID_RELEASE_CONNECTION = "Request received to release invalid connection object";

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

	private static final String url = "localhost:3306";

	public static FixedSizeDatabaseConnectionPool getInstance() {
		synchronized (FixedSizeDatabaseConnectionPool.class) {
			if (null == _instance) {
				synchronized (FixedSizeDatabaseConnectionPool.class) {
					_instance = new FixedSizeDatabaseConnectionPool();
				}
			}
		}

		return _instance;
	}

	private FixedSizeDatabaseConnectionPool() {
		this.available = new ArrayBlockingQueue<>(size);
		this.acquired = new ArrayBlockingQueue<>(size);
	}

	@Override
	public void init() throws SQLException {
		if (!configured) {
			synchronized (FixedSizeDatabaseConnectionPool.class) {
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
			synchronized (FixedSizeDatabaseConnectionPool.class) {
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
		synchronized (FixedSizeDatabaseConnectionPool.class) {
			if (!available.isEmpty())
				con = available.poll();
			acquired.offer(con);
		}
		return con;
	}

	@Override
	public void release(Connection obj) {
		verifyPoolState();
		if (null == obj)
			throw new IllegalArgumentException(INVALID_RELEASE_CONNECTION);

		synchronized (FixedSizeDatabaseConnectionPool.class) {
			if (acquired.isEmpty() || !acquired.contains(obj))
				throw new IllegalArgumentException(INVALID_RELEASE_CONNECTION);

			acquired.remove(obj);
			available.offer(obj);
		}
	}

	private void verifyPoolState() {
		synchronized (FixedSizeDatabaseConnectionPool.class) {
			if (!configured)
				throw new IllegalStateException(ILLEGAL_STATE);
		}
	}

}
