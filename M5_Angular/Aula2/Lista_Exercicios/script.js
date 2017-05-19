var app = angular.module("Exercicio",[]);
app.controller ("controle", function ($scope) {

    let instrutores = [{
    nome: 'Bernardo',
    aulas: [{
        numero: 1,
        nome: 'OO'
      },
      {
        numero: 4,
        nome: 'Javascript'
      }
    ]
    },
    {
    nome: 'Nunes',
    aulas: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
    },
    {
    nome: 'Pedro (PHP)',
    aulas: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
    },
    {
    nome: 'Zanatta',
    aulas: [{
      numero: 5,
      nome: 'AngularJS'
    }]
    }
    ];

    let mostrarAulas = function (){
        let aulas = [];
        instrutores.forEach(function (instrutor) {
            instrutor.aulas.forEach(function(aula) {
                aulas.push({nomeAula: aula.nome, numero: aula.numero, nomeInstrutor:instrutor.nome});
            })
        })
        aulas = aulas.sort(function (a, b) {
            return a.numero - b.numero;
        });
        return aulas;
    }

    //
    //Injeções
    //
    $scope.instrutores = instrutores;
    $scope.aulas = mostrarAulas();
})

//FILTROS FORA DO CONTROLLER

app.filter('mascada', function () {
    return function (input) {
        input = input.replace (/(NUNES)/ig, '$ $1 $')
        return input;
    }
})

let aulasCount = 0;
app.filter('lpadStandard', function () {
    return function(input){
        aulasCount ++;
        input = input.toUpperCase();
        let pad = "";
        if (aulasCount < 10 && aulasCount > 99) { pad = "0"; }
        else if (aulasCount < 100) { pad = "00"; }
        return pad + aulasCount + " - " + input;;
    }
})
