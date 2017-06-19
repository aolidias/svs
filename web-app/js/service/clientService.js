principalApp.factory('clientService', ['$http', '$q', function($http, $q) {

  return {

    listClients: function() {
      return $http.get('http://localhost:8080/svs/api/clientes')
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('Error while fetching clients');
            return $q.reject(errResponse);
          }
        );
    },

      listOpenClients: function() {
          return $http.get('http://localhost:8080/svs/api/clients/list')
              .then(
                  function(response) {
                      return response.data;
                  },
                  function(errResponse) {
                      console.error('Error while fetching clients');
                      return $q.reject(errResponse);
                  }
              );
      },

    createClient: function(client) {
      return $http.post('http://localhost:8080/svs/api/clientes/', client)
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('Error while creating client');
            return $q.reject(errResponse);
          }
        );
    },

    updateClient: function(client, id) {
      return $http.put('http://localhost:8080/svs/api/clientes/' + id, client)
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('Error while updating clients');
            return $q.reject(errResponse);
          }
        );
    },



  };

}]);
