package sales

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

import javax.persistence.PersistenceException
import javax.xml.bind.ValidationException

class LoginController {

    static allowedMethods = [save: "POST"]

    def loginService

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
            Token token = loginService.fazerLogin(data)
            response.status = status
            render(token as JSON)
        } catch (NullPointerException) {
            response.status = HttpStatus.NOT_FOUND.value()
            render(["message": "Usuário não encontrado"] as JSON)
        } catch (PersistenceException cause) {
            status = HttpStatus.INTERNAL_SERVER_ERROR.value()
            outputMessage = message(code: "default.form.message.error.server")
            if (newSale?.hasErrors()) {
                status = HttpStatus.BAD_REQUEST.value()
                outputMessage = message(code: "default.form.message.error.validation")
            }
            response.status = status
            render(["message": message(code: outputMessage)] as JSON)
        } catch (ValidationException va) {
            status = HttpStatus.NOT_FOUND.value()
            response.status = status
            render(["message": va.getMessage()] as JSON)
        }
    }

    def logout(){
        JSONObject data = request.JSON
        if (!data) {
            response.status = HttpStatus.BAD_REQUEST.value()
            render(["message": message(code: "default.form.message.error.empty.data")] as JSON)
            return
        }

        loginService.logout(data);
        response.status = HttpStatus.OK.value()
        render(["message": "Logout realizado com sucesso"] as JSON)
    }

}
