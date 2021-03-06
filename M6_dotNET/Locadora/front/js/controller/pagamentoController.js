app.controller('pagamentoController', function ($window,
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
    
    listar();

    function listar () {
        pedidoService.devolucao($localStorage.headerAuth).then(function(response) {
            $scope.pedidos = response.data.dados;
        })
    };

    $scope.devolver = function(id) {
        pedidoService.devolver(id,$localStorage.headerAuth).then(function(response) {
            toastr.success("Deletado com sucesso!");
            listar();
        })
    }
})