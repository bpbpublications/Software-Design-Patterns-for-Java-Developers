try {
  db.update(data)
} catch(e) {
  if (e.message === 'StaleConnectionError') {
    db.reconnect()
    db.update(data)
  }
}
