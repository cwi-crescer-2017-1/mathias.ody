app.controller('relatorioController', function ($window,
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
    
    listar();

    function listar () {
        //pedidoService.devolucao($localStorage.headerAuth).then(function(response) {
         //   $scope.pedidos = response.data.dados;
       // })
    };


})