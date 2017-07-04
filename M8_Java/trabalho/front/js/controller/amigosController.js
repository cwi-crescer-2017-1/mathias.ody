app.controller('amigosController', function (
                                            $localStorage,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            $window,
                                            authService,
                                            usuarioService,
                                            toastr
                                            ){ 

     $scope.logout = function () {
        authService.logout();
        $localStorage.$reset();
    }
    $scope.usuarioLogado = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }
    
    
    $scope.getSolicitacoes = function () {
       usuarioService.getInvitations($routeParams.id)
        .then(function (response) { 
            $scope.solicitacoes = response.data;
        })
    }

    $scope.getAmizades = function () {
       usuarioService.getFriends($routeParams.id)
        .then(function (response) { 
            $scope.amizades = response.data;
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

    $scope.recusarSolicitacao = function (id) {
       usuarioService.refuseInvitation(id)
        .then(function (response) { 
            toastr.success("Solicitação recusada");            
            $scope.getSolicitacoes();
        })
        .then(function (response) { 
            toastr.error("Ocorreu um erro");
        })
    }

    $scope.getSolicitacoes();
    $scope.getAmizades();
})