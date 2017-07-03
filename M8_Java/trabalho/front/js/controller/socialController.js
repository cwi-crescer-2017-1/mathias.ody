app.controller('socialController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            socialService,
                                            authService,
                                            $localStorage,
                                            toastr){
                                          
                                   
    //setParametros(0,5);
    
    $scope.logout = function () {
        authService.logout();
        $localStorage.$reset();
    }
    $scope.usuarioLogado = authService.getUsuario();

    if ($scope.usuario != null) {
        $scope.logado = true;
    }

    $scope.curtir = function (id) {
        console.log("curtiu")
        socialService.curtir(id)
        .then(function (response) { 
            $scope.listarPosts();
        },
        function (response) { 
            toastr.error("Ocorreu um erro!");
        })
    }

    $scope.listarPosts = function () {
         socialService.getPosts()
        .then(function (response) { 
            $scope.posts = response.data;
            console.log(response.data[0])
        })

    };

    $scope.listarPosts();

    /*function setParametros() {
        $scope.parametros = {
            jump: 0,
            bring: 12,
            full:false
        };
    }*/

    $scope.postar = function () {
        socialService.curtir($scope.post.id)
        .then (function (response) { 
            $scope.listarPosts();
        },
        function (response) { 
            toastr.error("Ocorreu um erro");
            $scope.listarPosts();
        })
    }

    $scope.avancar = function () {
        $scope.parametros.jump += $scope.parametros.bring;  
        listarOutros();
        //assegurarResize();
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
