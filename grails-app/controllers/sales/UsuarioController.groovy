package sales

import grails.converters.JSON
import groovy.json.JsonSlurper
import org.codehaus.groovy.grails.web.json.JSONObject
import org.springframework.http.HttpStatus

import javax.persistence.PersistenceException

class UsuarioController {

  static allowedMethods = [save: "POST", show: "GET", "update": "PUT", "index": "GET"]

  def usuarioService

  def show() {
    Usuario usuario = Usuario.get(params.long("id"))
    if(usuario == null){
      render(status: 404, text: 'Usuario não encontrado.')
    }else {
      response.status = HttpStatus.OK.value()
      render(usuario as JSON)
    }
  }

  def index() {
    def list = Usuario.list()
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

    Usuario novoUsuario = null

    try {
      novoUsuario = new Usuario(data)
      usuarioService.save(novoUsuario)
      outputMessage = message(code: "usuario.form.message.success.creation.id", args: [novoUsuario.id])
    } catch (NullPointerException) {
      status = HttpStatus.BAD_REQUEST.value()
      outputMessage = message(code: "default.form.message.error.empty.data")
    } catch (PersistenceException cause) {
      status = HttpStatus.INTERNAL_SERVER_ERROR.value()
      outputMessage = message(code: "default.form.message.error.server")

      if (novoUsuario?.hasErrors()) {
        status = HttpStatus.BAD_REQUEST.value()
        outputMessage = message(code: "default.form.message.error.validation")
      }
    }

    response.status = status
    render(["message": message(code: outputMessage)] as JSON)
  }

  def update() {
    Usuario usuario = Usuario.findById(params.long("id"))
    JSONObject data = request.JSON
    String outputMessage = null
    int status = HttpStatus.BAD_REQUEST.value()

    try {
      usuario.login = data.optString("login", usuario.login)
      usuario.senha = data.optString("senha", usuario.senha)
      usuario.tipoDoUsuario = data.containsKey("tipoDoUsuario") == true ? data.tipoDoUsuario : usuario.tipoDoUsuario
      usuarioService.save(usuario)
      outputMessage = message(code: "usuario.message.success.update", args: [usuario.id])
      status = HttpStatus.OK.value()
    } catch (NullPointerException cause) {
      outputMessage = message(code: "default.form.message.error.empty.data")
    } catch (Exception cause) {
      outputMessage = message(code: "default.form.message.error.validation")

      if (!usuario?.hasErrors()) {
        status = HttpStatus.INTERNAL_SERVER_ERROR.value()
        outputMessage = message(code: "default.form.message.error.server")
      }
    }

    response.status = status
    render(["message": outputMessage] as JSON)
  }
  def showUserTemplate() {
    render("template": "/user")
  }
}
