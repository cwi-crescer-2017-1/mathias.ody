app.factory('livroService', function ($http){
    let urlBase = 'http://localhost:50255/api/livros';

    function getLancamentos() {
        return $http.get(urlBase + "/lancamentos");
    }

    return {
        lancamentos : getLancamentos
    }
})