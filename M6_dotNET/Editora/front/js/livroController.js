app.controller('livroController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            livroService){

    setParametros(0,5);
    listarLancamentos();
    listarOutros();
    setTimeout(resize, 500)

    function setParametros() {
        $scope.parametros = {
            jump: 0,
            bring: 12
        };
    }

    function listarLancamentos() {
        livroService.lancamentos().then(function(response){
            $scope.lancamentos = response.data.dados;
        })
    }

    function listarOutros() {
        livroService.outros($scope.parametros).then(function(response){
            $scope.outrosLivros = response.data.dados;
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