app.controller('livroController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            livroService,
                                            authService){


    $scope.isAdm = false;
    $scope.podeRevisar = false;
    $scope.podePublicar = false;                                            

    verificarPermissoes();                                     
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

    function verificarPermissoes () {  
        usuario.Permissoes.forEach(function(permissao) {
            if(permissao == "Revisor"){
                podeRevisar = true;
            }
            if(permissao == "Publicador"){
                podePublicar = true;
            }
            if(permissao == "Administrador"){
                isAdm = true;
            }
        })
    }

    $scope.revisar = function(livro) {
        livroService.revisar(livro).then(function(response){
            //$scope.outrosLivros = response.data.dados;
        })
    }

    $scope.avancar = function () {
        $scope.parametros.jump += $scope.parametros.bring;  
        listarOutros();
        assegurarResize();
    }

    $scope.voltar = function  () {
        $scope.parametros.jump -= $scope.parametros.bring; 
        if($scope.parametros.jump < 0){
            $scope.parametros.jump = 0;
        }
        listarOutros();
        assegurarResize();
    }

     //pagina carregada
    angular.element(document).ready(function () {
       assegurarResize()
    });

    function assegurarResize() {
        setTimeout(resize, 500);
        setTimeout(resize, 1000);
        setTimeout(resize, 2000);
    }

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
