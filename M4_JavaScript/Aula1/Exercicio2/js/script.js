function maiorTexto (texto1, texto2) {
  var tamanhoTexto1 = getTamanhoTexto(texto1);
  var tamanhoTexto2 = getTamanhoTexto(texto2);
  if (tamanhoTexto1 >= tamanhoTexto2) {return texto1;}
  else {return texto2};
}

function getTamanhoTexto (texto) {
  var contador = 0;
  for (var palavra = 0; palavra < texto.length; palavra++) {
    for (var caractere = 0; caractere < texto[palavra].length; caractere++){
      contador++;
    }
  }
  return contador;
}

var texto1 = ['O','meu','brother'];
var texto2 = ['Então', 'você','é','quem','chamam','de','javascript'];

console.log(maiorTexto (texto1, texto2));
