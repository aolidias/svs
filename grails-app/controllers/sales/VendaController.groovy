package sales

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

import javax.persistence.PersistenceException

class VendaController {

    static allowedMethods = [save: "POST", show: "GET", "index": "GET"]

    def vendaService





    def show() {

        Venda venda = Venda.get(params.long("id"))
        if (venda == null) {
            render(status: 404, text: 'Venda não encontrada.')
        } else {
            response.status = HttpStatus.OK.value()
            render(venda as JSON)
        }
    }

    def index() {

        def list = Venda.list()
        render(list as JSON)
    }

    def showSalesTemplate() {
        render("template": "/sale")
    }

    def save() {
        JSONObject data = request.JSON
        if (!data) {
            response.status = HttpStatus.BAD_REQUEST.value()
            render(["message": message(code: "default.form.message.error.empty.data")] as JSON)
            return
        }

        int status = HttpStatus.CREATED.value()
        String outputMessage = null

        Venda newSale = null
        def token = request.getHeader("Auth-Token");

        try {
            newSale = new Venda(data)
            newSale.data = new Date()
            vendaService.save(newSale, token)
            outputMessage = message(code: "venda.form.message.success.creation.id", args: [newSale.id])
            response.status = status
            render(["message": message(code: outputMessage)] as JSON)
        } catch (NullPointerException cause) {
            status = HttpStatus.BAD_REQUEST.value()
            outputMessage = message(code: "default.form.message.error.empty.data")
            response.status = status
            render(["message": cause.getMessage()]  as JSON)
        } catch (PersistenceException cause) {
            status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            outputMessage = message(code: "default.form.message.error.server")

            if (newSale?.hasErrors()) {
                status = HttpStatus.BAD_REQUEST.value()
                outputMessage = message(code: "default.form.message.error.validation")
            }
            response.status = status
            render(["message": message(code: outputMessage)] as JSON)
        }


    }


}
