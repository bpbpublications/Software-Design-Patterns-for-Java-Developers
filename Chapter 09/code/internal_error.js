const h = require('http')
const s = h.createServer((q, r) => {
  r.statusCode = 500
  const e = new Error('500 internal server error')
  e.code = 500
  r.write(e.toString())
  r.end(e.stack)
  // r.end(`hello`)
})
s.listen(12000)
