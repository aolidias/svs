principalApp.controller('loginController', ['$scope', 'loginService', '$location', 'sessionService', '$window', function($scope, loginService, $location, sessionService, $window) {

  var self = this;

  self.login = { login: '', senha: ''};
  self.loginError = false;

  self.submit = function() {
    loginService.login(self.login).then(
      function (response) {
        sessionService.setToken(response);
        $location.path('/svs/index').replace();
        $window.location.reload();
      }, function (errResponse) {
      self.loginError = true;
    });
  };  
}]);
