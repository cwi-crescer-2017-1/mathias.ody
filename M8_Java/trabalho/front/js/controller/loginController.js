app.controller('loginController', function (
                                            $scope,
                                            $routeParams,
                                            $location,
                                            authService, 
                                            toastr)
                                            { 

        
         if (authService.getUsuario() != null) {
            $location.path("/");
        }     

        if ($scope.usuario != null) {
            $scope.logado = true;
        }

        $scope.login = function () {
            authService.login($scope.usuario)
            .then(
            function (response) {
                $scope.logado = true;
                toastr.success(`Bem vindo ${response.data.dados.nome}`);
            },
            function (response) {
                $scope.logado = false;
                toastr.error('Ocorreu um error ao fazer seu login.');
            });
    };
});