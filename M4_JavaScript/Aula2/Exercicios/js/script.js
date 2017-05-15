/*Exercicio 1*/

function seriesInvalidas(series) {
  var retorno = [];
  var anoAtual = new Date().getFullYear();
  series.forEach(function (serie){
    if (serie.anoEstreia > anoAtual){
      retorno.push(serie.titulo);
    }
    for(elemento of Object.values(serie)) {
      if(typeof elemento === 'undefined' || elemento === null)
        retorno.push(serie.titulo);
    }
  })
  return retorno.toString();
}

console.log (seriesInvalidas(series));

/*Exercicio 2*/

function filtrarSeriesPorAno (series, ano) {
  var anoAtual = new Date().getFullYear();
  var retorno = [];
  series.forEach(function (serie){
    if (serie.anoEstreia === anoAtual){
      retorno.push(serie.titulo);
    }
  })
  return retorno.toString();
}

console.log (filtrarSeriesPorAno(series, 2017));

/*Exercicio 3*/

function mediaDeEpisodios (series) {
  var totalEpisodios = 0;
  var totalSeries = 0;
  series.forEach(function (serie){
    totalSeries ++;
    totalEpisodios += serie.numeroEpisodios;
  })
  return totalEpisodios/totalSeries;
}

console.log (mediaDeEpisodios(series));

/*Exercicio 4*/
function procurarPorNome (series, nome) {
  if (series.filter(s => s.elenco.indexOf(nome) >= 0).length > 0) {
    return true;
  }
  return false;
}

console.log (procurarPorNome(series, "Mathias Ody"));

/*Exercicio 5*/

function mascadaEmSerie (serie){
  let total = 0;
  total += 100000 * serie.diretor.length;
  total += 40000 * serie.elenco.length;
  return total;
}

console.log (mascadaEmSerie(series[0]));

/*Exercicio 6*/

function queroGenero (genero) {
  var resultado = [];
  series.forEach(function(serie){
    if (serie.genero.filter (a => a === genero).length === 1){
      resultado.push (serie.titulo);
    }
  })
  return resultado.toString();
}

console.log(queroGenero("Caos"));


/*Exercicio 7*/

function creditosIlluminatis (serie) {
  var creditos = serie.titulo + "\n\n";
  creditos += "Diretores\n\n"
  creditos = getCreditos (serie.diretor, creditos);
  creditos += "\n\nElenco\n\n"
  creditos = getCreditos (serie.elenco, creditos);
  return creditos;
}

function getCreditos (pessoas, creditos){
  var ordenarPorUltimoNome = function (a,b){
    a = a.split(" ");
    b = b.split(" ");
    a = a [a.length-1];
    b = b [b.length-1];

    if (a < b) return -1;
    if (a > b) return 1;
    return 0;
  }
  var pessoasOrdenadas = pessoas.sort(ordenarPorUltimoNome);
  pessoasOrdenadas.forEach(function(nome) {
    creditos += nome + "\n"
  })
  return creditos;
}

console.log(creditosIlluminatis(series[4]));


/*Exercicio 8*/

function detectarIlluminati (series){
  var todosTemAbreviacao = true;
  var arrayNomesAbreviados = []
    series.forEach(function (serie){
      todosTemAbreviacao = true;
      serie.elenco.forEach(function(nome){
        if(! nome.includes(". ")){
          todosTemAbreviacao = false;
        }
      })
      if (todosTemAbreviacao === true){
        arrayNomesAbreviados = serie.elenco;
      }
  })
  var resultado = "";
  arrayNomesAbreviados.forEach(function(nome){
    let indiceDoPonto = nome.indexOf(".");
    resultado += nome.slice (indiceDoPonto-1, indiceDoPonto);
  })
  return "#" + resultado;
}
console.log (detectarIlluminati(series));
