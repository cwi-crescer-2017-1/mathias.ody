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
    console.log(this);
    //container
    var box = document.createElement('div');
    box.className = "box";
    //nome e id
    var nomeSpan = document.createElement('span');
    var nomeTxt = document.createTextNode(this.name.toUpperCase() + " - " + num);
    nomeSpan.appendChild(nomeTxt);
    box.appendChild(nomeSpan);
    //imagem
    var img = document.createElement('img');
    img.src = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + num + ".png";
    box.appendChild(img);
    //tipos:
    var lista = this.types;
    var tipos = document.createElement ('ul');
    lista.forEach(function (itemAtual){
        var item = document.createElement ('li');
        var itemTxt = document.createTextNode(itemAtual.type.name);
        item.appendChild(itemTxt);
        tipos.appendChild(item);
    })
    box.appendChild(tipos);

    //atributos
    var stats = this.stats;
    var atributos = document.createElement('div');
    stats.forEach(function (stat) {
        console.log(stat.stat.name);
        console.log(stat.base_stat);
        var atributo = document.createElement('div');
        var atributoNome = document.createElement('div')
        atributoNome.className = 'atributo';
        atributoNome.innerHTML = stat.stat.name.toUpperCase();
        var valor = document.createElement('progress');
        valor.setAttribute("value",stat.base_stat);
        valor.setAttribute("max",100);
        atributo.appendChild(atributoNome);
        atributos.appendChild(atributo);
        atributo.appendChild(valor);
    })
    box.appendChild(atributos);

    html.appendChild(box);
}
