app.controller('pedidoController', function ($window,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            $localStorage,
                                            produtoService,
                                            clienteService,
                                            authService,
                                            toastr,
                                            $filter){
    // Estagio do pedido                                      
    $scope.estagio = 1;


    //
    // Usuarios
    //
    $scope.logout = authService.logout;
    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }

    //
    // Clientes
    //
    $scope.search = { Cpf : ""}
    $scope.mostrarCadastro = false;
    var jaExistente = false;

    $scope.avancarCliente = function (cliente) {
        $scope.estagio = 2; //estagio do pedido = 2 => escolher produto
        prepararClienteParaEnvio();
        if (jaExistente) {
            if (foiAlterado()) {
                console.log(cliente);
                clienteService.alterar(cliente, $localStorage.headerAuth);}
        }
        else {
            clienteService.criar(cliente, $localStorage.headerAuth);
        }
        listarProdutos();
    }

    $scope.buscarCliente = function (cliente){
        clienteService.getByCpf($scope.search.Cpf,$localStorage.headerAuth).then(function(response){
            if (response.data.dados == null){
                toastr.info("Usuário não cadastrado");
                $scope.cliente = { CPF : $scope.search.Cpf};
            }
            else {
                jaExistente = true;
                $scope.clienteInicial = angular.copy(response.data.dados);
                $scope.cliente = response.data.dados;
                $scope.cliente.DataNascimento = $filter('date')($scope.cliente.DataNascimento, "dd/MM/yyyy");
                $scope.cliente.Genero = $scope.cliente.Genero.toString();
            }
            $scope.mostrarCadastro = true;
        })
    }

    function foiAlterado () {
        if ($scope.clienteInicial == null) { return false; }
        if (angular.equals($scope.clienteInicial, $scope.cliente)) {
             return false;
        }
        return true;
    }

    function prepararClienteParaEnvio() {
        $scope.cliente.DataNascimento = new Date (naoSeiUsarRegex($scope.cliente.DataNascimento.toString()));
        console.log($scope.cliente);
        $scope.cliente.Genero = parseInt($scope.cliente.Genero);
    }

    function naoSeiUsarRegex (token) {
        let result = "";
        let dia = "";
        let mes = "";
        let ano = "";

        for (let i = 0; i < 2; i++) {
            dia += token.charAt(i);
        }
        for (let j = 3; j < 5; j++) {
            mes += token.charAt(j);
        }
        for (let k = 6; k < 10; k++) {
            ano += token.charAt(k);
        }
        result = ano + "-" + mes + "-" + dia;
        console.log(result);
        return result;      
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
