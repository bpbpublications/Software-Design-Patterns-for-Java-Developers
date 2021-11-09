const {
  performance,
  PerformanceObserver
} = require('perf_hooks');

function someFunction() {
  console.log('hello world');
}

//const wrapped = performance.timerify(someFunction);

const obs = new PerformanceObserver((list) => {
  console.log(list.getEntries()[0].duration);
  obs.disconnect();
});
obs.observe({ entryTypes: ['function'] });

// A performance timeline entry will be created
//wrapped();
someFunction()
