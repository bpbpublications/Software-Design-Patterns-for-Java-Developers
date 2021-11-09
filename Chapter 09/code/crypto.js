const crypto = require('crypto')
const data = 'top secret'
const buffer = Buffer.from(data)
crypto.publicEncrypt(buffer, rsa_pubenc)
