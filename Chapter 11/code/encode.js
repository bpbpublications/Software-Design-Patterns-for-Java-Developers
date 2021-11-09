
let input = process.argv[2]
for(var i=0; i < input.length; i++)
process.stdout.write(String.fromCharCode('a'.charCodeAt(0) + 'z'.charCodeAt(0) - input[i].charCodeAt(0)))
