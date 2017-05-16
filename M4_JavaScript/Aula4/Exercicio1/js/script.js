function arredonda (num = 0, casas = 2) {
    return num.toFixed (casas);
}

console.log (arredonda(12.455677, 4))

Number.prototype.arredondar = function (casas = 2){
    return Math.round((this) * Math.pow(10,casas)) / Math.pow(10,casas);
}
