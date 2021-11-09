const h = require('http2')

const s = h.createSecureServer({key: key, cert: cert})
s.on('stream', (r, h) => {
  s.respond({'content-type': 'text/html',':status': 200})
  s.end('http2')
})
s.listen(12000)
