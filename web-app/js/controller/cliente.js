principalApp.controller('clientController', ['$scope', 'clientService', '$filter', function($scope, clientService, $filter) {


  $(document).ready(function() {
    $('#birthday').mask('00/00/0000');
    $('#cpf').mask('000.000.000-00');
  });

  var self = this;
  
  self.client = {
    id: null,
    nome: '',
    dataDeNascimento: '',
    telefone: '',
    endereco: '',
    cpf: '',
    email: '',
    peso: 0,
    altura: 0
  };
  self.clients = [];

  self.listClients = function() {
    clientService.listClients()
      .then(
        function(d) {
          self.clients = d;
        },
        function(errResponse) {
          window.alert("Error while fetching clients");
          console.error('Error while fetching clients');
        }
      );
  };

  self.createClient = function(client) {
    clientService.createClient(client)
      .then(
        self.listClients,
        function(errResponse) {
          window.alert("Duplicate client.");
          console.error('Error while creating client.');
        }
      );
    self.reset();

  };

  self.updateClient = function(client, id) {

    clientService.updateClient(client, id)
      .then(
        self.listClients,
        function() {
          window.alert("client updated!");
        },
        function(errResponse) {
          window.alert("Error while updating client.");
          console.error('Error while updating client.');
        }
      );
    self.reset();
  };


  self.listClients();

  self.submit = function() {
    if (self.client.id == null) {
      console.log('Saving New client', self.client);
      self.createClient(self.client);
    } else {
      self.updateClient(self.client, self.client.id);
      console.log('client updated with id ', self.client.id);
    }
    self.reset();
  };

  self.edit = function(id) {
    console.log('id to be edited', id);
    for (var i = 0; i < self.clients.length; i++) {
      if (self.clients[i].id == id) {
        console.log(self.clients[i])
        self.client = angular.copy(self.clients[i]);
        break;
      }
    }
  };


  self.reset = function() {
    self.client = {
      id: null,
      nome: '',
      dataDeNascimento: '',
      telefone: '',
      endereco: '',
      cpf: '',
      email: '',
      peso: 0,
      altura: 0
    };
    $scope.myForm.$setPristine();
  };

}]);
