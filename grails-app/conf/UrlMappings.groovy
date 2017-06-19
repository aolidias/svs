class UrlMappings {

  static mappings = {
    "/api/domains/$controller/$action?/$id?(.$format)?" {
      constraints {
      }
    }

    "/api/produtos"(resources: "produto", includes: ['show', 'index', 'save', 'update'])
    "/api/clientes"(resources: "cliente", includes: ['show', 'index', 'save', 'update'])
    "/api/vendas"(resources: "venda", includes: ['show', 'index', 'save'])
    "/api/usuarios"(resources: "usuario", includes: ['show', 'index', 'save', 'update'])
    "/api/estoque"(resources: "estoque", includes: ['show', 'index', 'save'])

    "/api/login"(controller: "login", parseRequest: true) {
      action = [POST: "save"]
    }

    // "/api/login"(resources: "login", includes: ['save'])
    "/productIndex"(controller: "produto", parseRequest: true) {
      action = [GET: "showProductsTemplate"]
    }
    "/clientIndex"(controller: "cliente", parseRequest: true) {
      action = [GET: "showClientsTemplate"]
    }
    "/stockIndex"(controller: "estoque", parseRequest: true) {
      action = [GET: "showStockTemplate"]
    }
    "/salesIndex"(controller: "venda", parseRequest: true) {
      action = [GET: "showSalesTemplate"]
    }

    "/api/logout"(controller: "login", parseRequest: true) {
      action = [POST: "logout"]
    }

    "/api/products/list"(controller: "openApi", parseRequest: true) {
      action = [GET: "listProducts"]
    }

    "/api/clients/list"(controller: "openApi", parseRequest: true) {
      action = [GET: "listClients"]
    }

    "/userIndex"(controller: "usuario", parseRequest: true) {
      action = [GET: "showUserTemplate"]
    }
    "/login#/index" (view: "/index")
    "/login"(view: "/login")
    "/index"(view: "/index")
    "/erro"(view: "/error")
    "/forbidden"(view: "/forbidden")

    "500"(view: '/error')
  }
}
