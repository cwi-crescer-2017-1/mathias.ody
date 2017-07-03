app.controller('detalhesController', function ( $scope,
                                                $routeParams,
                                                usuarioService,
                                                authService,
                                                $location,
                                                toastr){
    
    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }
    
    $scope.info = { genero : ""};
    detalhesLivro ();

    function detalhesLivro () {
        if ($routeParams.id == $scope.usuario.id){
            $location.path("/");
        } 

       usuarioService.findUsuario($routeParams.id)
        .then(function (response) {
            $scope.detalhes = response.data;

            if($scope.detalhes.sexo == "n") {
                 $scope.info.genero = "Não informado";
            }
            else if($scope.detalhes.sexo == "m") {
                 $scope.info.genero = "Masculino";
            }
            else if($scope.detalhes.sexo == "f") {
                 $scope.info.genero = "Feminino";
            }
        },
        function (response) {
            toastr.error("Ocorreu um erro");
        })
    }

    $scope.enviarSolicitacao = function () {
        if ($routeParams.id == $scope.usuario.id){
            $location.path("/");
        } 

       usuarioService.sendInvitation($routeParams.id)
        .then(function (response) { 
            toastr.success("Solicitação enviada com sucesso!");
        },
        function (response) {
            toastr.error("Ocorreu um erro");
        })
    }
})