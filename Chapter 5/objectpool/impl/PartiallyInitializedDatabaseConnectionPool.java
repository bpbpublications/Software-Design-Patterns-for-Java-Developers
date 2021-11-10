package edu.bpb.oops.pattern.ch5.objectpool.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;

import edu.bpb.oops.pattern.ch5.objectpool.ObjectPool;

/**
 * A partially initialised object pool is initialised with a smaller number of
 * objects instead of being filled to the brim. Rest of the pool is filled with
 * objects as and when required; the objects are lazily loaded into the pool.
 * The initial size of the object pool can be decided based on the requirement;
 * for this implementation it is half the complete size of the pool.<br>
 * <br>
 * 
 * This implementation is an extension to the
 * {@link FixedSizeDatabaseConnectionPool}
 * 
 * @author Lalit Mehra
 *
 */
public class PartiallyInitializedDatabaseConnectionPool implements ObjectPool<Connection> {

	private static PartiallyInitializedDatabaseConnectionPool _instance;

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
	 * Initial size of the pool that is filled with objects during initialisation.
	 * The value of currentSize can reach the overall size of the pool when the pool
	 * is filled with more objects; past that the pool can not be filled.
	 */
	private int currentSize = size / 2;

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

	public static PartiallyInitializedDatabaseConnectionPool getInstance() {
		synchronized (PartiallyInitializedDatabaseConnectionPool.class) {
			if (null == _instance) {
				synchronized (PartiallyInitializedDatabaseConnectionPool.class) {
					_instance = new PartiallyInitializedDatabaseConnectionPool();
				}
			}
		}

		return _instance;
	}

	private PartiallyInitializedDatabaseConnectionPool() {
		this.available = new ArrayBlockingQueue<>(size);
		this.acquired = new ArrayBlockingQueue<>(size);
	}

	/**
	 * Partially initialising the pool. The method is synchronised to ensure that
	 * the pool is configured only once; double check locking mechanism is used to
	 * safeguard against multiple threads calling the method at the same time.<br>
	 * <br>
	 */
	@Override
	public void init() throws SQLException {
		if (!configured) {
			synchronized (PartiallyInitializedDatabaseConnectionPool.class) {
				if (!configured) {
					// initialising half the pool
					for (int index = 0; index < currentSize; index++) {
						Connection con = DriverManager.getConnection(url);
						available.offer(con);
					}
					configured = true;
				}
			}
		}
	}

	/**
	 * Destroys the object pool and closes all the connections to the database. <br>
	 * Both the queues are cleared. The method does not wait for the objects to be
	 * released.
	 */
	@Override
	public void destroy() throws SQLException {
		if (!configured) {
			throw new IllegalStateException(ILLEGAL_STATE);
		} else {
			synchronized (PartiallyInitializedDatabaseConnectionPool.class) {
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

	/**
	 * Used to acquire an object from the pool. If all the objects in the pool have
	 * already been acquired but the complete size of the pool is not yet reached, a
	 * new object is instantiated, added to the pool and is returned to be acquired.
	 */
	@Override
	public Connection acquire() throws SQLException {
		verifyPoolState();
		Connection con = null;
		synchronized (PartiallyInitializedDatabaseConnectionPool.class) {
			if (available.isEmpty() && currentSize < size)
				con = available.poll();
			else if (!available.isEmpty()) {
				con = DriverManager.getConnection(url);
				currentSize++;
			}
			acquired.offer(con);
		}
		return con;
	}

	/**
	 * Used to release an object back to the pool. If the argument is null or
	 * denotes an already released object an {@link IllegalArgumentException} is
	 * thrown
	 */
	@Override
	public void release(Connection obj) {
		verifyPoolState();
		if (null == obj)
			throw new IllegalArgumentException(INVALID_RELEASE_CONNECTION);

		synchronized (PartiallyInitializedDatabaseConnectionPool.class) {
			if (acquired.isEmpty() || !acquired.contains(obj))
				throw new IllegalArgumentException(INVALID_RELEASE_CONNECTION);

			acquired.remove(obj);
			available.offer(obj);
		}
	}

	/**
	 * Used to verify the current state of the pool, defined by the value of the
	 * 'configured' variable
	 */
	private void verifyPoolState() {
		synchronized (PartiallyInitializedDatabaseConnectionPool.class) {
			if (!configured)
				throw new IllegalStateException(ILLEGAL_STATE);
		}
	}

}
