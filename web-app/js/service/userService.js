principalApp.factory('userService', ['$http', '$q', function($http, $q) {
  return {
    listUsers: function() {
      return $http.get('http://localhost:8080/svs/api/usuarios')
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('Error while fetching usuarios');
            return $q.reject(errResponse);
          }
        );
    },

    createUser: function(user) {
      return $http.post('http://localhost:8080/svs/api/usuarios/', user)
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('Error while creating usuarios');
            return $q.reject(errResponse);
          }
        );
    },

    updateUser: function(user, id) {
      return $http.put('http://localhost:8080/svs/api/usuarios/' + id, user)
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('Error while updating users');
            return $q.reject(errResponse);
          }
        );
    },

  }

}]);
