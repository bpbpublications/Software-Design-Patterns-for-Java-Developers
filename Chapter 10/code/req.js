

function addID(d) {
  let b = require('v8').deserialize(d)
  b.id = require('crypto').randomUUID()
  return require('v8').serialize(d))
}

const c = require('crypto')
const v = require('v8')
function addID(d) {
  let b = v.deserialize(d)
  b.id = c.randomUUID()
  return v.serialize(d))
}
