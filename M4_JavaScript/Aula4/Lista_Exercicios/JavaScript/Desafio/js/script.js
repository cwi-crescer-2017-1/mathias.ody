//div onde tudo será inserido
var html = document.getElementById("scriptedElements");
var box = document.createElement('div');
box.className = "box";
var imgs = [];

function getRGB(hex){
    let c;
    if(/^#([A-Fa-f0-9]{3}){1,2}$/.test(hex)){
        c= hex.substring(1).split('');
        if(c.length== 3){
            c= [c[0], c[0], c[1], c[1], c[2], c[2]];
        }
        c= '0x'+c.join('');
        return ''+[(c>>16)&255, (c>>8)&255, c&255].join(',');
    }
}

function getRed(color) {
  return color.split(",", 1)[0];
}

function getGreen(color) {
  return color.split(",", 2)[1];
}

function getBlue(color) {
  return color.split(",", 3)[2];
}

//////////////////////////////////////////////////////////////
let btnPesquisar = document.getElementById("btnPesquisar");
btnPesquisar.onclick = clicado;
function clicado () {
    while (box.firstChild) {
      box.removeChild(box.firstChild);
    }
    let input = document.getElementById("paleta").value;
    let background = document.getElementById("bg");
    background.style.backgroundColor = input;
    input = getRGB(input);
    mostrarPokemon(getRed(input));
    mostrarPokemon(getGreen(input));
    mostrarPokemon(getBlue(input));
}

mostrarPokemon = function(num) {
    let img = document.createElement('img');
    img.src = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + num + ".png";
    imgs.push(img);
    box.appendChild(img);
    html.appendChild(box);
}
