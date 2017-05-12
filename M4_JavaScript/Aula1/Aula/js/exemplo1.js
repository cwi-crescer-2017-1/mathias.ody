/*
PRIMEIRAMENTE, ARRAYS SÃO OBJETOS, com a propriedade length
adicionar um obejto na posição 0 é o mesmo que criar uma classe com indice 0 e algum valor
array ['alguma coisa'] //funciona, vai adicionar a propriedade
*/

var obj = {};
obj [0] = 'Nome';
console.log(obj[0]) //VEJA! UM ARRAY NO JAVASCRIPT!

console.log("Hello");

var pi = 3.14;

if (typeof pi !== "undefined"){
  console.log(pi);
}



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
var seiya = {nome:"Seiya", idade:12};//funciona parecido com uma struct do C
//exemplo de utilização
var seiya = {nome: "Seyia", vida : 90, tipo: "Bronze" }
seiya.nome = "João"
seiya[5] = 12;
seiya.algo = 34;
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////




console.log(somar1 (2,2));

function somar1 (a,b){
  return a + b;
}

//console.log (somar2 (2,2));- NÃO FUNCIONA: esse tipo de declaração não fica na memória até ser "lida" pelo js
var somar2 = function (a,b){
  return a + b;
}
console.log (somar2 (2,2)); //aqui funciona!

//ECMA 2015 APENAS
//console.log (somarArrowFunction (2,2)); -NÃO FUNCIONA: esse tipo de declaração não fica na memória até ser "lida" pelo js
var somarArrowFunction = (a,b) => a + b;
console.log (somarArrowFunction (2,2)); //aqui funciona!

var c;
c = c || 3; //espécide de ternário

var somar = function () {
  var a = arguments [0], b = arguments[1] //mesmo sem pedir argumentos, eles ficam armazenados em um array arguments
  return a + b;
}

isNaN(undefined + undefined) //se é Nan

isNaN = function () { "fazer esssa merda funciona - sobreescrever um método do sistema"}

Array(13).join(1+ "-");
//1-1-1-1-1-1-1-1-1-1-1-1-1-

var somar = function (i,j) {
  var somarInterno = function (a,b){
    return a + b;
  }
  return somarInterno (i,j); //UUUUUUAAAAAARRRRGGGGGHHHHHHH
}


//funcoes podem ser variaveis, então é possivel passar sua referencia como parametros pra uma outra funcao
var calcular = function (funcao, a, b){
  return funcao (a,b);
}
console.log ("calculo: " + calcular (somar, 3,4)) //nice

var resultado = (function multiplicar (a,b) {
  return a * b;
})(2,3); //declaração e imediata chamada de função
// essa função não precisa ter nome e não pode ser utilizada posteriormente.

for (var i in is) //percorre as propriedades
//exemplo:
for (var i in is) {
  var a = 1, b =2;
  console.log (i); //retorna os indices do array
}

var a = {algo : "alguma coisa"}
a.idade = 12;
a.dias = 7;
for (var i in is) {
  console.log (i); //retorna as propriedades do objeto (algo, idade, dias)
}

for (var i of is) //ECMA 2015 -> funciona como o foreach

var agora = new Date(); //data de agora
//ATENÇÃO: os meses e dias da semana começam em 0 (eu sei, que bosta)
