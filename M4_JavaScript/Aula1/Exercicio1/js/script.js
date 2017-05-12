function daisyGame (num) {
  resultado = "";
  isPar = num % 2 === 0;
  if (isPar) {resultado = "Love me not."}
  else {resultado = "Love me."}
  return resultado;
}

console.log(daisyGame (3));
