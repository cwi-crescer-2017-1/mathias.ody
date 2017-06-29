app.controller('crudController', function ( livroService,
                                            $localStorage,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            $window,
                                            authService,
                                            usuarioService,
                                            toastr
                                            ){ 

    $scope.logout = authService.logout;    
    $scope.usuario = authService.getUsuario();
    $scope.isRevisor = authService.possuiPermissao("Revisor");
    $scope.isPublicador = authService.possuiPermissao("Publicar");
    
    setParametros();
    listarLivrosCompleto();
    setTimeout(resize, 500)

    function setParametros() {
        $scope.parametros = {
            jump: 0,
            bring: 20,
            full:true
        };
    }

    $scope.revisar = function(livro) {
        livro.Revisor = usuarioService.addRevisor({Nome: $scope.usuario.Nome}).then (function(response){
            livroService.revisar(livro, $localStorage.headerAuth).then(function(response){
                //$scope.outrosLivros = response.data.dados;
            },function(response){
                toastr.error("Algo deu errado!");
            })
            listarLivrosCompleto();
        })
    }

    $scope.publicador = function(livro) {
        livroService.publicar(livro, $localStorage.headerAuth).then(function(response){
            //$scope.outrosLivros = response.data.dados;
        },function(response){
            toastr.error("Algo deu errado!");
        })
        listarLivrosCompleto();
    }

    //
    //Listar
    //
    function listarLivrosCompleto() {
        livroService.getLivros($scope.parametros).then(function(response){
            let livros = response.data.dados;
            livros.forEach(function(livro) {

            });
            $scope.livros = livros;
        })
    }

    //
    //Deletar
    //
    $scope.deletar = function (id) {
        let posInArray = $scope.livros.getPosArrayById (id);
        livroService.removeLivroById(id).then(function(resposta){
            listarLivrosCompleto();
        });
        toastr.success("Livro excluído com sucesso!");
    }

    function resize () {
        let list = document.getElementsByClassName("crud-capa");
        let width = 0;
        for (let i = 0; i < list.length; i++) {
            if (i == 0) {
                width = list[i].clientWidth;
            }
            list[i].style.height = '' + width *1.5 + 'px';
        }
    }

    function resizeEvent (event) {
        resize();
    }
    
    addEvent(window, "resize", resizeEvent);
})