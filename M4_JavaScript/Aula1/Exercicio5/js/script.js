function fibonacci (num) {
  if (num === 0) {return 0;}
  if (num === 1) {return 1;}
  else {
    return fibonacci (num - 1) + fibonacci (num - 2);
  }
}

function fibonacciSum (num) {
  var total = 0;
  for (var i = num; i > 0; i --){
    total += fibonacci(i);
  }
  return total;
}

console.log (fibonacciSum (7));
