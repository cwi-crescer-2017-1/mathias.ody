function queroCafe (mascada, precos) {
  sort (precos);
  var resultado = "";
  for (var i = 0; i < precos.length; i++){
    if (precos[i] < mascada) {
        if (i === 0) {
          resultado += precos[i];
          continue;
        }
        else {
          resultado += ", " + precos[i];
        }
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


// Entenda isso:
function queroCafe(mascada, precos) {
    return precos
    .filter (function (a){
        return a <= mascada;
    })
    .sort (function (a,b) {
        return a-b;
    })
    .join(',')
}

function queroCafe(mascada, precos) {
    return precos
    .filter (a => a <= mascada)
    .sort ((a,b)=> a-b)
    .join(',')
}
