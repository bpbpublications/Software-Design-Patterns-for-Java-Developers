const w = require('worker_threads')
const f = require('fs')

if (w.isMainThread) {
  const worker = new w.Worker(__filename,
    {workerData: './worker.js'})
  worker.on('message', (m) => {
    console.log(m)
  })
} else {
  const file = w.workerData
  const d = f.readFile(file, (e, d) => {
    let l = 0
    for (var i = 0; i < d.length; i++)
      l = (l << 8) | d[i + 2]
    w.parentPort.postMessage(l)
  })
}
