app.factory('livroService', function ($http){
    let urlBase = 'http://localhost:50255/api/livros';

    function getLancamentos() {
        return $http.get(urlBase + "/lancamentos");
    }

    function getLivros(parametros) {
        return $http({
            url: urlBase,
            method: 'GET',
            params: parametros
        })
    }

    function getLivroById (id) {
        return $http({
            url: urlBase + "/" + id,
            method: 'GET',
        })
    }

    function removeLivroById (id) {
        return $http({
            url: urlBase + "/" + id,
            method: 'DELETE',
        })
    }

    function criar(livro, autorizacao) {
        return $http({
            url: urlBase,
            method: 'POST',
            headers: {
                Authorization: autorizacao
            },
            data: livro
        });
    }

    function editar(livro, autorizacao) {
        return $http({
            url: urlBase + '/' + livro.Isbn,
            method: 'PUT',
            headers: {
            Authorization: autorizacao
            },
            data: livro
        });
    }

    function revisar(livro, autorizacao) {
        return $http({
            url:urlBase+ '/' + livro.Isbn,
            method: 'PUT',
            headers: {
            Authorization: autorizacao
            },
            data:livro
        })
    }

    function publicar(livro, autorizacao) {
        return $http({
            url:urlBase+ '/' + livro.Isbn,
            method: 'PUT',
            headers: {
            Authorization: autorizacao
            },
            data:livro
        })
    }

    return {
        lancamentos : getLancamentos,
        getLivros : getLivros,
        livroId : getLivroById,
        removeLivroById : removeLivroById,
        editar : editar,
        criar : criar,
        revisar:revisar
    }
})