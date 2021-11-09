const f = require('fs')
f.readdir('.', (e, l) => {
  l.forEach((e) => {
    console.log(e)
  })
})
