modules = {

  jquery{
    resource url: [dir: 'js/lib', file: 'jquery-2.1.0.min.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'jquery-ui.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'jquery.mask.min.js'], disposition: 'head'
    resource url: [dir: 'css', file: 'jquery-ui.css'], disposition: 'head'
    resource url: [dir: 'css', file: 'jquery-ui.structure.css'], disposition: 'head'
    resource url: [dir: 'css', file: 'jquery-ui.theme.css'], disposition: 'head'
  }

  bootstrap {
    dependsOn 'jquery'
    resource url: [dir: 'js/lib', file: 'bootstrap.min.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'typeahead.min.js'], disposition: 'head'
    resource url: [dir: 'css', file: 'bootstrap.min.css'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'bootstrap-select.min.js'], disposition: 'head'
    resource url: [dir: 'css', file: 'bootstrap-select.min.css']
  }

  moment {
    resource url: [dir: 'js/lib', file: 'moment.js'], disposition: 'head'
  }

  pnotify{
    dependsOn 'jquery'
    resource url: [dir: 'js/lib/pnotify', file: 'pnotify.min.js'], disposition: 'head'
    resource url: [dir: 'css/lib/pnotify', file: 'pnotify.min.css'], disposition: 'head'

  }

  angularComplete {
    dependsOn 'pnotify'
    dependsOn 'underscore'
    dependsOn 'moment'
    resource url: [dir: 'js/lib', file: 'angular.min.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'angular-route.min.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'moment-timezone.min.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'angular-moment.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'ui-bootstrap-all.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'ng-i18n-0.2.1.min.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'angular-local-storage.min.js'], disposition: 'head'
    resource url: [dir: 'js/lib', file: 'angular-pnotify.js'], disposition: 'head'
  }
  underscore {
    resource url: [dir: 'js/lib', file: 'underscore.js'], disposition: 'head'
  }



  principal{
    dependsOn 'bootstrap'
    dependsOn 'angularComplete'
    resource url: [dir: 'js', file: 'index.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'controller/index.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'service/sessionService.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'controller/product.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'service/productService.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'controller/cliente.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'service/clientService.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'controller/sale.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'service/saleService.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'controller/user.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'service/userService.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'service/stockService.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'controller/login.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'service/loginService.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'controller/stock.js'], disposition: 'head'
    resource url: [dir: 'js', file: 'controller/error.js'], disposition: 'head'
    resource url: [dir: 'css', file: 'app.css']
  }

}
