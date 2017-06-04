app.controller('livroController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            livroService,
                                            authService){

    setParametros(0,5);
    listarLancamentos();
    listarOutros();

    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }

    function setParametros() {
        $scope.parametros = {
            jump: 0,
            bring: 12,
            full:false
        };
    }

     //pagina carregada
    angular.element(document).ready(function () {
       setTimeout(resize, 500);
    });

    function listarLancamentos() {
        livroService.lancamentos().then(function(response){
            $scope.lancamentos = response.data.dados;
        })
    }

    function listarOutros() {
        livroService.getLivros($scope.parametros).then(function(response){
            $scope.outrosLivros = response.data.dados;
        })
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

    function resizeEvent (event) {
        resize();
    }

    addEvent(window, "resize", resizeEvent);
})