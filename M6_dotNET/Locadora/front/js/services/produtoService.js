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

    function removeProdutoById (id) {
        return $http({
            url: urlBase + "/" + id,
            method: 'DELETE',
        })
    }
    
    function editar(produto, autorizacao) {
        return $http({
            url: urlBase + '/' + produto.Isbn,
            method: 'PUT',
            headers: {
            Authorization: autorizacao
            },
            data: produto
        });
    }

    return {
        getProdutos : getProdutos,
        produtoById : getProdutoById,
        removeProdutoById : removeProdutoById,
        editar : editar
    }
})