app.controller('registrarController', function (
                                            authService,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            $window,
                                            usuarioService,
                                            toastr
                                            ){ 

    if (authService.getUsuario() != null) {
        $location.path("/");
    }

    $scope.registrar = function () {
        usuarioService.registrar($scope.usuario)
        .then(
        function (response) {
            console.log(response);
            if (response.data == null || response.data == "") {
                toastr.warning(`Email já cadastrado!`);
                return;
            }
            else {
                $scope.logado = true;
                toastr.success(`Registrado com sucesso!`);
                $location.path("home");
            }
        },
        function (response) {
            $scope.logado = false;
            toastr.error('Ocorreu um error ao registrar.');
        });
    }
    })