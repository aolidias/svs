principalApp.controller('userController', ['$scope', 'userService', function($scope, userService) {

  var self = this;
  self.users = [];

  self.user = { id: null, login: '', senha: '', tipoDoUsuario: '' };

  self.types = ["VENDEDOR", "GERENTE"];

  self.listUsers = function() {
    userService.listUsers()
      .then(
        function(d) {
          self.users = d;
        },
        function(errResponse) {
          window.alert(errResponse);
        }
      );
  };

  self.listUsers();

  self.createUser = function(user) {
    userService.createUser(user)
      .then(
        self.listUsers,
        function(errResponse) {
          window.alert("Duplicate user.");
          console.error('Error while creating product.');
        }
      );
    self.reset();
  };

  self.updateUser = function(user, id) {

    userService.updateUser(user, id)
      .then(
        self.listUsers,
        function() {
          window.alert("Usuário atualizado.");
        },
        function(errResponse) {
          window.alert("Error while updating Product.");
          console.error('Error while updating Product.');
        }
      );
    self.reset();
  };

  self.submit = function() {
    if (self.user.id == null) {
      console.log('Saving New User', self.user);
      self.createUser(self.user);
    } else {
      self.updateUser(self.user, self.user.id);
      console.log('user updated with id ', self.user.id);
    }
    self.reset();
  };

  self.edit = function(id) {
    console.log('id to be edited', id);
    for (var i = 0; i < self.users.length; i++) {
      if (self.users[i].id == id) {
        console.log(self.users[i])
        self.user = angular.copy(self.users[i]);
        break;
      }
    }
  };

  self.reset = function() {
    self.user = { id: null, login: '', senha: '', tipoDoUsuario: '' };
    $scope.myForm.$setPristine();
  };

}]);
