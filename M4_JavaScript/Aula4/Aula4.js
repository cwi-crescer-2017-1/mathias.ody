class SerieDeTV {
    constructor (nome, anoEstreia){
        this.nome = nome || 'NI';
        this.anoEstreia = anoEstreia;
    }

    static verificarClassificacaoIndicativa() {
        return this.nome; //o this é perigoso de ser usado no JS, porque ele assume valores diferentes de
        //acordo com o contexto de execução.
    }

    //esse método será sempre audtomaticamente chamado quando for acessado "serie.nomeSerie"
    get nomeSerie () {
        return this.nome.toUpperCase();
    }

    //automaticamente chamada quando for escrito "serie.nomeSerie = algumacoisa"
    set nomeSerie(valor){
        this.nome = valor.toUpperCase();
    }

    imprimirNome() {
        console.log(this.nome.toUpperCase());
    }

    html() {
        return `<h2>${ this.nome }<h2>`;// OBS.: nesse estado, AINDA não mostrará na tela!!!
    }
}

var serie = new SerieDeTV ("NomeSerie", 2010); // -> cria um novo escopo e um novo "this", que é o objeto.
var serie = SerieDeTV ("NomeSerie", 2010); // -> "this" é Window
