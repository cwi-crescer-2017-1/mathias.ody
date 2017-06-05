app.controller('loginController', function (
                                            $scope,
                                            $routeParams,
                                            $location,
                                            authService, 
                                            toastr)
                                            { 

        $scope.usuario = authService.getUsuario();
        if ($scope.usuario != null) {
            $scope.logado = true;
        }

        $scope.login = function (usuario) {
            authService.login(usuario)
            .then(
            function (response) {
                $scope.logado = true;
                $location.path('/administrativo');
                toastr.success(`Bem vindo ${response.data.dados.Nome}`);
            },
            function (response) {
                $scope.logado = false;
                toastr.error('Ocorreu um error ao fazer seu login.');
            });
    };
});