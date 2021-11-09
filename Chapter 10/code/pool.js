const z = require('zlib')
const c = require('crypto')
const p = require('perf_hooks')
const start = p.performance.now()
process.on('exit', (c) => {
 const end = p.performance.now()
 console.log(Math.round(end - start))
})
for(var i = 0; i< +process.argv[2]; i++) {
  c.randomBytes(1024 * 1024, (e, b) => {
    z.gzip(b, (r, d) => {})
})
}
