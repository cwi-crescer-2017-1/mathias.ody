app.factory('instrutorService', function ($http) {

  let urlBase = 'http://localhost:3000/instrutor';

  function getTodosOsInstrutores() {
    return $http.get(urlBase);
  };

  function getTodasAsAulas() {
    return $http.get('http://localhost:3000/aula');
  };

  function getInstrutorById (id) {
    return $http.get(urlBase + '/' + id);
  }

  function update(instrutor) {
    return $http.put(urlBase + '/' + instrutor.id, instrutor);
  };

  function incluir(instrutor) {
    return $http.post(urlBase + '/', instrutor);
  };

  function removeById (id) {
    return $http.delete(urlBase + '/' + id);
  }

  return {
    listar: getTodosOsInstrutores,
    listarAulas : getTodasAsAulas,
    update: update,
    create: incluir,
    removeById : removeById,
    getInstrutorById : getInstrutorById
  };
});