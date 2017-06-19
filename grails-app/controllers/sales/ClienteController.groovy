package sales

import grails.converters.JSON
import groovy.json.JsonSlurper
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

import javax.persistence.PersistenceException

class ClienteController {

    static allowedMethods = [save: "POST", show: "GET", "update": "PUT", "index": "GET"]

    def clienteService

    def show() {
        Cliente cliente = Cliente.get(params.long("id"))
        if (cliente == null) {
            render(status: 404, text: 'Cliente não encontrado.')
        } else {
            response.status = HttpStatus.OK.value()
            render(cliente as JSON)
        }
    }

    def showClientsTemplate() {
        render("template": "/client")
    }

    def index() {
        def list = Cliente.list()
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

        Cliente novoCliente = null

        try {
            novoCliente = new Cliente(data)
            clienteService.save(novoCliente)
            outputMessage = message(code: "client.form.message.success.creation.id", args: [novoCliente.id])
        } catch (NullPointerException) {
            status = HttpStatus.BAD_REQUEST.value()
            outputMessage = message(code: "default.form.message.error.empty.data")
        } catch (PersistenceException cause) {
            status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            outputMessage = message(code: "default.form.message.error.server")

            if (novoCliente?.hasErrors()) {
                status = HttpStatus.BAD_REQUEST.value()
                outputMessage = message(code: "default.form.message.error.validation")
            }
        }

        response.status = status
        render(["message": message(code: outputMessage)] as JSON)
    }

    def update() {
        Cliente cliente = Cliente.findById(params.long("id"))
        JSONObject data = request.JSON
        String outputMessage = null
        int status = HttpStatus.BAD_REQUEST.value()

        try {
            cliente.nome = data.optString("nome", cliente.nome)
            cliente.telefone = data.optString("phone", cliente.telefone)
            cliente.endereco = data.optString("endereco", cliente.endereco)
            cliente.altura = data.optInt("altura", cliente.altura)
            cliente.peso = data.optInt("peso", cliente.peso)
            cliente.cpf = data.optString("cpf", cliente.cpf)
            cliente.email = data.optString("email", cliente.email)
            clienteService.save(cliente)
            outputMessage = message(code: "client.message.success.update", args: [cliente.id])
            status = HttpStatus.OK.value()
        } catch (NullPointerException cause) {
            outputMessage = message(code: "default.form.message.error.empty.data")
        } catch (Exception cause) {
            outputMessage = message(code: "default.form.message.error.validation")

            if (!cliente?.hasErrors()) {
                status = HttpStatus.INTERNAL_SERVER_ERROR.value()
                outputMessage = message(code: "default.form.message.error.server")
            }
        }

        response.status = status
        render(["message": outputMessage] as JSON)
    }
}
