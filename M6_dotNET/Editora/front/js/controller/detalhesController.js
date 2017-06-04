app.controller('detalhesController', function ( $scope,
                                                $routeParams,
                                                livroService,
                                                authService){
    
    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }
    
    detalhesLivro ();
    
    function detalhesLivro () {
        livroService.livroId($routeParams.id)
        .then(function (response) {
            $scope.detalhes = response.data.dados;
        },
        function (response) {
            $scope.detalhes = response.data;
        })
    }
})