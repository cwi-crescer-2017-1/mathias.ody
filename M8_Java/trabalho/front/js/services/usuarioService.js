app.factory('usuarioService', function ($http){
    let urlBase = 'http://localhost:9090/api/';

    function registrar(usuario) {
        return $http({
            url: urlBase + "usuario",
            method: 'POST',
            data: usuario
        });
    }

    function editar(usuario) {
        return $http({
            url: urlBase + "usuario/editar",
            method: 'PUT',
            data: usuario
        });
    }

    function findList(nomeUsuario) {
        return $http({
            url: urlBase + "usuario/buscar/" + nomeUsuario,
            method: 'GET',
        });
    }

    function findUsuario(id) {
        return $http({
            url: urlBase + "usuario/" + id,
            method: 'GET',
        });
    }

    function sendInvitation(id) {
        return $http({
            url: urlBase + "usuario/enviarSolicitacao/" + id,
            method: 'POST',
        });
    }

    function getInvitations() {
        return $http({
            url: urlBase + "usuario/solicitacoes",
            method: 'GET',
        });
    }

    function acceptInvitation(id) {
        return $http({
            url: urlBase + "usuario/aceitarSolicitacao/" + id,
            method: 'POST',
        });
    }

    function refuseInvitation(id) {
        return $http({
            url: urlBase + "usuario/recusarSolicitacao/" + id,
            method: 'POST',
        });
    }

    function getFriends() {
        return $http({
            url: urlBase + "usuario/amigos",
            method: 'GET',
        });
    }

    function statusSolicitacao(id) {
        return $http({
            url: urlBase + "usuario/statusSolicitacao/" + id,
            method: 'POST',
        });
    }

    return {
        registrar : registrar,
        findListUsuarios : findList,
        findUsuario : findUsuario,
        sendInvitation : sendInvitation,
        getInvitations, getInvitations,
        acceptInvitation : acceptInvitation,
        refuseInvitation : refuseInvitation,
        getFriends : getFriends,
        editar : editar,
        statusSolicitacao : statusSolicitacao,
    }
})