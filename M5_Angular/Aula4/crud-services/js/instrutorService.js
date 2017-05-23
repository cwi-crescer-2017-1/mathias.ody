app.factory('instrutorService', function ($http) {

  let urlBase = 'http://localhost:3000/instrutor';

  function getTodosInstrutores() {
    return $http.get(urlBase);
    //retorna uma promessa que é tratada no controller
  };

  function atualizar(instrutor) {
    return $http.put(urlBase + '/' + instrutor.id, instrutor);
  };

  function criar(instrutor) {
    instrutor.id = ++instrutor;
    instrutores.push(angular.copy(instrutor));
  };

  function removeById (id) {
    return $http.delete(urlBase + '/' + id);
  }

  return {
    list: getTodosInstrutores,
    update: atualizar,
    create: criar,
    removeById : removeById,
  };
});