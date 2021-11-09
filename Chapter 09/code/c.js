const n = require('net');
const c = n.createConnection({ port: 12000}, () => {
  console.log('connected to server!');
  c.write(`GET / HTTP/1.1\r\nHost: localhost:12000\r\nConnection: close\r\n\r\n`)
});
c.on('data', (data) => {
  console.log(data.toString());
  c.end();
});
c.on('end', () => {
  console.log('disconnected from server');
})
