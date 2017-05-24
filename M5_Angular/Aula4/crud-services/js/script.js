var app = angular.module('App', ['ngRoute']);

app.config(function ($routeProvider) {

  $routeProvider
    .when('/aulas', {
      controller: 'Pagina01Controller',
      templateUrl: 'html/aulas.html'
    })
    .when('/instrutores', {
      controller: 'Pagina02Controller',
      templateUrl: 'html/instrutores.html'
    })
    .otherwise({redirectTo: '/aulas'});
});

app.controller('Pagina01Controller', function ($scope, $routeParams, aulaService) {
    $scope.editingId = -1;
    $scope.aulaEdit = { string : "" };

    listarAulas();

    //
    //Adicionar aulas
    //
    $scope.incluirAula = function(inputNomeAula) {
        //Checagem de erros
        if (Object.keys($scope.Form.cadastrarAula.$error).length > 0) {
            check_erro($scope.Form.cadastrarAula.$error, document.getElementsByName("cadastrarAula"))
        }
        else {
            //Salvar
            tempAula = {nome : inputNomeAula};
            aulaService.create(tempAula).then(function(resposta){
                listarAulas();
            });
            $scope.aulaInput = "";
            lancar_texto("Aula incluída!")
        }
    }

    //
    //Deletar aula
    //
    $scope.deletarAula = function (id) {
        let posInArray = $scope.aulas.getPosArrayById (id);
        aulaService.removeById(id).then(function(resposta){
            listarAulas();
        });
        lancar_texto("Aula excluída com sucesso!");
    }

    //
    //Editar aula
    //
    $scope.editarAula = function(id) {
        let posInArray = $scope.aulas.getPosArrayById (id);
        $scope.editingId = id;
        aulaService.getAulaById(id).then(function (resposta) {
            $scope.aulaEdit.string = resposta.data.nome;
        })
        blockButtons(true);
        lancar_texto("Digite e clique em apply");
    }

    //
    //Aplicar alterações feitas à aula
    //
    $scope.applyAula = function (id) {
        let posInArray = $scope.aulas.getPosArrayById (id);
        var tempAula = {id: id, nome: $scope.aulaEdit.string}; 
        aulaService.update(tempAula).then(function(resposta){
            listarAulas();
        });
        $scope.editingId = -1;
        blockButtons(false);
        lancar_texto("Aula editada com sucesso!")
    }

    //
    //Ao focar em algum item da tela
    //
    $scope.focou = function () {
        limpar_erros();
    }

    // 
    //Pegar as aulas no servidor e listar
    //
    function listarAulas () {
        aulaService.listar().then(function (resposta) {
            //recebe e manipula uma promessa(resposta)
            $scope.aulas = resposta.data;
        })
    }

    //
    //Lança um texto no log da tela
    //
      function lancar_texto (texto) {
        limpar_erros();
        $scope.logOutput = texto;
  }

    // 
    //Limpar erros no log da tela 
    // 
    function limpar_erros () { 
        $scope.logOutput = ""; 
        let footer = document.getElementsByClassName("footer"); 
        footer[0].classList.remove("log"); 
        let elementosErro = document.getElementsByClassName("erro"); 
        for (let i = 0; i < elementosErro.length; i++) { 
            elementosErro[i].classList.remove ("erro"); 
        } 
    } 

    //
    //Lança um erro na tela
    //
    function lancar_erro  (erro) {
        $scope.logOutput = erro;
        let footer = document.getElementsByClassName("footer");
        footer[0].classList.add("log");
    }
 
    // 
    //Checar tipo do erro e chamar retorno necessário 
    // 
    function check_erro (erro, elemento) { 
        if (elemento[0].toString() === "[object HTMLInputElement]") { 
            elemento[0].classList.add ("erro"); 
        } 
 
        if (erro.required === true) { 
            lancar_erro("Preencha o campo!"); 
        } 
 
        else if (erro.minlength === true) { 
            lancar_erro("Informação muito curta!"); 
        } 
 
        else if (erro.maxlength === true) { 
            lancar_erro("Informação muito longa!"); 
        } 
 
        else if (erro.email === true) { 
            lancar_erro("Insira um e-mail válido!"); 
        } 
    } 
});

