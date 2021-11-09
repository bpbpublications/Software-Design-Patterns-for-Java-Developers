dbclient.connect(url, {
  pool: 128,
  assignmentPolicy: 'ROUNDROBIN',
  cleanOnTimeout: true,
  collectStale: true,
  autoExpand: true,
  autoShrink: true
})
