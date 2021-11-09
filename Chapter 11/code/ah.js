const async_hooks = require('async_hooks')

const obj = {}
async_hooks.createHook({
  init: (asyncId, type, triggerAsyncId) => {
    if (obj[triggerAsyncId] == null)
      obj[triggerAsyncId] = {}
    obj[triggerAsyncId][asyncId] = new Error().stack
  }
}).enable();

setTimeout(() => {
  console.log(obj)
}, 1000)
