const h = require('http')
const s = h.createServer((q, r) => {
  r.end('hello')
})

s.listen(12000)
