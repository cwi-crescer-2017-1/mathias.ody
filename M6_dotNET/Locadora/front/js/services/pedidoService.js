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

    return {
        pedir : mandarPedido
    }
})