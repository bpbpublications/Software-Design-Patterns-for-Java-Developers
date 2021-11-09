const child = require('child_process')

const ls = child.spawn('ls')

ls.stdout.on('data', (d) => {
  console.log(d.toString())
})

ls.stderr.on('data', (d) => {
  console.log(d.toString())
})
