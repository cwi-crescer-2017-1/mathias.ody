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
    
    listarAtrasos();

    function listarAtrasos () {
        pedidoService.listarAtrasos($localStorage.headerAuth).then(function(response) {
            $scope.pedidos = response.data.dados;
        })
    };


})