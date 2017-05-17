//div onde tudo será inserido
var html = document.getElementById("scriptedElements");


//////////////////////////////////////////////////////////////
let btnPesquisar = document.getElementById("btnPesquisar");
btnPesquisar.onclick = clicado;
function clicado () {
    let input = document.getElementById("numPkm").value;
    let url = "http://pokeapi.co/api/v2/pokemon/" + input + "/";
    fetch(url).then(response => response.json())
    .then(json =>{
        json.mostrarPokemon(input);
    })
}

Object.prototype.mostrarPokemon = function(num) {
    let box = document.createElement('div');
    box.className = "box";
    let nomeSpan = getNome(this, num);
    let img = getImg(this, num);
    let tipos = getTipos(this);
    let atributos = getAtributos (this);
    box.appendChild(nomeSpan);
    box.appendChild(img);
    box.appendChild(tipos);
    box.appendChild(atributos);

    html.appendChild(box);
}

function getAtributos (pokemon){
  let stats = pokemon.stats;
  let atributos = document.createElement('div');
  stats.forEach(function (stat) {
      let atributo = document.createElement('div');
      let atributoNome = document.createElement('div')
      atributoNome.className = 'atributo';
      atributoNome.innerHTML = stat.stat.name.toUpperCase();
      let valor = document.createElement('progress');
      valor.setAttribute("value",stat.base_stat);
      valor.setAttribute("max",100);
      atributo.appendChild(atributoNome);
      atributo.appendChild(valor);
      atributos.appendChild(atributo);
  })
  return atributos;
}

function getTipos (pokemon) {
  let lista = pokemon.types;
  let tipos = document.createElement ('ul');
  lista.forEach(function (itemAtual){
      let item = document.createElement ('li');
      let itemTxt = document.createTextNode(itemAtual.type.name);
      item.appendChild(itemTxt);
      tipos.appendChild(item);
      tipos.append(item);
  })
  return tipos;
}

function getImg (pokemon, num) {
  let img = document.createElement('img');
  img.src = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + num + ".png";
  return img;
}

function getNome (pokemon, num){
  let nomeSpan = document.createElement('span');
  let nomeTxt = document.createTextNode(pokemon.name.toUpperCase() + " - " + num);
  nomeSpan.appendChild(nomeTxt);
  return nomeSpan;
}
