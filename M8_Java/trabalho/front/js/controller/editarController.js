app.controller('editarController', function ( $scope,
                                                $routeParams,
                                                $localStorage,
                                                usuarioService,
                                                authService,
                                                toastr,
                                                $location){


    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }

    $scope.editar = function () {
        usuarioService.editar($scope.usuario)
        .then(
        function (response) {
            $scope.logado = true;
            toastr.success(`Editado com sucesso!`);
            $location.path("/");
        },
        function (response) {
            $scope.logado = false;
            toastr.error('Ocorreu um error ao editar.');
        });
    }


    /*setarEditarLivro ();
    
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
    }*/
})