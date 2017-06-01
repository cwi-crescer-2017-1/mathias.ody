var app = angular.module ('app', ['ngRoute']);

app.config (function ($routeProvider) {

    $routeProvider
        .when('/', {
            controller : 'livroController',
            templateUrl: '/html/home.html'
        })

        .otherwise({redirectTo: '/'});
});

app.controller('livroController', function ($scope,
                                            $routeParams,
                                            livroService){

    listarLancamentos();

    function listarLancamentos() {
        livroService.lancamentos().then(function(response){
            $scope.lancamentos = response.data.dados;
            console.log(response.data.dados);
        })
    }
})