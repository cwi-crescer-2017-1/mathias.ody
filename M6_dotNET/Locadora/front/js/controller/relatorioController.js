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
    
    
    $scope.buscar = function () {
        let dataFormatada = { data : new Date ($scope.dataBusca.valor)};
        pedidoService.buscar(dataFormatada,$localStorage.headerAuth).then(function(response) {
           $scope.pedidos = response.data.dados;
        })
    };


})