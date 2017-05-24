app.factory('aulaService', function ($http) {

  let urlBase = 'http://localhost:3000/aula';

  function getTodasAsAulas() {
    return $http.get(urlBase);
  };

  function getAulaById (id) {
    return $http.get(urlBase + '/' + id);
  }

  function update(aula) {
    return $http.put(urlBase + '/' + aula.id, aula);
  };

  function incluir(aula) {
    return $http.post(urlBase + '/', aula);
  };

  function removeById (id) {
    return $http.delete(urlBase + '/' + id);
  }

  return {
    listar: getTodasAsAulas,
    update: update,
    create: incluir,
    removeById : removeById,
    getAulaById : getAulaById
  };
});

app.filter('contem', function() {
      return function (lista, filtro) {
         if (lista == null) {return [];}
         let resultado = [];
         lista.forEach(function (aula){
              filtro.forEach(function (aulaInstrutor){
                if(aulaInstrutor === aula.id) {
                    resultado.push(aula);
                }
              })
         })
         return resultado;
      }
})