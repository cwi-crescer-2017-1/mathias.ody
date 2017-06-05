app.controller('editarController', function ( $scope,
                                                $routeParams,
                                                $localStorage,
                                                livroService,
                                                authService,
                                                toastr,
                                                $location){


    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }

    setarEditarLivro ();
    
    function setarEditarLivro () {
        livroService.livroId($routeParams.id)
        .then(function (response) {
            $scope.editando = response.data.dados;
        },
        function (response) {
            $scope.detalhes = response.data;
        })
    }

    $scope.cancelar = function () {
        $location.path("/crud");
    }

    $scope.aceitar = function () {
        livroService.editar($scope.editando, $localStorage.headerAuth)
        .then(function() {
            $location.path("/crud");            
        })
    }
})