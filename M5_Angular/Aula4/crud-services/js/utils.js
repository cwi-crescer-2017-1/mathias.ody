Array.prototype.getPosArrayByNome = function (nome) {
    let resultado = -1;
    this.forEach(function(elemento, index) {
        if (elemento.nome === nome) {
            resultado = index;
        }
    });

    return resultado;
}

Array.prototype.getPosArrayById = function (id) {
    let resultado = -1;
    for (let i = 0; i < this.length; i++) {
        if (this[i].id === id) {
            resultado = id;
        }
    }
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

Array.prototype.contemNome = function (nome, id = true) {
    resultado = false;
    this.forEach(function (elemento) {
        if (elemento.nome === nome && elemento.id !== id) {
            resultado = true;
        }
    })
    return resultado;
}

Array.prototype.contemEmail = function (email, id = true) {
    resultado = false;
    this.forEach(function (elemento) {
        if (elemento.email === email && elemento.id !== id) {
            resultado = true;
        }
    })
    return resultado;
}

Array.prototype.getIdByNome = function (nome) {
    let resultado = -1;
    this.forEach(function(elemento) {
        if (elemento.nome === nome) {
            resultado = elemento.id;
        }
    });

    return resultado;
}

  Object.prototype.clone = function () {
      retorno = {};
      for (var elemento in this) {
          retorno[elemento] = this[elemento];
      }
      return retorno;
}