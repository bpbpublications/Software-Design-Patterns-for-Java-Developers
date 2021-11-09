

$ echo "/home/nodeuser/dumps/core.%e.%p" > /proc/sys/kernel/core_pattern
$ ulimit -c unlimited
$ node --report-uncaught-exception app.js
$ node --abort-on-uncaught-exception app.js
$ node --report-on-signal app.js
$ node --prof app.js
$ node --prof-process isolate-0x53986f70-88-v8.log
$ node app.js