app.controller('Pagina02Controller', function ($scope, $routeParams, instrutorService) {
    $scope.editingIdInstrutor = -1;
    $scope.inputEditAulas = {aulas : []};
    $scope.inputInstrutor = {                    
        nome: '',                  
        sobrenome: '',          
        idade: '',                       
        email: '',
        dandoAula: false,                                       
        urlFoto: ''  
    }
    $scope.instrutorEdit = { }

    listarInstrutores();

    //
    //Adicionar instrutores
    //
    $scope.incluirInstrutor = function(inputInstrutor) {
        //Checagem de erros
        if ($scope.checkNenhumErro()){
            if ($scope.inputInstrutor.urlFoto === "") {
                $scope.inputInstrutor.urlFoto = "http://www.freeiconspng.com/uploads/illuminati-icon-png-1.png";
            }
            let instrutorParaAdicionar = angular.copy($scope.inputInstrutor);
            instrutorParaAdicionar.id = $scope.lastIdInstrutor++;
            instrutorParaAdicionar.aulas = [];
            if ($scope.inputInstrutorAulas != null) {
                $scope.inputInstrutorAulas.forEach(function (elemento){
                    instrutorParaAdicionar.aulas.push(elemento)
                })
            }
            instrutorService.create(instrutorParaAdicionar).then(function(resposta){
                listarInstrutores();
            });
            lancar_texto("Instrutor incluído!");
            
            for (let elemento in $scope.inputInstrutor) {
                if (typeof $scope.inputInstrutor[elemento] === "string" || typeof $scope.inputInstrutor[elemento] === "number") {
                    $scope.inputInstrutor[elemento] = "";
                }
            }
        }
    }

    //
    //Checar se o objeto criado não contém erros
    //
    $scope.checkNenhumErro = function () {
        let nenhumErro = true;
        if (Object.keys($scope.Form.cadastrarNomeInstrutor.$error).length > 0) {
            nenhumErro = false; 
            check_erro($scope.Form.cadastrarNomeInstrutor.$error, document.getElementsByName("cadastrarNomeInstrutor"))}
        if (Object.keys($scope.Form.cadastrarSobrenomeInstrutor.$error).length > 0) {
            nenhumErro = false; 
            check_erro($scope.Form.cadastrarSobrenomeInstrutor.$error, document.getElementsByName("cadastrarSobrenomeInstrutor"))}
        if (Object.keys($scope.Form.cadastrarIdadeInstrutor.$error).length > 0) { 
            nenhumErro = false;
            check_erro($scope.Form.cadastrarIdadeInstrutor.$error, document.getElementsByName("cadastrarIdadeInstrutor"))}
        if (Object.keys($scope.Form.cadastrarEmailInstrutor.$error).length > 0) { 
            nenhumErro = false;
            check_erro($scope.Form.cadastrarEmailInstrutor.$error, document.getElementsByName("cadastrarEmailInstrutor"))}

        return nenhumErro;
    }

    //
    //Checar se o objeto editado não contém erros
    //
    function checkNenhumErroEdit () {
        let nenhumErro = true;
        if (Object.keys($scope.Form.nomeEdit.$error).length > 0) {
            nenhumErro = false; 
            check_erro($scope.Form.nomeEdit.$error, document.getElementsByName("nomeEdit"))}
        if (Object.keys($scope.Form.sobrenomeEdit.$error).length > 0) {
            nenhumErro = false; 
            check_erro($scope.Form.sobrenomeEdit.$error, document.getElementsByName("sobrenomeEdit"))}
        if (Object.keys($scope.Form.idadeEdit.$error).length > 0) { 
            nenhumErro = false;
            check_erro($scope.Form.idadeEdit.$error, document.getElementsByName("idadeEdit"))}
        if (Object.keys($scope.Form.emailEdit.$error).length > 0) { 
            nenhumErro = false;
            check_erro($scope.Form.emailEdit.$error, document.getElementsByName("emailEdit"))}

        return nenhumErro;
    }

    //
    //Deletar instrutor
    //
    $scope.deletarInstrutor = function (id) {
        let posInArray = $scope.instrutores.getPosArrayById (id);
        instrutorService.removeById(id).then(function(resposta){
            listarInstrutores();
        });
        lancar_texto("Instrutor demitido com muito sucesso!;)");
    }

    //
    //Editar instrutor
    //
    $scope.editarInstrutor = function(id) {
        let posInArray = $scope.instrutores.getPosArrayById (id);
        $scope.editingIdInstrutor = id;
        instrutorService.getInstrutorById(id).then(function (resposta) {
            $scope.instrutorEdit = resposta.data;
            $scope.instrutorEdit.aulas.forEach(function (elemento) {
                $scope.inputEditAulas.aulas.push (elemento);
            })
        })    
        blockButtons(true);
        lancar_texto("Altere e clique em apply");
    }

    //
    //Aplicar alterações feitas ao instrutor
    //
    $scope.applyInstrutor = function (id) {
        let posInArray = $scope.instrutores.getPosArrayById (id);
        var tempInstrutor = $scope.instrutorEdit; 
        tempInstrutor.aulas = [];
        $scope.inputEditAulas.aulas.forEach(function (elemento){
            tempInstrutor.aulas.push(elemento)
        })

        instrutorService.update(tempInstrutor).then(function(resposta){
            listarInstrutores();
        });
        $scope.inputEditAulas.aulas = [];
        $scope.editingIdInstrutor = -1;
        blockButtons(false);
        lancar_texto("Aula editada com sucesso!")
    }

    //
    //Ao focar em algum item da tela
    //
    $scope.focou = function () {
        limpar_erros();
    }

    // 
    //Pegar os intrutores no servidor e listar
    //
    function listarInstrutores () {
        instrutorService.listar().then(function (resposta) {
            //recebe e manipula uma promessa(resposta)
            $scope.instrutores = resposta.data;
        })
        instrutorService.listarAulas().then(function (resposta) {
            $scope.aulas = resposta.data;
        })
    }

    //
    //Lança um texto no log da tela
    //
      function lancar_texto (texto) {
        limpar_erros();
        $scope.logOutput = texto;
  }

    // 
    //Limpar erros no log da tela 
    // 
    function limpar_erros () { 
        $scope.logOutput = ""; 
        let footer = document.getElementsByClassName("footer"); 
        footer[0].classList.remove("log"); 
        let elementosErro = document.getElementsByClassName("erro"); 
        for (let i = 0; i < elementosErro.length; i++) { 
            elementosErro[i].classList.remove ("erro"); 
        } 
    } 

    //
    //Lança um erro na tela
    //
    function lancar_erro  (erro) {
        $scope.logOutput = erro;
        let footer = document.getElementsByClassName("footer");
        footer[0].classList.add("log");
    }
 
    // 
    //Checar tipo do erro e chamar retorno necessário 
    // 
    function check_erro (erro, elemento) { 
        if (elemento[0].toString() === "[object HTMLInputElement]") { 
            elemento[0].classList.add ("erro"); 
        } 
 
        if (erro.required === true) { 
            lancar_erro("Preencha o campo!"); 
        } 
 
        else if (erro.minlength === true) { 
            lancar_erro("Informação muito curta!"); 
        } 
 
        else if (erro.maxlength === true) { 
            lancar_erro("Informação muito longa!"); 
        } 
 
        else if (erro.email === true) { 
            lancar_erro("Insira um e-mail válido!"); 
        } 

        else if (erro.max === true) {
            lancar_erro("Insira uma idade válida!");
        }
    } 
});

    //
    //Bloquear botões e impedir a interação
    //
    function blockButtons  (block) {
      editButtons = document.getElementsByClassName("editButton");
      deleteButtons = document.getElementsByClassName("deleteButton");
      
      if (block) {
        for (let i = 0; i < editButtons.length; i++) {
            editButtons[i].classList.add("nonClickable");
        }
        for (let i = 0; i < deleteButtons.length; i++) {
            deleteButtons[i].classList.add("nonClickable");
        }
      }
      else {
            for (let i = 0; i < editButtons.length; i++) {
            editButtons[i].classList.remove("nonClickable");
            }
            for (let i = 0; i < deleteButtons.length; i++) {
            deleteButtons[i].classList.remove("nonClickable");
            }
      }
  }