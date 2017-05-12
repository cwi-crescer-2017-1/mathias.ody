function imprime (lista, funcao) {
  if(typeof funcao !== "function"){
    console.log("Ocorreu uma treta. Argumento incorreto, esperava-se \"function\"");
  }
  else {
    for (var i = 0; i < lista.length; i++){
      olaInstrutor(lista[i])
    }
  }
}

function olaInstrutor (instrutor) {
  console.log ("ola querido instrutor ",instrutor);
}

console.log(imprime (['bernardo', 'nunes','pedro'], olaInstrutor));


function imprime (textos, funcaoParaExecutar) {
    lista.forEach(funcaoParaExecutar); //ela ja vai chamar as funções
}
