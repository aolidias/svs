principalApp.service('sessionService', function() {

  var token;

  return {

    setToken: function(token) {
      token = token;
      sessionStorage.userService = token.token;
    },

    getToken: function() {
      return sessionStorage.userService;
    }
  }

});
