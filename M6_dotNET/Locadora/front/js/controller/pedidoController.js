app.controller('pedidoController', function ($window,
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

    $scope.isAdm = authService.possuiPermissao("Administrador");                                            
    // Estagio do pedido                                      
    $scope.estagio = 1;
    $scope.numeroDiarias;
    $scope.info = {quantidadeDiarias : 1};

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
                $scope.cliente = { Cpf : $scope.search.Cpf};
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
        return result;      
    }

    //
    // Produtos
    //
     function listarProdutos() {
        produtoService.getProdutos().then(function(response){
            $scope.produtos = response.data.dados;
            $scope.produtos.forEach(function (listaTipo){
                listaTipo.forEach(function (produto){
                    if (produto.TipoProduto == 2) {
                        produto.QuantidadeSelecionada = 0;
                    }
                    else {
                        produto.QuantidadeSelecionada = 1;
                    }
                })
            })
        })
    }

    // Avançar e calcular
    $scope.avancarProdutos = function () {
        setProdutosEscolhidos(); 
        setOrcamento();       
        numeroDiarias = getNumeroDiarias();

        $scope.estagio = 3; //estagio do pedido = 3 => confirmar produto
    }

    $scope.setProduto = function (produtoId, produtos, produto) {
        apagarOutrosChecksProduto(produtoId, produtos, produto);
    }

    $scope.setPacote = function (pacoteId, pacotes, pacote) {
        apagarOutrosChecksPacote(pacoteId, pacotes, pacote);
    }

    $scope.setOpcional = function (id, quantidade) {
        
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
    
    function setProdutosEscolhidos(){
        $scope.escolhidos = [];
        $scope.produtos.forEach(function (listaTipo){
           listaTipo.forEach(function (produto){ 
               if (produto.checked)
                    $scope.escolhidos.push (produto);
                else if (produto.TipoProduto == 2) {
                    if (produto.QuantidadeSelecionada > 0){
                        $scope.escolhidos.push (produto);
                    }
                }
            })
        })
    }

    function getNumeroDiarias() {
        return $scope.info.quantidadeDiarias;
    }

    function setOrcamento() {
        let diaria = 0;
        let total = 0;
        $scope.escolhidos.forEach (function (produto) {
            if (produto.checked)
                diaria += produto.Preco * produto.QuantidadeSelecionada;
            else if (produto.TipoProduto == 2) {
                if (produto.QuantidadeSelecionada > 0){
                    diaria += produto.Preco * produto.QuantidadeSelecionada;
                }
            }
        })
        total = diaria * $scope.info.quantidadeDiarias;
        $scope.orcamento = {totalDiaria : diaria, totalOrcamento : total};
    }
    //
    // Confirmação de pedido
    //

    $scope.confirmarPedido = function() {
        let itensProduto = [];
        $scope.escolhidos.forEach (function (produto){
            item = {idProduto : produto.Id, Quantidade : produto.QuantidadeSelecionada};
            itensProduto.push (item);
        })
        pedido = {idCliente : $scope.cliente.Id,
                  DiariasAlugadas : $scope.info.quantidadeDiarias,
                  Itens : itensProduto   
            }
        pedidoService.pedir(pedido, $localStorage.headerAuth)
        toastr.success("Pedido realizado com sucesso!");
        $location.path('/home');
        console.log(pedido);
    }
})
