const c = require('cluster')
const h = require('http')

if (c.isMaster) {
  c.fork()
  c.fork()
  c.fork()
  c.fork()
  c.fork()
  c.on('exit', (w, e, s) => {
    c.fork()
  })
} else {
  const s = h.createServer((q, r) => {
    res.end('hello')
  })
  s.listen(12000)
}
