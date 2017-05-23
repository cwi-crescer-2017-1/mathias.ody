var app = angular.module('App', ['ngRoute']);

app.factory('aulaFactory', function ($http) {

  let urlBase = 'http://localhost:3000';

  function getTodasAsAulas() {
    return $http.get(urlBase + '/aula');
  };

  function getAulaPorId(id) {
    return $http.get(urlBase + '/aula' + '/' + id);
  };

  function atualizar(aula) {
    return $http.put(urlBase + '/aula' + '/' + aula.id, aula);
  };

  function criar(aula) {
    aula.id = ++idAtual;
    aulas.push(angular.copy(aula));
  };

  return {
    list: getTodasAsAulas,
    findById: getAulaPorId,
    update: atualizar,
    create: criar
  };
});

app.filter('contem', function() {
      return function (lista, filtro) {
         let resultado = [];
         lista.forEach(function (aula){
              filtro.forEach(function (aulaInstrutor){
                if(aulaInstrutor.id === aula.id) {
                    resultado.push(aula);
                }
              })
         })
         return resultado;
      }
  })