principalApp.factory('salesService', ['$http', '$q', function($http, $q) {
  return {
    createSale: function(venda) {
      return $http.post('http://localhost:8080/svs/api/vendas/', venda)
        .then(
          function(response) {
            return response.data;
          },
          function(errResponse) {
            console.error('Error while creating sale');
            return $q.reject(errResponse);
          }
        );
    },

    listSales: function() {
      return $http.get('http://localhost:8080/svs/api/vendas')
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


  }

}]);
