app.factory('instrutorFactory', function ($http) {

  let urlBase = 'http://localhost:3000';

  function getTodosInstrutores() {
    return $http.get(urlBase + '/instrutor');
  };

  function getInstrutorPorId(id) {
    return $http.get(urlBase + '/instrutor' + '/' + id);
  };

  function atualizar(instrutor) {
    return $http.put(urlBase + '/instrutor' + '/' + instrutor.id, instrutor);
  };

  function criar(instrutor) {
    instrutor.id = ++instrutor;
    instrutores.push(angular.copy(instrutor));
  };

  return {
    list: getTodosInstrutores,
    findById: getInstrutorPorId,
    update: atualizar,
    create: criar
  };
});