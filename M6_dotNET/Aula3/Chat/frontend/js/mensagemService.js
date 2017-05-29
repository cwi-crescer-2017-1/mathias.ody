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

app.directive('ngEnter', function() {
        return function(scope, element, attrs) {
            element.bind("keydown keypress", function(event) {
                if(event.which === 13) {
                    scope.$apply(function(){
                        scope.$eval(attrs.ngEnter, {'event': event});
                    });

                    event.preventDefault();
                }
            });
        };
    });