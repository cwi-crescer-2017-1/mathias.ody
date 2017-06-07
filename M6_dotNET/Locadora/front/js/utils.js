var addEvent = function(object, type, callback) {
    if (object == null || typeof(object) == 'undefined') return;
    if (object.addEventListener) {
        object.addEventListener(type, callback, false);
    } else if (object.attachEvent) {
        object.attachEvent("on" + type, callback);
    } else {
        object["on"+type] = callback;
    }
};

Array.prototype.getPosArrayById = function (id) {
    let resultado = -1;
    for (let i = 0; i < this.length; i++) {
        if (this[i].id === id) {
            resultado = id;
        }
    }
    return resultado;
}