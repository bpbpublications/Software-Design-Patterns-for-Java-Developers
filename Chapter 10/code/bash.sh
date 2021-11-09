$ sudo sysctl -w net.ipv4.tcp_window_scaling=1
$ sudo sysctl -w net.core.rmem_max=16777216
$ sudo sysctl -w net.core.wmem_max=16777216
$ sudo sysctl -w net.ipv4.tcp_rmem="4096 87380 16777216"
$ sudo sysctl -w net.ipv4.tcp_wmem="4096 16384 16777216"

$ ulimit -d unlimited
$ ulimit -n unlimited
$ ulimit -m unlimited
$ ulimit -t unlimited
$ ulimit -v unlimited

$ node --max-semi-space-size=1024 app.js
$ node --max-old-space-size=4096 app.js
$ node --trace-gc app.js

