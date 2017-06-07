app.controller('pedidoController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            pedidoService,
                                            authService,
                                            toastr){
                                          
    $scope.estagio = 1;


    //
    // Usuarios
    //
    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }

    //
    // Clientes
    //
    //$scope.cliente;
    $scope.mostrarCadastro = false;
    $scope.avancarCliente = function () {
        $scope.estagio = 2; //estagio do pedido = 2 => escolher produto
        console.log($scope.cliente);
    }

    $scope.buscarCliente = function (){
        console.log($scope.search);
        $scope.mostrarCadastro = true;
        
        toastr.info("Usuário não cadastrado")
    }

    //
    // Produtos
    //
     function listarProdutos() {
        pedidoService.getProdutos().then(function(response){
            $scope.produtos = response.data.dados;
            console.log($scope.listaTipoProdutos);
        })
    }

    $scope.avancarProdutos = function () {
        let produtosEscolhidos = (getProdutosEscolhidos());
        console.log(produtosEscolhidos);

        listarProdutos();
        $scope.estagio = 3; //estagio do pedido = 3 => confirmar produto
    }

    $scope.setProduto = function (produtoId, produtos, produto) {
        apagarOutrosChecksProduto(produtoId, produtos, produto);
    }

    $scope.setPacote = function (pacoteId, pacotes, pacote) {
        apagarOutrosChecksPacote(pacoteId, pacotes, pacote);
    }

    function apagarOutrosChecksProduto (produtoId, produtos, produto) {
        angular.forEach(produtos, function(produto, index) {
            if (produtoId != index) 
            produto.checked = false;
        });
    }

    function apagarOutrosChecksPacote (pacoteId, pacotes, pacote) {
        angular.forEach(pacotes, function(pacote, index) {
            if (pacoteId != index) 
            pacote.checked = false;
        });
    }
    
    function getProdutosEscolhidos(){
        let escolhidos = [];
        $scope.produtos.forEach(function (listaTipo){
           listaTipo.forEach(function (produto){ 
               if (produto.checked)
                    escolhidos.push (produto);
            })
        })
        return escolhidos;
    }
})
