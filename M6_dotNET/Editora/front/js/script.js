var app = angular.module ('app', ['ngRoute']);

app.config (function ($routeProvider) {

    $routeProvider
        .when('/', {
            controller : 'livroController',
            templateUrl: '/html/home.html'
        })

        .otherwise({redirectTo: '/'});
});

app.controller('livroController', function ($window,
                                            $scope,
                                            $routeParams,
                                            livroService){

    listarLancamentos();
    setTimeout(resize, 500)

    function listarLancamentos() {
        livroService.lancamentos().then(function(response){
            $scope.lancamentos = response.data.dados;
            console.log(response.data.dados);
        })
    }
    addEvent(window, "resize", resizeEvent);
})

function resizeEvent (event) {
    resize();
}

function resize () {
    let list = document.getElementsByClassName("livros");
    let width = 0;
    for (let i = 0; i < list.length; i++) {
        if (i == 0) {
            width = list[i].clientWidth;
        }
        list[i].style.height = '' + width *2 + 'px';
    }
}

var addEvent = function(object, type, callback) {
    if (object == null || typeof(object) == 'undefined') return;
    if (object.addEventListener) {
        object.addEventListener(type, callback, false);
    } else if (object.attachEvent) {
        object.attachEvent("on" + type, callback);
    } else {
        object["on"+type] = callback;
    }
};