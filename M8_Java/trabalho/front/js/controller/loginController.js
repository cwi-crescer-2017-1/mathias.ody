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

        $scope.login = function () {
            authService.login($scope.usuario)
            .then(
            function (response) {
                $scope.logado = true;
                toastr.success(`Bem vindo ${response.data.Nome}`);
            },
            function (response) {
                $scope.logado = false;
                toastr.error('Ocorreu um error ao fazer seu login.');
            });
    };
});