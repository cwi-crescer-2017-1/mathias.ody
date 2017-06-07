var app = angular.module ('app', ['ngRoute', 'auth', 'toastr']);

app.config (function ($routeProvider) {

    $routeProvider
        .when('/', {
            controller : 'produtoController',
            templateUrl: '/html/home.html',
            resolve: {
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/login', {
            controller : 'loginController',
            templateUrl: '/html/login.html'
        })  

        .otherwise({redirectTo: '/'});
});

app.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:50675/api/acessos/usuario',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/home',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/'
});