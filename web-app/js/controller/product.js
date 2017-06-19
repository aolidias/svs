principalApp.controller('productController', ['$scope', 'productService', function($scope, productService) {

  var self = this;

  self.product = { id: null, nome: '', codigo: '', preco: '', tipo: '' };
  self.products = [];

  self.types = ["ACESSO", "FECHADO"];

  self.listProducts = function() {
    productService.listProducts()
      .then(
        function(d) {
          self.products = d;
        },
        function(errResponse) {
          window.alert("Deu ruim");
        }
      );
  };

  self.createProduct = function(product) {
    productService.createProduct(product)
      .then(
        self.listProducts,
        function(errResponse) {
          window.alert("Duplicate product.");
          console.error('Error while creating product.');
        }
      );
    self.reset();
  };

  self.updateProduct = function(product, id) {

    productService.updateProduct(product, id)
      .then(
        self.listProducts,
        function() {
          window.alert("Product updated!");
        },
        function(errResponse) {
          window.alert("Error while updating Product.");
          console.error('Error while updating Product.');
        }
      );
    self.reset();
  };

  self.listProducts();

  self.submit = function() {
    if (self.product.id == null) {
      console.log('Saving New Product', self.product);
      self.createProduct(self.product);
    } else {
      self.updateProduct(self.product, self.product.id);
      console.log('Product updated with id ', self.product.id);
    }
    self.reset();
  };

  self.edit = function(id) {
    console.log('id to be edited', id);
    for (var i = 0; i < self.products.length; i++) {
      if (self.products[i].id == id) {
        console.log(self.products[i])
        self.product = angular.copy(self.products[i]);
        break;
      }
    }
  };

  self.reset = function() {
    self.product = { id: null, name: '', price: '' };
    $scope.myForm.$setPristine();
  };

}]);
