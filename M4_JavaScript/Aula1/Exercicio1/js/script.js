function daisyGame (num) {
  resultado = "";
  isPar = num % 2 === 0;
  if (isPar) {resultado = "Love me not."}
  else {resultado = "Love me."}
  return resultado;
}

console.log(daisyGame (3));

//Modo Elvis Operator:
function daisyGameElvis (num){
  return num % 2 !== 0 ? "Love me" : "Love me not";
}

//Método ecnomizar caraacteres (muito café) (nada legível) -> ECMA 2015
function daisyGameDorgas(num) {
  return `Love me${ numero % 2 !== 0 ? '' : ' not'}`;
}

function daisyGameMenosDorgas(num) {
  var impar = num % 2 !== 0;
  return `Love me${ impar ? '' : ' not'}`;
}
console.log(daisyGameMenosDorgas(1));
