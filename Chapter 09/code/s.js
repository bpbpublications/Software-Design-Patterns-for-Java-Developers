const n = require('net')
const c = n.createServer((s) => {
s.on('data', (data) => {
  console.log(data.toString());
});
})

c.listen(12000)
