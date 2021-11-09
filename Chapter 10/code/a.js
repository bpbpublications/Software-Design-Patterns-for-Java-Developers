const f = require('fs')
f.copyFile('./async.js', './a.js', (e) => {
if (!e) 
  console.log('copy success')
})

