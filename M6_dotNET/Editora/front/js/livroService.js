app.factory('livroService', function ($http){
    let urlBase = 'http://localhost:50255/api/livros';

    function getLancamentos() {
        return $http.get(urlBase + "/lancamentos");
    }

    function getOutrosLivros(parametros) {
        return $http({
            url: urlBase,
            method: 'GET',
            params: parametros
        })
    }

    return {
        lancamentos : getLancamentos,
        outros : getOutrosLivros
    }
})