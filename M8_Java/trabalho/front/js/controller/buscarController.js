app.controller('buscarController', function (
                                            $localStorage,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            $window,
                                            authService,
                                            usuarioService,
                                            toastr
                                            ){ 
    $scope.buscar = function () {
        usuarioService.findListUsuarios($scope.busca.nome)
        .then (function(response){
               $scope.usuariosEncontrados = response.data;
               $scope.usuariosEncontrados.forEach(function(element) {
                   $scope.getStatus(element);
               });
            },function(response){
                toastr.error("Algo deu errado!");
            })
    }

    $scope.getStatus = function (usuario) {
       usuarioService.statusSolicitacao(usuario.id)
        .then(function (response) { 
            usuario.status = response.data;
        })
    }

    $scope.enviarSolicitacao = function (id) {
       usuarioService.sendInvitation(id)
        .then(function (response) { 
            toastr.success("Solicitação enviada com sucesso!");
            $scope.buscar ();
        },
        function (response) {
            toastr.error("Ocorreu um erro");
        })
    }

})