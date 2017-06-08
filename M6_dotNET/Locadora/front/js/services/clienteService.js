app.factory('clienteService', function ($http){
    let urlBase = 'http://localhost:50675/api/clientes';

    function getCliente() {
        return $http({
            url: urlBase,
            method: 'GET',
        })
    }

    function getClienteByCpf (cpf,autorizacao) {
        return $http({
            url: urlBase + '?CPF=' + cpf,
            method: 'GET',
            headers: {
                Authorization: autorizacao
            },
        })
    }

    function removeClienteById (id) {
        return $http({
            url: urlBase + "/" + id,
            method: 'DELETE',
        })
    }

    function criar(cliente, autorizacao) {
        return $http({
            url: urlBase,
            method: 'POST',
            headers: {
                Authorization: autorizacao
            },
            data: cliente
        });
    }

    function editar(cliente, autorizacao) {
        return $http({
            url: urlBase + '/' + cliente.Id,
            method: 'PUT',
            headers: {
            Authorization: autorizacao
            },
            data: cliente
        });
    }

    return {
        getCliente : getCliente,
        getByCpf : getClienteByCpf,
        removeClienteById : removeClienteById,
        alterar : editar,
        criar : criar
    }
})