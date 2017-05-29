var app = angular.module('App', ['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider
    .when('/chat', {
      controller: 'chatController',
      templateUrl: 'html/chat.html'
    })

    .otherwise({redirectTo: '/chat'});
});

app.controller('chatController', function ($scope, $routeParams,mensagemService) {
  $scope.mensagens = [];
  $scope.username = "";

  let username = "";
  let linkFoto = "";
  //cadastro usuario 
  if (localStorage.getItem('nome') === null) {
    username = prompt("Insira seu nome", "");
    linkFoto = prompt("Insira um link para sua foto", "");
  }
  else {
    username = localStorage.getItem('nome');
    linkFoto = localStorage.getItem('foto');
  }
  
  let user = {
    Nome: "Illuminati",
    LinkFoto: "http://www.toyhalloffame.org/sites/www.toyhalloffame.org/files/toys/square/rubber-duck_0.jpg"
  }

  if (username != ""){        
    user.Nome = username;
    
    localStorage.setItem('nome', username,toString()); 
    localStorage.setItem('foto', linkFoto,toString());
  }
  if (linkFoto != ""){
    user.LinkFoto = linkFoto;
  }

  $scope.username = user.Nome;

  $scope.clearCache = function (){
    localStorage.clear();
  }

  //listar mensagem
  function listaMensagens() {
    mensagemService.listar().then(function (response) {
      $scope.mensagens = response.data;
      setTimeout (listaMensagens, 1000);
      setTimeout (setarScrollParaBaixo, 100);
    });
  }

  listaMensagens();
  setTimeout (setarScrollParaBaixoIncial,1000);

  //POST
  $scope.sendMessage = function () {
    if ($scope.input == "") { return; }
    let mensagemParaEnviar = {
      texto:$scope.input,
      Usuario : user
    }
    mensagemService.create(mensagemParaEnviar);
    $scope.input = "";
    delete $scope.mensagem;
  }

  function setarScrollParaBaixoIncial () {
    var box = document.getElementById('message-list');
    box.scrollTop = box.scrollHeight;
  }

  function setarScrollParaBaixo () {
    var box = document.getElementById('message-list');
    var isScrolledToBottom = box.scrollHeight - box.clientHeight <= box.scrollTop + 200;
    if (isScrolledToBottom) {
      box.scrollTop = box.scrollHeight;
    }
  }
})