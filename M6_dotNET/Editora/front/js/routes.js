var app = angular.module ('app', ['ngRoute']);

app.config (function ($routeProvider) {

    $routeProvider
        .when('/', {
            controller : 'livroController',
            templateUrl: '/html/home.html'
        })

        .otherwise({redirectTo: '/'});
});