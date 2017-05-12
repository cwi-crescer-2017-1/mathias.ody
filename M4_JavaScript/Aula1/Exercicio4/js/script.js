function somar1 (a){
  return function somar2 (b) {
    return a+b;
  }
}

console.log(somar1(10)(10));
//Uma função retorna a outra e esta é chamada novamente.
//Como somar2 está no escopo de somar1, funciona a soma
//Weird.
