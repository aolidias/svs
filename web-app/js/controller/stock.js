principalApp.controller('stockController', ['$scope', 'stockService', function($scope, stockService) {

  var self = this;

  self.stock = { id: null, name: '', price: '' };
  self.stocks = [];

  self.editMode = false;

  self.listProducts = function() {
    stockService.listProducts()
      .then(
        function(d) {
          self.products = d;
        },
        function(errResponse) {
          window.alert("Deu ruim");
        }
      );
  };

  self.edit = function(id, quantidade) {
    var estoque = {  "id" : id, "quantidade": quantidade};
    stockService.updateStock(estoque).then(
      function(d) {
        self.editMode = false;
        self.listProducts;
      },
        function(errResponse) {
        window.alert("Deu ruim");
      });
  };

  self.listProducts();

}]);
