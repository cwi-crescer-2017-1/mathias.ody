app.controller('crudController', function ( livroService,
                                            $scope,
                                            $routeParams,
                                            $location,
                                            $window,
                                            authService,
                                            toastr
                                            ){ 

    $scope.logout = authService.logout;
    
    $scope.usuario = authService.getUsuario();
    
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

    //
    //Listar
    //
    function listarLivrosCompleto() {
        livroService.getLivros($scope.parametros).then(function(response){
            let livros = response.data.dados;
            livros.forEach(function(livro) {
                if (livro.DataRevisao == null) {
                    
                }
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