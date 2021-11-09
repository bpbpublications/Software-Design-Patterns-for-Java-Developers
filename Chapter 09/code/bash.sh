while [ 1 ]
  do
  node app.js
  if test core
    then
    mkdir /tmp/`date +"%m%d%y%H%M%S"`
    mv core /tmp/`date +"%m%d%y%H%M%S"`/core
  fi
done
