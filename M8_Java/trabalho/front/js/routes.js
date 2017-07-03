var app = angular.module ('app', ['ngRoute', 'auth', 'toastr']);

app.config (function ($routeProvider) {

    $routeProvider
        .when('/', {
            controller : 'socialController',
            templateUrl: '/html/home.html',
            resolve: {
                    // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/login', {
            controller : 'loginController',
            templateUrl: '/html/login.html'
        })
        .when('/crud', {
            controller : 'crudController',
            templateUrl: '/html/crud.html',
            resolve: {
                    // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })

        .when('/amigos', {
            controller : 'amigosController',
            templateUrl: '/html/amigos.html',
            resolve: {
                    // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/editar', {
            controller : 'editarController',
            templateUrl: '/html/editar.html',
            resolve: {
                    // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/buscar', {
            controller : 'buscarController',
            templateUrl: '/html/buscar.html',
            resolve: {
                    // define que para acessar esta página deve ser um usuário autenticado (mas não restringe o tipo de permissão)
                autenticado: function (authService) {
                    return authService.isAutenticadoPromise();
                }
            }
        })
        .when('/usuario/:id', {
            controller : 'detalhesController',
            templateUrl: '/html/detalhes.html'
        })
        .when('/registrar', {
            controller : 'registrarController',
            templateUrl: '/html/registrar.html'
        })

        .otherwise({redirectTo: '/'});
});

app.constant('authConfig', {

    // Obrigatória - URL da API que retorna o usuário
    urlUsuario: 'http://localhost:9090/api/usuarioLogado',

    // Obrigatória - URL da aplicação que possui o formulário de login
    urlLogin: '/login',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGIN com sucesso
    urlPrivado: '/',

    // Opcional - URL da aplicação para onde será redirecionado (se for informado) após o LOGOUT
    urlLogout: '/login'
});