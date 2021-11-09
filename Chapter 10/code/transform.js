const s = require('stream')
const f = require('fs')

const t = new s.Transform({
  transform(d, e, c) {
    c(null, d.toString().toUpperCase())
  }
})
const d = f.createReadStream(__filename)
d.pipe(t)
t.pipe(process.stdout)
