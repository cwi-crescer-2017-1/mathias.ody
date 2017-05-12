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


//ENTENDI ERRADO O EXERCÍCIO
//Refazendo:

function maiorTexto (textos) {
  var maiorTamanho = 0;
  for (var i = 0; i < texto.length; i++) {   //Lembrando que variaveis podem ser declaradas no for: for (var i = 0, var maiorTamanho = 0; [...])
    if (textos[i].length > maiorTamanho.length; i++){
      maiorTamanho = textos [i];
    }
  }
  return maiorTamanho;
}

//Variavel apenas dentro de um bloco específico (ECMA 2015)> let
for (let i = 0; i < a.length; i++) {

}

//JavaScript tem const
const constante = 0;
//Não quer dizer imutabilidade em objetos
const seiya ={nome:'Seiya'};
seiya.nome = 'Shiryu'; //permitido
