app.controller('atrasosController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            $localStorage,
                                            produtoService,
                                            clienteService,
                                            pedidoService,
                                            authService,
                                            toastr,
                                            $filter){ 
    
    $scope.logout = authService.logout;
    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }
    
    listarAtrasos();

    function listarAtrasos () {
        pedidoService.listarAtrasos($localStorage.headerAuth).then(function(response) {
            $scope.pedidos = response.data.dados;
        })
    };


})