const h = require('http')

const async_hooks = require('async_hooks')

const obj = {}
async_hooks.createHook({
  init: (asyncId, type, triggerAsyncId) => {
    if (obj[triggerAsyncId] == null)
      obj[triggerAsyncId] = {}
    obj[triggerAsyncId][asyncId] = new Error().stack
  }
}).enable();

const q = h.get('http://localhost:12000', (m) => {
  m.on('data', (d) => {
    console.log(d.toString())
  })
})
/*
q.on('error', (e) => {
  console.log(e.stack)
})
*/
q.end()
