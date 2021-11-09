const n = require('net')
const h = require('http')
const s = n.createServer((d) => {
  d.on('data', (m) => {
    console.log(m.toString())
  })
})
s.listen(12000, () => {
  const q = h.request('http://localhost:12000', (m) => {
    m.on('data', (d) => {
      console.log(d)
    })
  })
  q.setHeader('Transfer-Encoding', 'gzip')
  q.end()
})
