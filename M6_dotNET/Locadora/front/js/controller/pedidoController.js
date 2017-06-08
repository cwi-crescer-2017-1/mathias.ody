app.controller('pedidoController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            $localStorage,
                                            produtoService,
                                            clienteService,
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
    $scope.mostrarCadastro = false;

    $scope.avancarCliente = function (cliente) {
        $scope.estagio = 2; //estagio do pedido = 2 => escolher produto
        clienteService.criar(cliente, $localStorage.headerAuth);
        listarProdutos();
    }

    $scope.buscarCliente = function (cliente){
        clienteService.getByCpf(cliente.Cpf,$localStorage.headerAuth).then(function(response){
            if (response.data.dados == null)
                toastr.info("Usuário não cadastrado");
            else {
                $scope.cliente = response.data.dados;
                console.log($scope.cliente.Nome);
            }
            $scope.mostrarCadastro = true;
        })
    }

    //
    // Produtos
    //
     function listarProdutos() {
        produtoService.getProdutos().then(function(response){
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
