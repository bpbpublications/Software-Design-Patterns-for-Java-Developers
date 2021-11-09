process.on('SIGUSR2', () => {
  require('v8').writeHeapSnapshot()
})

setTimeout(() => {},1000000)
