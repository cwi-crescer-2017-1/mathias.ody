app.controller('produtoController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            produtoService,
                                            authService){
                                          
                                   
    listarProdutos();

    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }

    function listarProdutos() {
        produtoService.getProdutos().then(function(response){
            $scope.produtos = response.data.dados;
            console.log($scope.listaTipoProdutos);
        })
    }

    $scope.avancar = function () {
        let produtosEscolhidos = (getProdutosEscolhidos());
        console.log(produtosEscolhidos);
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
