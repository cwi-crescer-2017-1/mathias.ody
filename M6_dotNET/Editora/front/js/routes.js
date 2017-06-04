var app = angular.module ('app', ['ngRoute']);

app.config (function ($routeProvider) {

    $routeProvider
        .when('/', {
            controller : 'livroController',
            templateUrl: '/html/home.html'
        })
        .when('/login', {
            controller : 'loginController',
            templateUrl: '/html/login.html'
        })
        .when('/assinar', {
            templateUrl: '/html/assinar.html'
        })
        .when('/livros/:id', {
            controller : 'detalhesController',
            templateUrl: '/html/detalhes.html'
        })
        .when('/crud', {
            controller : 'crudController',
            templateUrl: '/html/crud.html'
        })

        .otherwise({redirectTo: '/'});
});