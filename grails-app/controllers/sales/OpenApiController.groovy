package sales

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

import javax.persistence.PersistenceException

class OpenApiController {



    def listProducts() {

        def list = Produto.list()
        render(list as JSON)
    }
    
    def listClients() {
        def list = Cliente.list()
        render(list as JSON)
    }
    

}
