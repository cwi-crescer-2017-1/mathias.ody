var app = angular.module("Exercicio1A2",[]);
app.controller ("convertDate", function ($scope) {
    $scope.output = "Insert date above!";
    $scope.convert = function () {
        $scope.output = new Date ($scope.input);
    }

    $scope.instrutores = [{
    nome: 'Bernardo',
    aula: [{
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
    aula: [{
      numero: 2,
      nome: 'Banco de Dados I'
    }]
  },
  {
    nome: 'Pedro (PHP)',
    aula: [{
      numero: 3,
      nome: 'HTML e CSS'
    }]
  },
  {
    nome: 'Zanatta',
    aula: [{
      numero: 5,
      nome: 'AngularJS'
    }]
  }
];
})

//FILTROS FORA DO CONTROLER

app.filter('mascada', function () {
    return function (input) {
        /*if (input.toUpperCase() === "NUNES") {
            return "$" + input + "$";
        }
        return input;*/
        //Esta solução é deselegante.

        input = input.replace (/NUNES/ig, "$Nunes$") 
        return input;
    }
})