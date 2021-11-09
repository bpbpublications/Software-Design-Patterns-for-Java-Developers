const h = require('http')
const s = h.createServer((q, r) => {
  r.end('hello')
})

s.listen(+process.argv[2])
