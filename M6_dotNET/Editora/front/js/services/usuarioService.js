app.factory('usuarioService', function ($http){
    let urlBase = 'http://localhost:50255/api/';

    function addRevisor(revisor, autorizacao) {
        return $http({
            url: urlBase + "revisores",
            method: 'POST',
            headers: {
                Authorization: autorizacao
            },
            data: revisor
        });
    }
    return {
        addRevisor : addRevisor
    }
})