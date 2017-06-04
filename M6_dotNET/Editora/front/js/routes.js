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
            controller : 'assinarController',
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
        .when('/registrar', {
            controller : 'registrarController',
            templateUrl: '/html/registrar.html'
        })
        .when('/editar/:id', {
            controller : 'editarController',
            templateUrl: '/html/editar.html'
        })
        .when('/adicionar', {
            controller : 'adicionarController',
            templateUrl: '/html/adicionar.html'
        })

        .otherwise({redirectTo: '/'});
});