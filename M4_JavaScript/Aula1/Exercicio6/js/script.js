function queroCafe (mascada, precos) {
  sort (precos);
  var indiceDeCorte = 0;
  var resultado = "";
  for (var i = 0; i < precos.length; i++){
    if (precos[i] > mascada) {
      indiceDeCorte = i - 1;
      break;
    }
  }

  for (var j = 0; j < indiceDeCorte; j++){
    if (j === 0) {
      resultado += precos[j];
      continue;
    }
    else {
      resultado += ", " + precos[j];
    }
  }
  return resultado;
}

function sort(lista) {
    var trocando;
    do {
        trocando = false;
        for (var i=0; i < lista.length-1; i++) {
            if (lista[i] > lista[i+1]) {
                var temp = lista[i];
                lista[i] = lista[i+1];
                lista[i+1] = temp;
                trocando = true;
            }
        }
    } while (trocando);
}

var listaPrecos = [ 5.16, 2.12, 1.15, 3.11, 17.5 ];

console.log(queroCafe (5.16,listaPrecos));
