app.controller('detalhesController', function ( $scope,
                                                $routeParams,
                                                usuarioService,
                                                socialService,
                                                authService,
                                                $location,
                                                toastr){
    
     $scope.logout = function () {
        authService.logout();
        $localStorage.$reset();
    }
    $scope.usuarioLogado = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }
    
    $scope.info = { genero : ""};
    detalhesLivro ();

    function detalhesLivro () {
        if ($routeParams.id == $scope.usuario.id){
            $location.path("/");
        } 

       usuarioService.findUsuario($routeParams.id)
        .then(function (response) {
            $scope.detalhes = response.data;
            $scope.listarPosts();

            if($scope.detalhes.sexo == "n") {
                 $scope.info.genero = "Não informado";
            }
            else if($scope.detalhes.sexo == "m") {
                 $scope.info.genero = "Masculino";
            }
            else if($scope.detalhes.sexo == "f") {
                 $scope.info.genero = "Feminino";
            }
            $scope.getStatus($scope.detalhes);
        },
        function (response) {
            toastr.error("Ocorreu um erro");
        })
    }

    $scope.getStatus = function (usuario) {
       usuarioService.statusSolicitacao(usuario.id)
        .then(function (response) { 
            usuario.status = response.data;
            $scope.getStatus($scope.detalhes);
        })
    }

    $scope.curtir = function (id) {
        socialService.curtir(id)
        .then(function (response) { 
            $scope.listarPosts();
        },
        function (response) { 
            toastr.error("Ocorreu um erro!");
        })
    }

    $scope.listarPosts = function () {
         socialService.getPostsUser($scope.detalhes.id)
        .then(function (response) { 
            $scope.posts = response.data;
        })
    };

    $scope.hasLiked = function (curtidas) {
        return curtidas.filter (x => x.usuarioCurtida.id == $scope.usuarioLogado.id).length > 0;
    }

    $scope.enviarSolicitacao = function (id) {
       usuarioService.sendInvitation(id)
        .then(function (response) { 
            toastr.success("Solicitação enviada com sucesso!");
            $scope.buscar ();
            $scope.getStatus($scope.detalhes);
        },
        function (response) {
            toastr.error("Ocorreu um erro");
        })
    }

    $scope.aceitarSolicitacao = function (id) {
       usuarioService.acceptInvitation(id)
        .then(function (response) { 
            toastr.success("Solicitação aceita");            
            $scope.getSolicitacoes();
            $scope.getAmizades();
        })
        .then(function (response) { 
            toastr.error("Ocorreu um erro");
        })
    }
})