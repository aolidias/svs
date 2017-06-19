principalApp.factory('stockService', ['$http', '$q', function($http, $q) {

  return {

    listProducts: function() {
      return $http.get('http://localhost:8080/svs/api/estoque/')
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('DEU RUIM');
            return $q.reject(errResponse);
          }
        );
    },

    updateStock: function(estoque) {
      return $http.post('http://localhost:8080/svs/api/estoque', estoque)
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('Erro atualizando estoque!');
            return $q.reject(errResponse);
          }
        );
    }
  };

}]);
