const worker = require('worker_threads')
const w = new worker.Worker('./worker.js')
w.on('message', (m) => {
  console.log(`worker message: ${m}`)
})
w.on('error', (e) => {
  console.log(`worker error: ${e}`)
})
w.on('exit', (c) => {
  console.log(`worker exit code: ${c}`)
})
