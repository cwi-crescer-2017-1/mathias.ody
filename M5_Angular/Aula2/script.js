var app = angular.module("Exercicio1A2",[]);
app.controller ("convertDate", function ($scope) {
    $scope.output = "Insert date above!";
    $scope.convert = function () {
        $scope.output = new Date ($scope.input);
    }
})