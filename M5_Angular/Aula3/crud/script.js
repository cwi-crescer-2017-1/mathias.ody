var app = angular.module("App", []);
app.controller ("Controller", function ($scope) {
    
    $scope.editingId = 0;
    $scope.aulaEdit = { string : "" };
    $scope.lastIdAula = 1;
    $scope.lastIdInstrutor = 1;
    $scope.inputEditAulas = {};
    $scope.inputEditAulas.aulas = [];
    $scope.inputInstrutor = {                    
        nome: '',                  
        sobrenome: '',          
        idade: '',                       
        email: '',
        dandoAula: false,                                       
        urlFoto: ''  
    }
    $scope.instrutorEdit = { }

    $scope.incluirAula = function(input) {
        if (Object.keys($scope.Form.cadastrarAula.$error).length > 0) {
            check_erro($scope.Form.cadastrarAula.$error, document.getElementsByName("cadastrarAula"))
        }
        else {
            $scope.aulas.push({nome : input, id: $scope.lastIdAula++});
            $scope.aulaInput = "";
            lancar_texto("Aula incluída!")
        }
    }

     $scope.editarAula = function(nome) {
        if (Object.keys($scope.Form.cadastrarAula.$error).length > 0) {
            check_erro($scope.Form.cadastrarAula.$error, document.getElementsByName("cadastrarAula"))
        }
        else {
            let id = $scope.aulas.getIdDeNome (nome);
            let posInArray = $scope.aulas.getPosArrayDeNome (nome);
            $scope.editingId = id;
            $scope.aulaEdit.string =  $scope.aulas[posInArray].nome;
            blockButtons(true);
            lancar_texto("Digite e clique em apply");
        }
    }

    $scope.applyAula = function (nome){
        if ($scope.aulas.contemNome($scope.aulaEdit.string,$scope.editingId)) {
            lancar_erro("Já existe uma aula com esse nome");
            return;
        }
        let id = $scope.aulas.getIdDeNome (nome);
        let posInArray = $scope.aulas.getPosArrayDeNome (nome);
        $scope.aulas[posInArray].nome = $scope.aulaEdit.string;
        $scope.editingId = 0;
        blockButtons(false);
        lancar_texto("Aula editada com sucesso!")
    }

    $scope.focou = function () {
        limpar_erros();
    }

    $scope.focouSelected = function () {
        limpar_erros();
        lancar_texto("Selecione múltiplos segurando \"Ctrl\"");
    }

    $scope.deletarAula = function (nome) {
        let posInArray = $scope.aulas.getPosArrayDeNome (nome);
        if (!$scope.aulas.estaSendoUsada($scope.aulas[posInArray].id, $scope.instrutores)) {
            $scope.aulas.splice(posInArray,1);
            lancar_texto("Aula excluída com sucesso!")
        }
        else {
            lancar_erro ("Não é possível excluir esta aula. Ela está sendo utilizada.");
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////

    $scope.incluirInstrutor = function(inputInstrutor) {
        if ($scope.checkNenhumErro()){
            if ($scope.inputInstrutor.urlFoto === "") {
                $scope.inputInstrutor.urlFoto = "http://www.freeiconspng.com/uploads/illuminati-icon-png-1.png";
            }
            let instrutorParaAdicionar = $scope.inputInstrutor.clone();;
            instrutorParaAdicionar.id = $scope.lastIdInstrutor++;
            instrutorParaAdicionar.aulas = [];
            $scope.inputInstrutorAulas.forEach(function (elemento){
                instrutorParaAdicionar.aulas.push({id : elemento})
            })

            $scope.instrutores.push(instrutorParaAdicionar);
            lancar_texto("Instrutor incluído!");
            
            for (let elemento in $scope.inputInstrutor) {
                if (typeof $scope.inputInstrutor[elemento] === "string" || typeof $scope.inputInstrutor[elemento] === "number") {
                    $scope.inputInstrutor[elemento] = "";
                }
            }
        }
    }

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

        if ($scope.instrutores.contemNome($scope.inputInstrutor.nome,$scope.editingIdInstrutor)) {
            lancar_erro("Já existe um instrutor com esse nome");
            nenhumErro = false;
        }

        if ($scope.instrutores.contemEmail($scope.inputInstrutor.email,$scope.editingIdInstrutor)) {
            lancar_erro("Esse email já está cadastrado");
            nenhumErro = false;
        }

        return nenhumErro;
    }

    $scope.checkNenhumErroEdit = function () {
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

        if ($scope.instrutores.contemNome($scope.instrutorEdit.nome,$scope.editingIdInstrutor)) {
            lancar_erro("Já existe um instrutor com esse nome");
            nenhumErro = false;
        }

        if ($scope.instrutores.contemEmail($scope.instrutorEdit.email,$scope.editingIdInstrutor)) {
            lancar_erro("Esse email já está cadastrado");
            nenhumErro = false;
        }

        return nenhumErro;
    }

     $scope.editarInstrutor = function(nome) {
        let id = $scope.instrutores.getIdDeNome (nome);
        let posInArray = $scope.instrutores.getPosArrayDeNome (nome);
        $scope.editingIdInstrutor = id;
        $scope.instrutorEdit = $scope.instrutores[posInArray].clone(); 
        $scope.instrutorEdit.aulas.forEach(function (elemento) {
            $scope.inputEditAulas.aulas.push (elemento.id);
        })
        blockButtons(true);
        lancar_texto("Digite e clique em apply");
    }

    $limparVariaveis = function () {
        $scope.inputEditAulas = {};
        $scope.inputEditAulas.aulas = [];
        $scope.instrutorEdit = {};
    }

     $scope.applyInstrutor = function (nome){
        if ($scope.checkNenhumErroEdit()){
            if ($scope.instrutorEdit.urlFoto === "") {
                $scope.instrutorEdit.urlFoto = "http://www.freeiconspng.com/uploads/illuminati-icon-png-1.png";
            }

            let id = $scope.instrutores.getIdDeNome (nome);
            let posInArray = $scope.instrutores.getPosArrayDeNome (nome);
            $scope.instrutores[posInArray] = $scope.instrutorEdit.clone();

            $scope.instrutores[posInArray].aulas = [];
            $scope.inputEditAulas.aulas.forEach(function (elemento){
                $scope.instrutores[posInArray].aulas.push({id : elemento})
            })

            $scope.editingIdInstrutor = 0;
            blockButtons(false);
            lancar_texto("Instrutor editado com sucesso!");
            $limparVariaveis();
        }
    }

    $scope.deletarInstrutor = function (nome) {
        let posInArray = $scope.instrutores.getPosArrayDeNome (nome);
        if (!$scope.instrutores[posInArray].dandoAula) {
            $scope.instrutores.splice(posInArray,1);
            lancar_texto("Instrutor demitido com muito sucesso! ;)")
        }
        else {
            lancar_erro ("Não é possível demitir esse instrutor. Ele está dando aula.");
        }
    }
    
    $scope.aulas = [
    {nome :'Orientação a Objetos' , id : $scope.lastIdAula++},
    {nome :'HTML e CSS' , id : $scope.lastIdAula++},
    {nome :'Javascript' , id : $scope.lastIdAula++},
    {nome :'AngularJS' , id : $scope.lastIdAula++},
    {nome :'Banco de Dados I' , id : $scope.lastIdAula++}
  ];

  $scope.instrutores = [{
    id: $scope.lastIdInstrutor++,                              // Gerado
    nome: 'Bernardo',                   // Obrigatório (length = min 3, max 20)
    sobrenome: 'B. Rezende',            // Opcional (length = max 30)
    idade: 25,                          // Obrigatório (max 90)
    email: 'bernardorezende@cwi.com.br',// Obrigatório (type=email)
    dandoAula: true,                    // true ou false
    aulas: [{id:1}, {id:4}],                       // Opcional (array)
    urlFoto: 'http://www.freeiconspng.com/uploads/illuminati-icon-png-1.png'    // Opcional (porém tem uma default de livre escolha)
  },
  {
    id: $scope.lastIdInstrutor++,                              // Gerado
    nome: 'Pedro Henrique',                   // Obrigatório (length = min 3, max 20)
    sobrenome: 'Pires',            // Opcional (length = max 30)
    idade: 25,                          // Obrigatório (max 90)
    email: 'php@cwi.com.br',// Obrigatório (type=email)
    dandoAula: true,                    // true ou false
    aulas: [{id:1}, {id:4}],                       // Opcional (array)
    urlFoto: 'http://www.freeiconspng.com/uploads/illuminati-icon-png-1.png'    // Opcional (porém tem uma default de livre escolha)
  }
];

  var blockButtons = function (block) {
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

  var lancar_texto = function (texto) {
      limpar_erros();
      $scope.errorOutput = texto;
  }

  //
  //Devido a problemas utilizando o ng-message, resolvi fazer meu próprio sistema de erros
  //

  var lancar_erro = function (erro){
    $scope.errorOutput = erro;
    let footer = document.getElementsByClassName("footer");
    footer[0].classList.add("log");
  }

  var limpar_erros = function (){
    $scope.errorOutput = "";
    let footer = document.getElementsByClassName("footer");
    footer[0].classList.remove("log");
    let elementosErro = document.getElementsByClassName("erro");
    for (let i = 0; i < elementosErro.length; i++) {
        elementosErro[i].classList.remove ("erro");
    }
  }

  //checar tipo do erro e chamar retorno necessário
  var check_erro = function (erro, elemento) {
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
})

Array.prototype.contemNome = function (nome, id = true) {
    resultado = false;
    this.forEach(function (elemento) {
        if (elemento.nome === nome && elemento.id !== id) {
            resultado = true;
        }
    })
    return resultado;
}

Array.prototype.contemEmail = function (email, id = true) {
    resultado = false;
    this.forEach(function (elemento) {
        if (elemento.email === email && elemento.id !== id) {
            resultado = true;
        }
    })
    return resultado;
}

Array.prototype.getIdDeNome = function (nome) {
    let resultado = -1;
    this.forEach(function(elemento) {
        if (elemento.nome === nome) {
            resultado = elemento.id;
        }
    });

    return resultado;
}

Array.prototype.getPosArrayDeNome = function (nome) {
    let resultado = -1;
    this.forEach(function(elemento, index) {
        if (elemento.nome === nome) {
            resultado = index;
        }
    });

    return resultado;
}

Array.prototype.estaSendoUsada = function (id, instrutores) {
    let resultado = false;
    instrutores.forEach (function (instrutor){
        instrutor.aulas.forEach (function (aula) {
            if (aula.id == id){
                resultado = true;
            }
        })
    })
    return resultado;
}

app.filter('contem', function() {
      return function (lista, filtro) {
         let resultado = [];
         lista.forEach(function (aula){
              filtro.forEach(function (aulaInstrutor){
                if(aulaInstrutor.id === aula.id) {
                    resultado.push(aula);
                }
              })
         })
         return resultado;
      }
  })

  Object.prototype.clone = function () {
      retorno = {};
      for (var elemento in this) {
          retorno[elemento] = this[elemento];
      }
      return retorno;
  }