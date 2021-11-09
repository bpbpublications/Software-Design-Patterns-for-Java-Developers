const f = require('fs')
f.copyFileSync('./sync.js', './async.js')
console.log('copy success')

