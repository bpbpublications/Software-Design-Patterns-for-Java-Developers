if (db.connection.status === db.CONN.STALE)
  db.reconnect()
db.update(data)
