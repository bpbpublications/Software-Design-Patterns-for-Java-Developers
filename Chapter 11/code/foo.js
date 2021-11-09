// name: foo
// function: write data into the object's
// internal buffer
// invoke a special handler for long writes
function foo(data, encoding, cb) {
  if (data.length > 64 * 1024) {
    return longWrite(data, encoding, cb)
  }
  setTimeout(() => {
    this.buffer.push(data.toString())
    this.written += data.length
    cb()
  }, Math.floor(Math.random() * 128))
}
