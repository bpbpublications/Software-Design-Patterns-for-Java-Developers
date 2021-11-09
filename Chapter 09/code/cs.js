const h = require('http')
const q = h.get('http://localhost:12000', (m) => {
  q.on('error', (e) => {
    console.log(e)
  })
  for(var i = 0; i< 1024; i++) 
    m.socket.write('x'.repeat(1024 * 1024))
})
