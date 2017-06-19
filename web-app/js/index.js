var principalApp = angular.module('principalApp', ['ngRoute', 'angularMoment', 'ui.bootstrap']);


// configure our routes
principalApp.config(function($routeProvider, $locationProvider) {

  $routeProvider.when('/productCrud', {
    templateUrl: 'svs/productIndex',
    controller: 'productController'
  // }).when('/login', {
  //   templateUrl: 'login',
  //   controller: 'loginController'
  }).when('/index', {
    templateUrl: 'index',
    controller: 'indexController'
  }).when('/clientCrud', {
    templateUrl: 'svs/clientIndex',
    controller: 'clientController'
  }).when('/saleCrud/:client_id?', {
    templateUrl: 'svs/salesIndex',
    controller: 'salesController'
  }).when('/userCrud', {
    templateUrl: 'svs/userIndex',
    controller: 'userController'
  }).when('/stockCrud', {
    templateUrl: 'svs/stockIndex',
    controller: 'stockController'
  }).when('/logout', {
    templateUrl: 'svs/login',
    controller: 'loginController'
  }).when('/forbidden', {
    templateUrl: 'svs/forbidden',
    controller: 'forbiddenController'
  });

  $locationProvider.html5Mode({ enabled: true});

});

principalApp.factory('httpRequestInterceptor', function (sessionService, $window, $location) {
  return {
    request: function (config) {
      config.headers['Auth-Token'] = sessionService.getToken();
      return config;
    },
    'responseError': function(rejection) {
      if(rejection.status === 401){
        $location.path('/svs/forbidden').replace();
        $window.location.reload();
      }     
    }
  };
});

principalApp.config(function ($httpProvider) {
  $httpProvider.interceptors.push('httpRequestInterceptor');
});
