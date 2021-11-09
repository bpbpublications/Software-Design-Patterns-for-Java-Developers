const s = require('stream')
const f = require('fs')
const h = require('http')

const t = new s.Transform({
  transform(d, e, c) {
    c(null, d.toString().toUpperCase())
  }
})
const file = './tmp.data'
let d = f.readFileSync(file)
f.watch(file, (e, g) => {
  d = f.readFileSync(file)
})
h.createServer((q, r) => {
  t.pipe(r)
  t.write(d)
  r.end()
}).listen(12000)

