// """Construtor"""
function SerieDeTV(nome, anoEstreia) {
    this.nome = nome || 'NI';
    this.anoEstreia = anoEstreia;
}

//"""Função para a 'classe'"""
SerieDeTV.prototype.imprimeNome = function () {
    console.log (this.nome.toUpperCase());
}

//ECMA script criacao de classe "facilitada"
//JS tentando ser OOP?
class SerieDeTV {
    constructor (nome, anoEstreia){
        this.nome = nome || 'NI';
        this.anoEstreia = anoEstreia;
    }

    imprimirNome() {
        console.log(this.nome.toUpperCase());
    }
}
