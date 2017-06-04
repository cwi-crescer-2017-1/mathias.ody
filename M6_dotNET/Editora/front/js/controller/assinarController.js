app.controller('assinarController', function ( livroService,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            $window,
                                            authService
                                            ){ 

    $scope.usuario = authService.getUsuario();
    if ($scope.usuario != null) {
        $scope.logado = true;
    }
})