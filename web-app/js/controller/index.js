principalApp.controller('indexController', ['$scope', '$location', '$window', function($scope, $location, $window) {

  self = this;

  self.logout = function() {
    $location.path('/svs/login').replace();
    $window.location.reload();
  }
  
}]);
