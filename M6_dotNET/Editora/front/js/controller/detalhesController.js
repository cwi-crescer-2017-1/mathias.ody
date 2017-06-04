app.controller('detalhesController', function ( $scope,
                                                $routeParams,
                                                livroService){
    
    detalhesLivro ();
    
    function detalhesLivro () {
        livroService.livroId($routeParams.id)
        .then(function (response) {
            $scope.detalhes = response.data.dados;
            console.log(response.data.dados);
        },
        function (response) {
            $scope.detalhes = response.data;
            console.log(response.data);
        })
    }
})