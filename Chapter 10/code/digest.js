const f = require('fs')

function digest(file) {
  const d = f.readFile(file, (e, d) => {
    let l = 0
    for (var i = 0; i < d.length - 2; i++)
      l = (l << 8) | d[i + 2]
    return l
  })
}
