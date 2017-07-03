app.factory('socialService', function ($http){
    let urlBase = 'http://localhost:9090/api/';

    function postar(post) {
        return $http({
            url: urlBase + 'post',
            method: 'POST',
            data: post
        });
    }

    function getPosts() {
        return $http({
            url: urlBase + 'posts',
            method: 'GET',
        });
    }

    function curtir(id) {
        return $http({
            url: urlBase + 'curtir/' + id,
            method: 'POST',
        });
    }

    return {
        postar : postar,
        getPosts: getPosts,
        curtir: curtir
    }
})