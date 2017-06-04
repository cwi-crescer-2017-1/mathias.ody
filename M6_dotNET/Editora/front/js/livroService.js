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

    return {
        lancamentos : getLancamentos,
        getLivros : getLivros,
        livroId : getLivroById
    }
})