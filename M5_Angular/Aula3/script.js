var app = angular.module("App", []);
app.controller ("Controller", function ($scope) {
    let disciplinas = [
    'OO',
    'HTML e CSS',
    'Javascript',
    'AngularJS',
    'Banco de Dados I'
  ];

    $scope.deuAula = false;
    $scope.disciplinas = disciplinas;

    $scope.instrutores = [];

    $scope.incluir = function (instrutor) {
        if ($scope.Form.$invalid) {
            return;
        }
        $scope.instrutores.push(instrutor);
        $scope.novoInstrutor = {};
    }
})