package sales

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

import javax.persistence.PersistenceException

class EstoqueController {

    static allowedMethods = [save: "POST", show: "GET", "index": "GET"]

    def estoqueService


    def show() {

        Estoque estoque = Estoque.get(params.long("id"))
        if (estoque == null) {
            render(status: 404, text: 'Estoque não encontrada.')
        } else {
            response.status = HttpStatus.OK.value()
            render(estoque as JSON)
        }
    }

    def index() {

        def list = Estoque.list()
        render(list as JSON)
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


        try {
            estoqueService.save(data.id, data.quantidade)
            outputMessage = message(code: "estoque.form.message.success.creation.id", args: [data.id])
        } catch (NullPointerException) {
            status = HttpStatus.BAD_REQUEST.value()
            outputMessage = message(code: "default.form.message.error.empty.data")
        } catch (PersistenceException cause) {
            status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            outputMessage = message(code: "default.form.message.error.server")

            if (estoque?.hasErrors()) {
                status = HttpStatus.BAD_REQUEST.value()
                outputMessage = message(code: "default.form.message.error.validation")
            }
        }

        response.status = status
        render(["message": message(code: outputMessage)] as JSON)
    }

    def showStockTemplate() {
        render("template": "/stock")
    }
}
