app.factory('mensagemService', function ($http) {

  let urlBase = 'http://localhost:49797/api/mensagem';

  function getTodasMensagens() {
    return $http.get(urlBase);
  };

  function incluir(mensagem) {
    return $http.post(urlBase, mensagem);
  };

  return {
    listar: getTodasMensagens,
    create: incluir,
  };
});