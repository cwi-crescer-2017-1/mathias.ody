app.controller('socialController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            socialService,
                                            authService,
                                            $localStorage,
                                            toastr){
                                          
                                   
    //setParametros(0,5);
    
    $scope.pagina = 0;
    $scope.temProximo = true;

    $scope.avancar = function () {
        $scope.pagina ++;
        $scope.listarPosts();
        $scope.checarProximo();
    }

    $scope.voltar = function  () {
        $scope.pagina --;
        $scope.listarPosts();
    }

    $scope.checarProximo = function () {
         socialService.getPosts($scope.pagina + 1)
        .then(function (response) { 
            if (response.data.length == 0) { $scope.temProximo = false; }
            else { $scope.temProximo = true; };
        })
    };

    ///////////
    $scope.logout = function () {
        authService.logout();
        $localStorage.$reset();
    }
    $scope.usuarioLogado = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }

    $scope.curtir = function (id) {
        socialService.curtir(id)
        .then(function (response) { 
            $scope.listarPosts();
            $scope.checarProximo();
        },
        function (response) { 
            toastr.error("Ocorreu um erro!");
        })
    }

    $scope.listarPosts = function () {
         socialService.getPosts($scope.pagina)
        .then(function (response) { 
            $scope.posts = response.data;
        })
    };

    $scope.listarPosts();
    $scope.checarProximo();

    $scope.hasLiked = function (curtidas) {
        return curtidas.filter (x => x.usuarioCurtida.id == $scope.usuarioLogado.id).length > 0;
    }

    /*function setParametros() {
        $scope.parametros = {
            jump: 0,
            bring: 12,
            full:false
        };
    }*/

    $scope.postar = function () {
        socialService.postar($scope.post)
        .then (function (response) { 
            $scope.listarPosts();
            $scope.checarProximo();
            $scope.post.texto = "";
            console.log($scope.post);
        },
        function (response) { 
            toastr.error("Ocorreu um erro");
            $scope.listarPosts();
            $scope.checarProximo();
        })
    }

     //pagina carregada
    /*angular.element(document).ready(function () {
       assegurarResize()
    });*/

    /*function assegurarResize() {
        setTimeout(resize, 500);
        setTimeout(resize, 1000);
        setTimeout(resize, 2000);
    }*/

    /*function listarOutros() {
        socialService.getLivros($scope.parametros).then(function(response){
            $scope.outrosLivros = response.data.dados;
        })
    }
*/
    function resize () {
        let list = document.getElementsByClassName("socials");
        let width = 0;
        for (let i = 0; i < list.length; i++) {
            if (i == 0) {
                width = list[i].clientWidth;
            }
            list[i].style.height = '' + width *2 + 'px';
        }
    }

    /*function resizeEvent (event) {
        resize();
    }*/

    //addEvent(window, "resize", resizeEvent);
})
