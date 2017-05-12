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

//RECURSÃO

/*function recursao (num) {
  if (num === 0) {return 0;}
  return num + recursao(num - 1);
}

console.log(recursao(3));*/

//num = 3
// 3 + recursao (2)
// 3 + recursao (2) + recursao (1)
// 3 + recursao (2) + recursao(1) + recursao (0)
// 3 + recursao (2) + recursao(1) + 0
// 3 + recursao (2) + 1 + 0
// 3 + 2 + 1 + 0
// 6
