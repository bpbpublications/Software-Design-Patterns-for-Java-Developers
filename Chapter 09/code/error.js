setTimeout(() => {
  if (source.hasData)
    source.emit('error', 'ETIMEOUT')
},10000)
