app.factory('pedidoService', function ($http){
    let urlBase = 'http://localhost:50675/api/pedidos';
    
    function mandarPedido (pedido, autorizacao) {
        return $http({
            url: urlBase,
            method: 'POST',
            headers: {
            Authorization: autorizacao
            },
            data: pedido
        });
    }

    function obterPedidosParaDevolucao (autorizacao) {
        return $http({
            url: urlBase + "/devolver",
            method: 'GET',
            headers: {
            Authorization: autorizacao
            },
        });
    }

    function devolver (id,autorizacao) {
        return $http({
            url: urlBase + "/devolver/" + id,
            method: 'GET',
            headers: {
            Authorization: autorizacao
            },
        });
    }

    function listarAtrasos(autorizacao){
        return $http({
            url: urlBase + '/atrasados',
            method: 'GET',
            headers: {
            Authorization: autorizacao
            },
        });
    }

    function buscar (data, autorizacao) {
        return $http({
            url: urlBase + '/relatorio',
            method: 'POST',
            headers: {
            Authorization: autorizacao
            },
            data: data
        });
    }

    return {
        pedir : mandarPedido,
        devolucao : obterPedidosParaDevolucao,
        devolver : devolver,
        listarAtrasos:listarAtrasos,
        buscar:buscar
    }
})