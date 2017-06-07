app.factory('produtoService', function ($http){
    let urlBase = 'http://localhost:50675/api/produtos';

    function getProdutos() {
        return $http({
            url: urlBase,
            method: 'GET',
        })
    }

    function getProdutoById (id) {
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
            url:urlBase+ '/revisar/' + livro.Isbn,
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
        getProdutos : getProdutos,
        produtoById : getProdutoById,
        removeLivroById : removeLivroById,
        editar : editar,
        criar : criar,
        revisar:revisar
    }
})