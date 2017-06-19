principalApp.factory('loginService', ['$http', '$q', function($http, $q) {

  var token = undefined;

  return {
    login: function(login) {
      return $http.post('http://localhost:8080/svs/api/login', login)
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('Erro login');
            return $q.reject(errResponse);
          }
        );
    },

  };

}]);
