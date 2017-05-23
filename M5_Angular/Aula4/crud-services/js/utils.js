Array.prototype.getPosArrayDeNome = function (nome) {
    let resultado = -1;
    this.forEach(function(elemento, index) {
        if (elemento.nome === nome) {
            resultado = index;
        }
    });

    return resultado;
}

Array.prototype.estaSendoUsada = function (id, instrutores) {
    let resultado = false;
    instrutores.forEach (function (instrutor){
        instrutor.aulas.forEach (function (aula) {
            if (aula.id == id){
                resultado = true;
            }
        })
    })
    return resultado;
}

  Object.prototype.clone = function () {
      retorno = {};
      for (var elemento in this) {
          retorno[elemento] = this[elemento];
      }
      return retorno;
  }